package com.boot.learn.thread;

import java.util.concurrent.*;

/**
 * @author zhang.wenhan
 * @description ThreadPoolTest
 * @date 2019/7/11 16:41
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//        threadPoolExecutor.execute(new Jo);

    }

}
