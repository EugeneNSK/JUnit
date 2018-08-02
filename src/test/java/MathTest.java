import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class) //1. необходимо указыть при использовании @Parameterized.Parameters
public class MathTest {
    int x, y, expRes; //2. переменные для хранения начальных параметров

    public MathTest(int x, int y, int expRes) { //3. Конструктор для инициализации параметров @Parameterized.Parameters
        this.x = x;
        this.y = y;
        this.expRes = expRes;
    }

    @Rule //правило для всех тестовых методов
    public TestRule timeOut = new Timeout(1000);

    @Parameterized.Parameters //набор входных данных для всех тестовых методов
    public static Collection numbers(){
        return Arrays.asList(
                new Object[][]{
                        {1,2,3},
                        {5,7,12},
                        {3,3,6}});
    }


    @Test
    public void add() {
        System.out.println("ADD with @Parameterized.Parameters");

        int result = Math.add(x,y);
        assertEquals(expRes,result);
    }

    @Ignore
    @Test
    public void div() {
        System.out.println("ADD with @Parameterized.Parameters");

        int result = Math.div(x,y);
        assertEquals(expRes,result);
    }




    @Test
    public void simpleAdd() {
        System.out.println("Simple ADD");
        int x = 2;
        int y = 3;
        int expRes = 5;
        int result = Math.add(x,y);
        assertEquals(expRes,result);
    }



    @Test
    public void simpleDiv() {
        System.out.println("Simple DIV");
        int x = 6;
        int y = 2;
        int expRes = 3;
        int result = Math.div(x,y);
        assertEquals(expRes,result);
    }

    @Test(expected = ArithmeticException.class) // если мы хотим указать, что ожидаем ошибку и это нормально!
    public void ExcDiv() {
        System.out.println("ExcDIV");
        int x = 6;
        int y = 0;
        int expRes = 3;
        int result = Math.div(x,y);
        assertEquals(expRes,result);
    }

}