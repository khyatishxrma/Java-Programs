class EvenNumbers extends Thread {
    @Override
    public void run() {
        System.out.println("Thread 1: Even Numbers from 1 to 20:");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
        System.out.println();
    }
}

class OddNumbers extends Thread {
    @Override
    public void run() {
        System.out.println("Thread 2: Odd Numbers from 1 to 20:");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
        System.out.println();
    }
}

class SumNumbers implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        System.out.println("Thread 3: Sum of numbers from 1 to 20 = " + sum);
    }
}

public class MultithreadedNumberTasks {
    public static void main(String[] args) {

        EvenNumbers evenThread = new EvenNumbers();
        OddNumbers oddThread = new OddNumbers();
        Thread sumThread = new Thread(new SumNumbers());

        evenThread.start();
        oddThread.start();
        sumThread.start();

        try {
            evenThread.join();
            oddThread.join();
            sumThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\nAll threads completed execution.");
    }
}
