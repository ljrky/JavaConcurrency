package LowLevelConcurrencyAPI;

public class ThreadInterference {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new IncreaseCounter(counter));
        Thread t2 = new Thread(new IncreaseCounter(counter));
        Thread t3 = new Thread(new IncreaseCounter(counter));

        Thread t4 = new Thread(new IncreaseCounter(counter));
        Thread t5 = new Thread(new IncreaseCounter(counter));
        Thread t6 = new Thread(new IncreaseCounter(counter));

        t1.start();
        t1.join();
        System.out.println(counter.value());
        t2.start();
        System.out.println(counter.value());
        t3.start();
        System.out.println(counter.value());
        t4.start();
        System.out.println(counter.value());
        t5.start();
        System.out.println(counter.value());
        t6.start();
        System.out.println(counter.value());

        Thread.sleep(3000);
        System.out.println(counter.value());
    }


    static class Counter{
    private int c = 0;

    public void increment(){
        c++;
    }

    public void decrement(){
        c--;
    }

    public int value(){
        return c;
    }
}

    static class IncreaseCounter implements Runnable{

        Counter counter;
        public IncreaseCounter(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is running");
            this.counter.increment();
            System.out.println("Thread : " + Thread.currentThread().getName() + " is ended");
        }
    }

    static class DecreaseCounter implements Runnable{

        Counter counter;
        public DecreaseCounter(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            this.counter.decrement();
        }
    }

}