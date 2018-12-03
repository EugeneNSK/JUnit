package com.java.zonov.junit.db;

import java.sql.SQLException;

//Бизнес логика для продакшена
public class DBaseImpl implements DBase {

    @Override
    public String find(int id){
        System.out.println("Получили id: " + id );
        if (id<100){
            return "Test name";
        }
        else return null;

    }

    @Override
    public int save(int id, String s) throws SQLException {
        System.out.println("Save: " + id);
        if (id<10) {
            return 1;
        }
        else throw new SQLException("SQL Error");
    }
}
