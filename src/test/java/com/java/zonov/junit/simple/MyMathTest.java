package com.java.zonov.junit.simple;

import com.java.zonov.junit.simple.MyMath;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class) //для запуска тестов с параметроми, определенными в @Parameterized.Parameters
public class MyMathTest {

//    Начало -------------- для работы с набором параметров
    int a,b,expRes;

    public MyMathTest(int a, int b, int expRes) {
        this.a = a;
        this.b = b;
        this.expRes = expRes;
    }

    @Parameterized.Parameters //   Общее правило для всех тестовых методов
    public static Collection number(){
        return Arrays.asList(new Object[][] {{1,2,3}, {4,5,9}, {10,2,12}});
    }
//    Конец -------------- для работы с набором параметров

    @Rule //правило для всех тестов
    public TestRule timeout = new Timeout(100);


    @Test //тест работающий с набором параметров
    public void add() throws InterruptedException {
        int res = MyMath.add(a,b);
        Assert.assertEquals(expRes,res);
    }

    @Test
    @Ignore //не запускать тест, т.к используем единичные параметры
    public void add2() throws InterruptedException {
        int a = 1;
        int b = 20;
        int expRes = 23;
        int res = MyMath.add(a,b);
        Assert.assertEquals(expRes,res);
    }

    @Test
    @Ignore //не запускать тест, т.к используем набор параметор, а он применяется для всех тестов
    public void div() throws InterruptedException {
        int a = 8;
        int b = 2;
        int expRes = 4;
        int res = MyMath.div(a,b);
        Assert.assertEquals(expRes,res);
    }

//  По результатам теста ожидается исключение и это НОРМАЛЬНО
    @Test(expected = ArithmeticException.class)
    @Ignore //не запускать тест, т.к используем набор параметор, а он применяется для всех тестов
    public void div2() throws InterruptedException {
        int a = 8;
        int b = 0;
        int expRes = 4;
        int res = MyMath.div(a,b);
        Assert.assertEquals(expRes,res);
    }
}