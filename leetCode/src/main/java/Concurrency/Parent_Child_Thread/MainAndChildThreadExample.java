package Concurrency.Parent_Child_Thread;

class MainAndChildThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread starts.");

        // Creating a child thread
        Thread childThread = new Thread(() -> {
            System.out.println("Child thread starts.");
            // Some processing in the child thread
            System.out.println("Child thread ends.");
        });

        // Starting the child thread
        childThread.start();

        // Some processing in the main thread
        System.out.println("Main thread continues.");

        // Waiting for the child thread to finish
        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ends.");
    }
}
