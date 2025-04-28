package com.example.demo.exchange;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerArenaDemo {
    private static final int THREAD_COUNT = 4; // 取决于你的 CPU 核心数
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 127;
        Integer c = 128;
        Integer d = 127;
        System.out.println(a==c);
        System.out.println(b==d);
//        BlockingQueue
    }
}


