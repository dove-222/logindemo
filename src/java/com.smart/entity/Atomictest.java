package com.smart.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomictest {
    public final static AtomicInteger CONCURRENT_INTEGER = new AtomicInteger(2);

    public static void main (String[] args){
       Thread[] threads = new Thread[10];

       for(int i = 0; i < 10; i ++){
           threads[i] = new Thread(){

               public void run(){
                   int num = CONCURRENT_INTEGER.addAndGet(2);
                   System.out.println("线程："+Thread.currentThread().getName()+"获取值后加2，结果是"+num);
               }
           };
       }

       for(Thread t :threads){
           t.start();
       }

       for (Thread t : threads){
           try {
               t.join();
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
       }
}
