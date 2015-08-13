package IssuesInThread;

public class MemoryConsistencyError {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Memory Consistency Error");

        Counter counter = new Counter();

        Thread threadA = new Thread(new ThreadIncreaseCounter(counter));
        Thread threadB = new Thread(new ThreadPrintCounter(counter));
        Thread threadC = new Thread(new ThreadIncreaseCounter(counter));
        Thread threadD = new Thread(new ThreadPrintCounter(counter));
        Thread threadE = new Thread(new ThreadIncreaseCounter(counter));
        Thread threadF = new Thread(new ThreadPrintCounter(counter));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();
    }

    static class Counter {
        private int c = 0;

        public void increment() {
            c++;
        }

        public int value() {
            return c;
        }
    }

    static class ThreadIncreaseCounter implements Runnable {

        Counter counter;

        public ThreadIncreaseCounter(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName() + " increases counter!");
            System.out.println("Counter is : " + counter.c + " before increase!");
            this.counter.increment();
            System.out.println("Counter is : " + counter.c + " after increase!");
        }
    }

    static class ThreadPrintCounter implements Runnable {

        Counter counter;

        public ThreadPrintCounter(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName() + " print counter!");
            this.counter.value();
        }

    }


}