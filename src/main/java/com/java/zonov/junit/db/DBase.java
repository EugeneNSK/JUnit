package com.java.zonov.junit.db;

import java.sql.SQLException;

public interface DBase {

    String find(int id);
    int save(int id, String s) throws SQLException;
}
