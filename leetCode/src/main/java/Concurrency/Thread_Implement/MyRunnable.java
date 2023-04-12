package Concurrency.Thread_Implement;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        // code to be executed in the new thread
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }
}
