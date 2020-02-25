package com.naver.ex;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class MyDeque implements Serializable {

    private Object[] datas;
    private int head;
    ReentrantLock lock;

    public MyDeque(int length) throws Exception {
        if(length <= 0){
            throw new Exception("长度必须大于0");
        }
        datas = new Object[length];
        head  = 0;
        lock = new ReentrantLock();
    }

    public void push(Object data){
        ReentrantLock lock = this.lock;
        lock.lock();
        try{
            if(head >= datas.length){
                //扩容,复制数组即可

            }
            datas[head++] = data;
        }finally {
            lock.unlock();
        }

    }

    public Object pop (){
        ReentrantLock lock = this.lock;
        lock.lock();
        try{
            Object data =  datas[head];
            datas[head--] = null;
            return data;
        }finally {
            lock.unlock();
        }

    }

    public Object peek(){
        ReentrantLock lock = this.lock;
        lock.lock();
        try{
            return datas[head];
        }finally {
            lock.unlock();
        }
    }

    public boolean empty(){
        ReentrantLock lock = this.lock;
        lock.lock();
        try{
            return this.head == 0;
        }finally {
            lock.unlock();
        }
    }
}
