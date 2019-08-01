package com.boot.learn.thread;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newCachedThreadPool();

        Callable<String> callable = () -> "Hello";

        Future<String> future = es.submit(callable);
        System.out.println(future.get());

        FutureTask<String> futureTask = new FutureTask<>(() -> "World");
        new Thread(futureTask, "B").start();
        System.out.println(futureTask.get());

    }

}
