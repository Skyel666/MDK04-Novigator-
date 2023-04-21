import java.lang.reflect.Array;
import java.util.ArrayList;

public class NavThread extends Thread {            // potok novigatora
    float time;
    float currentDistance;
    float distance;
    float speed;
    ArrayList<Float> speedMassive;
    CarThread car;

    NavThread(String name, float time, float currentDistance, float distance, float speed, CarThread car) {
        super(name);
        this.time = time;
        this.currentDistance = currentDistance;
        this.distance = distance;
        this.speed = speed;
        this.speedMassive = new ArrayList<Float>();
        this.car = car;
    }
    public int ReturnSum(){
        int i = 0;
        for (float a : speedMassive){
            i+=a;
        }
        return i;
    }
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Средняя cкорость : " + String.format("%.1f", ReturnSum() / speedMassive.size()) + " км/ч");
        System.out.println("Проехать осталось : " + String.format("%.1f", car.distance - car.currentDistance) + " км "
                + String.format("%.1f", (car.distance - car.currentDistance) / car.speed) + " ч");
        run();
    }
}
