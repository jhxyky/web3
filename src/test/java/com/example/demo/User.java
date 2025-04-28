package com.example.demo;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class User {

    private String name = "John Doe";
    private int age = 30;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
//        //退押金生成pxt订单编号
        DateTime dt = new DateTime();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String number = dt.toString("yyyyMMddHHmmss") + timeStamp.substring(timeStamp.length() - 4, timeStamp.length()) + uuid.substring(0, 11);
        System.out.println("pxt" + number);
    }
}
