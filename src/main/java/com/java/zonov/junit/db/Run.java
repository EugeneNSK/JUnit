package com.java.zonov.junit.db;

import java.sql.SQLException;

public class Run {
    public static void main(String[] args) throws SQLException {

        MyBLogic myBLogic = new MyBLogic();
        myBLogic.editItem(5,"abc", new DBaseImpl());
    }
}
