package org.scriptobi.openschoolswing.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repo_Base {
    protected static int doInsert(Connection cnx, String query, String key) {
        int idf = 0;
        String[] keys = new String[]{ key };
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(query, keys);
            ResultSet res = stm.getGeneratedKeys();
            if(res.next()) {
                idf = res.getInt(1);
            }
            stm.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return idf;
    }

    protected static int doInsert(Connection cnx, String query) {
        int stat = 0;
        try {
            Statement stm = cnx.createStatement();
            stat = stm.executeUpdate(query);
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stat;
    }
    protected static int doUpdate(Connection cnx, String query) {
        int res = 0;
        try {
            Statement stm = cnx.createStatement();
            res = stm.executeUpdate(query);
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
