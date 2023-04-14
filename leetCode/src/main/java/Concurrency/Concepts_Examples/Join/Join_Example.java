package Concurrency.Concepts_Examples.Join;

class Join_Example {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread T1 is running");
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // Wait for T1 to complete before running T2
                System.out.println("Thread T2 is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join(); // Wait for T2 to complete before running T3
                System.out.println("Thread T3 is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
