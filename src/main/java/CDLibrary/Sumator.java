package CDLibrary;

public class Sumator implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println("suma " + sum);
    }
}
