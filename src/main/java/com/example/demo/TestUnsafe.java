package com.example.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    private static final Unsafe unsafe;
    private static final long flagOffset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);

            flagOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("flag"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private boolean flag = true;
    public static void main(String[] args) throws NoSuchFieldException {
        TestUnsafe testUnsafe = new TestUnsafe();
        System.out.println("main : " + testUnsafe.flag);
        System.out.println(unsafe.getBoolean(testUnsafe, flagOffset));
        System.out.println(unsafe.getBooleanVolatile(testUnsafe, flagOffset));
        testUnsafe.flag = false;
        System.out.println("main : " + testUnsafe.flag);
        System.out.println(unsafe.getBoolean(testUnsafe, flagOffset));
        System.out.println(unsafe.getBooleanVolatile(testUnsafe, flagOffset));
    }
}

