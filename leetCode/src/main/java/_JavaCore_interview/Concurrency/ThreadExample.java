package _JavaCore_interview.Concurrency;

class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // Create the child thread
        Thread childThread = new Thread(() -> {
            System.out.println("Child thread started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted");
            }
            System.out.println("Child thread ended");
        });

        // Start the child thread
        childThread.start();

        // Put the parent thread to sleep for 2 seconds
        System.out.println("Parent thread going to sleep");
        Thread.sleep(2000);

        // Check if the child thread is still alive
        if (childThread.isAlive()) {
            System.out.println("Child thread is still alive");
        }

        // Stop the child thread
        childThread.interrupt();
    }
}

