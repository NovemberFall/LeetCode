package Concurrency.Concepts_Examples.Join;

class Example1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running...");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                System.out.println("Thread 2 is running after Thread 1 completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }
}
