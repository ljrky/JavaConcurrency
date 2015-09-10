package JavaOfficalSample.HighLevelConcurrencyObjects;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;


public class StylesOfConcurrency {
    public static void main(String[] args) {
        System.out.println("This is styles of java concurrency!");

        //ThreadSample Sample
        System.out.println("Launch ThreadSample Sample");
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadSample()).start();
        }

        //Executor Sample with Fixed ThreadPool
        //New an Executor and define the number of threads, here is 4
        System.out.println("Launch Fixed ThreadSample Pool Sample");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ThreadSample());
        }
        executorService.shutdown();

        //Executor Sample with cached ThreadPool
        //New an Executor with cached thread pool, fit short life cycle task best as it could re-use thread
        System.out.println("Launch Cached ThreadSample Pool Sample");
        ExecutorService executorServiceForCachedPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorServiceForCachedPool.execute(new ThreadSample());
        }
        executorServiceForCachedPool.shutdown();

        //Executor Sample with Callable ThreadSample
        System.out.println("Launch Callable Sample");
        ExecutorService executorServiceForCallable = Executors.newCachedThreadPool();
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        for (int i = 0; i < 5; i++) {
            set.add(executorServiceForCallable.submit(new CallableSample()));
        }
        for (Future<Integer> future : set){
            try {
                System.out.println("Callable result is : " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorServiceForCallable.shutdown();
    }
}

class ThreadSample implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : ended");
    }
}

class CallableSample implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " : started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : ended");
        return new Random().nextInt(30);
    }
}



