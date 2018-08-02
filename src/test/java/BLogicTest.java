import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import javax.rmi.CORBA.Stub;

import static org.junit.Assert.*;

public class BLogicTest {

    Mockery context = new Mockery();


    @Test
    public void editItem() {
//        System.out.println("edit Item Test");
        int id = 0;
        String newName = "";

        DBaseInt db = context.mock(DBaseInt.class); //создали заглушку из интерфейса. Мок сам создаст реализацию

        context.checking(new Expectations(){{ //ожидания. Что будет происходить. Вызов каких методов и т.п.
           oneOf (db).find(id);
           oneOf (db).save(id,newName); will(returnValue(1));
        }});



        BLogic instance = new BLogic();
        int expResult = 1;
        int result = instance.editItem(id,newName,db);
        assertEquals(expResult,result);
    }
}