package LowLevelThead;

public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is sample of synchronized method");

        SynchronizedCounter counter = new SynchronizedCounter();

        Thread threadA = new Thread(new IncreaseSynchronizedThread(counter));
        Thread threadB = new Thread(new IncreaseSynchronizedThread(counter));

        Thread threadC = new Thread(new DecreaseSynchronizedThread(counter));
        Thread threadD = new Thread(new DecreaseSynchronizedThread(counter));

        threadA.start();
        counter.value();

        threadB.start();
        counter.value();

        threadC.start();
        counter.value();

        threadD.start();
        counter.value();
    }


    static class SynchronizedCounter{
        private int c = 0;

        public synchronized void increment(){
            System.out.println(Thread.currentThread().getName() + " is calling increment method, and counter is " + c);
            c++;
            System.out.println(Thread.currentThread().getName() + " finished increment method, and counter is " + c);
        }

        public synchronized void decrement(){
            System.out.println(Thread.currentThread().getName() + " is calling decrement method, and counter is " + c);
            c--;
            System.out.println(Thread.currentThread().getName() + " finished decrement method, and counter is " + c);
        }

        public synchronized String value(){
            return "counter is :" + c;
        }
    }

    static class IncreaseSynchronizedThread implements Runnable{

        SynchronizedCounter counter;

        public IncreaseSynchronizedThread(SynchronizedCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    static class DecreaseSynchronizedThread implements Runnable{
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

