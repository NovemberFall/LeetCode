package Concurrency.Thread_Implement;

class MyThread extends Thread{
    @Override
    public void run() {
        // code to be executed in the new thread
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
