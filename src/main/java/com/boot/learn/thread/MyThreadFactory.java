package com.boot.learn.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhang.wenhan
 * @description MyThreadFactory
 * @date 2019/7/4 16:18
 */
public class MyThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    // 定义线程组名称，在 jstack 问题排查时，非常有帮助
    MyThreadFactory(String whatFeaturOfGroup) {
        namePrefix = "From UserThreadFactory's " + whatFeaturOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(task, name);
        System.out.println(thread.getName());
        return thread;
    }

    public static void main(String[] args) {
        MyThreadFactory th = new MyThreadFactory("测试线程");
        th.newThread(() -> System.out.println("卧槽 ？？？")).start();
        th.newThread(() -> System.out.println("卧槽2 ？？？")).start();
    }
}
