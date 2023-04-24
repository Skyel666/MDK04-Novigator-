import java.util.Random;

public class CarThread extends Thread {// potok mawini
    float speed = 0;
    int maxSpeed = 300;
    private boolean isWorking = true;
    NavThread navigator;
    CarThread(String name) {
        super(name);
    }

    public void run() {
        try {
            if (isWorking){
                navigator.speedMassive.add(speed);
                if (this.speed < this.maxSpeed && navigator.currentDistance <= navigator.distance) {
                    this.speed += 30;
                    navigator.currentDistance += speed / 3600;
                    Thread.sleep(1000);
                }
                else{
                    this.speed = this.maxSpeed - new Random().nextInt(maxSpeed-2,maxSpeed+2);
                    navigator.currentDistance += speed / 3600;
                    Thread.sleep(1000);
                }
                if (navigator.currentDistance >= navigator.distance) {
                    isWorking = false;
                }
                run();
            }
        else {
            isWorking = false;
            navigator.stopNavigator();
            interrupt();
            }
        } catch (Exception e) {

        }
    }
}
