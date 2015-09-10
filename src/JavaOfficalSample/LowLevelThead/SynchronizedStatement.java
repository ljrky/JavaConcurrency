package JavaOfficalSample.LowLevelThead;

public class SynchronizedStatement {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is sample of synchronized statement");

        SynchronizedCounter counter = new SynchronizedCounter();

        Thread threadA = new Thread(new IncreaseSynchronizedThread(counter));
        Thread threadB = new Thread(new IncreaseSynchronizedThread(counter));

        Thread threadC = new Thread(new DecreaseSynchronizedThread(counter));
        Thread threadD = new Thread(new DecreaseSynchronizedThread(counter));

        threadA.start();

        threadB.start();

        threadC.start();

        threadD.start();
    }


    static class SynchronizedCounter{
        private int add = 0;
        private int remove = 0;

        public void increment(){
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + " is calling increment method, and add is " + add);
                add++;
                System.out.println(Thread.currentThread().getName() + " finished increment method, and add is " + add);
            }
        }

        public void decrement(){
            synchronized(this) {
                System.out.println(Thread.currentThread().getName() + " is calling decrement method, and remove is " + remove);
                remove--;
                System.out.println(Thread.currentThread().getName() + " finished decrement method, and remove is " + remove);
            }

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

