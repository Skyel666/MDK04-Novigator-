import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сколько необходимо проехать [км]: ");
        CarThread CarThread = new CarThread("CarThread");
        NavThread thread = new NavThread("NavThread", CarThread, sc.nextFloat());
        CarThread.navigator = thread;
        thread.start();
        CarThread.start();
    }
}