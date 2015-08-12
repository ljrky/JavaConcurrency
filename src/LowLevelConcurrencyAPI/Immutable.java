package LowLevelConcurrencyAPI;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Immutable {

    public static void main(String[] args) {

        final ImmutableCounter[] counter = {new ImmutableCounter(0)};

        Executor executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Counter is : " + counter[0].getCounter());
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Counter is : " + counter[0].getCounter() + " before Increase!");
                    counter[0] = counter[0].Increase();
                    System.out.println("Counter is : " + counter[0].getCounter() + " after Increase!");
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Counter is : " + counter[0].getCounter() + " before Decrease!");
                    counter[0] = counter[0].Decrease();
                    System.out.println("Counter is : " + counter[0].getCounter() + " after Decrease!");
                }
            });
        }
    }

}


class ImmutableCounter{

    final private int counter;

    ImmutableCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter(){
        return counter;
    }

    public ImmutableCounter Increase(){
        return  new ImmutableCounter(this.counter + 1);
    }

    public ImmutableCounter Decrease(){
        return  new ImmutableCounter(this.counter - 1);
    }

}