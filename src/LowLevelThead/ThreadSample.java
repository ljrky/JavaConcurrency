package LowLevelThead;

public class ThreadSample {
    public static void main(String args[]) throws InterruptedException {

        //Maxim wait time
        long patience = 1000 * 10;

        threadMessage("LowLevelThead.MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for LowLevelThead.MessageLoop thread to finish");
        while(t.isAlive()){
            threadMessage("Still waiting...");
            t.join(1000);

            if ((System.currentTimeMillis() - startTime) > patience) {
                System.out.println("Thread forces to die");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finally!");
    }


    private static void threadMessage(String message){
        System.out.println(Thread.currentThread().getName() + " is running " + message);
    }
}

class MessageLoop implements Runnable{
    @Override
    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        //InterruptedException may happen anytime, in order to ensure thread end properly, it
        //good to have all instruments in try catch
        try {
            for (int i = 0; i < importantInfo.length; i++) {
                Thread.sleep(4000);
                System.out.println(importantInfo[i]);
            }
        }catch (InterruptedException e) {
            System.out.println("reach 10 seconds limitation");
        }
    }
}


