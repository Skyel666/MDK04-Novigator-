import java.lang.reflect.Array;
import java.util.ArrayList;

public class NavThread extends Thread {            // potok novigatora
    float currentDistance;
    float distance;
    private boolean isWorking = true;
    ArrayList<Float> speedMassive;
    CarThread car;

    NavThread(String name, CarThread car, float distance) {
        super(name);
        this.distance = distance;
        this.speedMassive = new ArrayList<Float>();
        this.car = car;
    }
    public void stopNavigator(){
        isWorking = false;
        interrupt();
    }
    public float ReturnSum(){
        int i = 0;
        for (float a : speedMassive){
            i+=a;
        }
        return i;
    }
    public void run() {
        if (isWorking){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Средняя cкорость : " + String.format("%.1f", ReturnSum() / speedMassive.size()) + " км/ч");
            System.out.println("Проехать осталось : " + String.format("%.1f", distance - currentDistance) + " км "
                    + String.format("%.1f", (distance - currentDistance) / car.speed) + " ч");
            run();
        }
        else {

        }
    }
}
