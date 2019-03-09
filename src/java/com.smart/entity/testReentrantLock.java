package com.smart.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testReentrantLock {
    private Lock lock = new ReentrantLock();

    public void test(){
        lock.lock();
    }
}
