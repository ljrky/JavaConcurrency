package JavaOfficalSample.LowLevelThead;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ThreadSample Static Functions");

        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

//        for (int i = 0; i < importantInfo.length; i++) {
//            System.out.println("ThreadSample is sleeping");
//            ThreadSample.sleep(4000);
//            System.out.println(importantInfo[i]);
//        }

//        ThreadSample InterruptedThread = new ThreadSample(new JavaOfficalSample.LowLevelThead.InterrupteThread());
//        InterruptedThread.start();
//        System.out.println("ThreadSample status is : " + InterruptedThread.isInterrupted());
//        InterruptedThread.interrupt();

//        ThreadSample InterruptedByOtherThread = new ThreadSample(new JavaOfficalSample.LowLevelThead.InterruptedByOthers());
//        InterruptedByOtherThread.start();
//        System.out.println("ThreadSample's interrupt status is : " + InterruptedByOtherThread.isInterrupted());
//        InterruptedByOtherThread.interrupt();
//        System.out.println("ThreadSample's interrupt status is : " + InterruptedByOtherThread.isInterrupted());

        Thread ThrowInterruptedExceptionThread = new Thread(new InterruptedThrowException());
        ThrowInterruptedExceptionThread.start();
        ThrowInterruptedExceptionThread.interrupt();
    }
}

class InterrupteThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
        }
    }
}

class InterruptedByOthers implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            if(Thread.interrupted()){
                System.out.println("thread interrupted by others");
            }
        }
    }
}

class InterruptedThrowException extends Thread {
    @Override
    public void run() {
        if (Thread.interrupted()) {
            System.out.println("Throw exception!");
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}