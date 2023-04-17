package Concurrency.Parent_Child_Thread;

class ThreadExample {
    public static void main(String[] args) {
        // create the parent thread
        System.out.println("Main thread starting...");
        Thread parentThread = Thread.currentThread();

        // create a child thread
        Thread childThread = new Thread(new ChildThread());
        childThread.start();

        // print some messages from the parent thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread executing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Main thread ending.");
    }
}

class ChildThread implements Runnable {
    public void run() {
        System.out.println("Child thread starting...");
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread executing...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Child thread interrupted.");
            }
        }
        System.out.println("Child thread ending.");
    }
}

