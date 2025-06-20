class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("My Thread: " + i);

            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                System.out.println("누가 꺠웠어?");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        thread.start();

        System.out.println("일어나!");
        thread.interrupt();
    }
}