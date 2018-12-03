package com.java.zonov.junit.db;

import java.sql.SQLException;

public class MyBLogic {
    public int editItem(int id, String newName, DBase db) throws SQLException { //интерфейс вместо прямой реализации
        System.out.println("Edit item " + id);

        String itemName = db.find(id);

        if (itemName!=null){
            itemName=newName;
            int res = db.save(id,itemName);
            if (res==2){
                System.out.println("res=2");
            }
        }
        else throw new IllegalArgumentException("record with " + id+ "not good");
        return 1;
    }
}
