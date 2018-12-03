package com.java.zonov.junit.simple;

public class MyMath {

    public static int add(int a, int b) throws InterruptedException {
        Thread.sleep(10);
        return a+b;
    }

    public static int div(int a, int b) throws InterruptedException {
        Thread.sleep(20);
        return a/b;
    }
}
