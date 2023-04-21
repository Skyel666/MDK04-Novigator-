import java.util.Random;

public class CarThread extends Thread {// potok mawini
    float distance;
    float speed = 0;
    float currentDistance = 0;
    int maxSpeed = 100;
    float time = 0;

    CarThread(String name, float distance) {
        super(name);
        this.distance = distance;
    }

    public void run() {
        try {
            if (this.speed < this.maxSpeed && this.currentDistance <= this.distance) {
                this.speed += 5;
                this.currentDistance += this.speed;
                Thread.sleep(1000);
            }
            else{
                this.speed = this.maxSpeed - new Random().nextInt(maxSpeed-2,maxSpeed+2);
                this.currentDistance += this.speed;
                if (this.currentDistance >= this.distance) {
                    throw new Exception();
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Приехали");
        }
    }
}
