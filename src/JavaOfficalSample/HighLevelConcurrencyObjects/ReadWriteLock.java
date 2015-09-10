package JavaOfficalSample.HighLevelConcurrencyObjects;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) {
        System.out.println("This is a simple sample of ReadWriteLock!");

        Data data = new Data();

        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.setData(new Random().nextInt(30));
                    }
                }
            }.start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.getData();
                    }
                }
            }.start();
        }
    }
}

class Data{
    private int data;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void getData() {
        try{
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " start reading data");
            System.out.println(Thread.currentThread().getName() +" read data : " + this.data);
        }
        finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void setData(int data) {
        try{
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " start writing data");
            this.data = data;
            System.out.println(Thread.currentThread().getName() +" wrote data : " + this.data);
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
