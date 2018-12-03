package com.java.zonov.junit.db;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MyBLogicTest {

    //контейнер управляющий генерацие объектов имитации
    Mockery ctx = new Mockery();

    @Test
    public void editItem() throws SQLException {
        int id=5;
        String newName = "world";

//      Работа с Mock объектом *** начало
        DBase db = ctx.mock(DBase.class); // 1. Создание объекта имитации
        ctx.checking(new Expectations(){{ // 2. Указание ожиданий(действий) от имитации
            oneOf(db).find(id);           // - на объекте db один раз вызывается метод find
            oneOf(db).save(id,newName);   // - на объекте db один раз вызывается метод save
            will(returnValue(2));  // - ожидаем, что результат будет равен 2
            }});
//      Работа с Mock объектом *** конец

        MyBLogic myBLogic = new MyBLogic();
        int expResult = 1;
        int result = myBLogic.editItem(id,newName,db);
        assertEquals(expResult, result);
    }
}