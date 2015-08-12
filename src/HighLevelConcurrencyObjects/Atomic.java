package HighLevelConcurrencyObjects;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static void main(String[] args) {
        System.out.println("This is sample of java atomic type!");

        AtomicCounter Counter = new AtomicCounter();

        Executor executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Increasing Counter is : " + Counter.getCounter());
                    Counter.incrementCounter();
                    System.out.println("Increased Counter is : " + Counter.getCounter());
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Decreasing Counter is : " + Counter.getCounter());
                    Counter.decrementCounter();
                    System.out.println("Decreased Counter is : " + Counter.getCounter());
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Setting Counter is : " + Counter.getCounter());
                    Counter.setCounter(new Random().nextInt(100));
                    System.out.println("Set Counter is : " + Counter.getCounter());
                }
            });
        }


        System.out.println("Eventually Counter is : " + Counter.getCounter());
    }
}

class AtomicCounter{
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getCounter() {
        return this.counter.get();
    }

    public void incrementCounter() {
        this.counter.getAndIncrement();
    }

    public void decrementCounter(){
        this.counter.getAndDecrement();
    }

    public void setCounter(int value){
        this.counter.getAndSet(value);
    }
}
