package com.example.demo;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = Demo2ApplicationTests.class)
public class Demo2ApplicationTests {
    private static final Integer[] E_ZHAN_ID = {
            134496,134494,134508,146911,152189,152184,152093,152162,152176,152107,152131,152081,152051,152171,152147,
            152071,152062,152117,152186,152127,152178,157774,152103,116205,116219,116218,116227,116244,116236,116238,
            116231,116235,116216
    };

    @Test
    public void contextLoads() {
//        int a = 0b1010; // 4位的二进制数 1010
//        int b = 0b0111; // 4位的二进制数 0111
//
//        a = a << 4; // 左移 4 位
//
//        int result = a | b; // "or" 操作
//
//        System.out.println(Integer.toBinaryString(result)); // 输出二进制字符串形式的结果

        long c = 0b0000;
        long d = 0b1111;
//        d = d >> 2;
//        long return1 println= c|d;
        System.out.println(Long.toBinaryString(d));
//        System.out.println(Long.toBinaryString(return1));

        Person person1 = new Person("Alice", 20);
        Person person2 = person1;  // 浅拷贝
        person2.name = "Bob";

        System.out.println(person1.name);  // 输出 "Bob"
        System.out.println(person2.name);  // 输出 "Bob"
    }

    @Test
    public void test2(Man man) {
        Person person1 = new Person("Alice", 20);
        Person person2 = person1;  // 浅拷贝
        person2.name = "Bob";

        System.out.println(person1.name);  // 输出 "Bob"
        System.out.println(person2.name);  // 输出 "Bob"
    }

    public Man test3(List<Man> mans) {
        Jiao jiao = (Jiao) mans.get(0);
        System.out.println(jiao.getSex());
        return jiao;
    }

}
