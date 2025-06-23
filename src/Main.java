class SumThread extends Thread {
    private int[] array;
    private int start, end;
    private int partialSum = 0;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[100];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int numThreads = 4;
        int chunkSize = numbers.length / numThreads;

        SumThread[] threads = new SumThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? numbers.length : start;

            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
        }
    }
}