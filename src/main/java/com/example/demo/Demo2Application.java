package com.example.demo;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Demo2Application {



    public static void main(String[] args) throws InterruptedException {
        // 使用注解上下文创建并初始化应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 从上下文中获取User类的Bean
        User user = context.getBean(User.class);

        // 打印获取到的User信息
        System.out.println(user);

        // 关闭上下文
        context.close();
    }


}
