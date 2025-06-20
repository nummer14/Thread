class SumRunnable implements Runnable {
    private final int[] numbers;

    public SumRunnable(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sum = 0;

        for(int n: numbers) {
            sum += n;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println(Thread.currentThread().getName() + " - Sum: " + sum);
    }
}

public class Main {
    public static void main(String[] args) {
    }
}