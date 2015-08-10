package LowLevelConcurrencyAPI;

public class Volatile {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is sample of LowLevelConcurrencyAPI.Volatile Keyword");

        SynchronizedCounter counter = new SynchronizedCounter();

        Thread threadA = new Thread(new IncreaseSynchronizedThread(counter));
        Thread threadB = new Thread(new IncreaseSynchronizedThread(counter));
        Thread threadC = new Thread(new IncreaseSynchronizedThread(counter));
        Thread threadD = new Thread(new IncreaseSynchronizedThread(counter));

        Thread threadE = new Thread(new DecreaseSynchronizedThread(counter));
        Thread threadF = new Thread(new DecreaseSynchronizedThread(counter));
        Thread threadG = new Thread(new DecreaseSynchronizedThread(counter));
        Thread threadH = new Thread(new DecreaseSynchronizedThread(counter));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();
        threadG.start();
        threadH.start();
    }


    static class SynchronizedCounter {
        private volatile int counterAdd = 0;
        private volatile int counterRemove = 0;

        public void increment() {
            System.out.println(Thread.currentThread().getName() + " is calling increment method, and counter is " + counterAdd);
            counterAdd++;
            System.out.println(Thread.currentThread().getName() + " finished increment method, and counter is " + counterAdd);
        }

        public void decrement() {
            System.out.println(Thread.currentThread().getName() + " is calling decrement method, and counter is " + counterRemove);
            counterRemove--;
            System.out.println(Thread.currentThread().getName() + " finished decrement method, and counter is " + counterRemove);
        }

    }

    static class IncreaseSynchronizedThread implements Runnable {

        SynchronizedCounter counter;

        public IncreaseSynchronizedThread(SynchronizedCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    static class DecreaseSynchronizedThread implements Runnable {
        SynchronizedCounter counter;

        public DecreaseSynchronizedThread(SynchronizedCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.decrement();
        }
    }
}

