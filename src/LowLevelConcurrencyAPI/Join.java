package LowLevelConcurrencyAPI;

public class Join {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
        Thread threadA = new Thread(new OneThread());
        threadA.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is end");
    }
}

class OneThread implements Runnable{
    @Override
    public void run() {
        System.out.println("1st thread is running");
        Thread anotherThread = new Thread(new AnotherThread());
        anotherThread.start();
        try {
            //Join ensure current thread wait until the another thread ended
            anotherThread.join();
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("1st thread is end");
    }
}

class AnotherThread implements Runnable{
    @Override
    public void run() {
        System.out.println("2nd thread is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("2nd thread is end");
    }
}
