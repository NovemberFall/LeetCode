package Concurrency.Thread_Implement;

class myThread extends Thread{

//    public static void main(String[] args) throws InterruptedException {
//        myThread t = new myThread(){
//            @Override
//            public void run(){
//                System.out.println("Hello 1");
//            }
//        };
//        t.start();
//        System.out.println("Hello 2");
//        t.join();
//        System.out.println("Hello 3");
//    }




    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println("Hello1");
            }
        };
        t.start();
        System.out.println("Hello2");
    }
}
