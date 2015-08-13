package HighLevelConcurrencyObjects;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HowToUseLock {
    public static void main(String[] args) {
        System.out.println("This is a simple sample of lock!");

        Outputter outputer = new Outputter();

        new Thread(){
            @Override
            public void run() {
                outputer.output("keyu ruan");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                outputer.output("ljrky");
            }
        }.start();
    }
}

class Outputter {
    private Lock lock = new ReentrantLock();
    public void output(String name){
        //get lock
        try{
            lock.lock();
            System.out.println("Thread : " + Thread.currentThread().getName() + " started!");
            for(int i = 0; i < name.length(); i++){
                System.out.print(name.charAt(i));
            }
            System.out.println("\n" +
                    "Thread : " + Thread.currentThread().getName() + " ended!");
        }finally {
            lock.unlock();
        }
    }
}
