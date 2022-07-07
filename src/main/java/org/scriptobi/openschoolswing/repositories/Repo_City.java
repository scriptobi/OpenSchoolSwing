package org.scriptobi.openschoolswing.repositories;

import org.scriptobi.openschoolswing.entities.EntityCity;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repo_City extends Repo_Base {
    public EntityCity save(Connection cnx, int cpl, String name) {
        EntityCity city = null;
        String query = "INSERT INTO cities (cpl, name) VALUES(" + cpl + ", '" + name + "')";
        if(doInsert(cnx, query) > 0) {
            city = Repo_City.findById(cnx, cpl);
        }
        return city;
    }

    public EntityCity update(Connection cnx, int cpl, String name) {
        EntityCity city = null;
        String query = "UPDATE cities SET name = '" + name + "' WHERE cpl = " + cpl;
        if(doUpdate(cnx, query) > 0) {
            city = Repo_City.findById(cnx, cpl);
        }
        return city;
    }
    public static List<EntityCity> doSelect(Connection cnx, String query) {
        List<EntityCity> list = new ArrayList<>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()) {
                EntityCity city = new EntityCity(
                        res.getInt("cpl"),
                        res.getString("name")
                );
                list.add(city);
            }
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static EntityCity findById(Connection cnx, int idfCity) {
        EntityCity city = null;
        String query = "SELECT * FROM cities WHERE cpl = " + idfCity;
        return Repo_City.doSelect(cnx, query).get(0);
    }
    public static List<EntityCity> findAll(Connection cnx) {
        String query = "SELECT * FROM cities ORDER BY cpl";
        return doSelect(cnx, query);
    }
}
