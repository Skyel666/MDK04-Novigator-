import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сколько необходимо проехать [км]: ");
        CarThread CarThread = new CarThread("CarThread",sc.nextInt());
        NavThread thread = new NavThread("NavThread", CarThread.time, CarThread.currentDistance, CarThread.distance, CarThread.speed, CarThread);
        thread.start();
        System.out.println("Ваш путь : " + CarThread.distance + "[км]");
        CarThread.start();

    }
}