package com.example.demo.exchange;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                String messageFromThreadB = exchanger.exchange("Message from Thread A");
                System.out.println("Thread A received: " + messageFromThreadB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                String messageFromThreadA = exchanger.exchange("Message from Thread B");
                System.out.println("Thread B received: " + messageFromThreadA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-B").start();
    }
}

