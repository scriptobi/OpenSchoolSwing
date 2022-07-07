package org.scriptobi.openschoolswing.repositories;

import org.scriptobi.openschoolswing.controllers.Ctrl_Student;
import org.scriptobi.openschoolswing.entities.EntityCity;
import org.scriptobi.openschoolswing.entities.EntityStudent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repo_Student extends Repo_Base {
    public static EntityStudent save(Connection cnx, EntityStudent student) {
        int city = student.getCity().getCpl();
        String query = "INSERT INTO students (firstname, lastname, birthdate, city)"
                + "VALUES("
                + "'" + student.getFirstname() + "', "
                + "'" + student.getLastname() + "', "
                + "'" + student.getBirthdate() + "', "
                + city
                + ")";
        int idf = doInsert(cnx, query, "matricule");
        return Ctrl_Student.findById(cnx, idf);
    }

    public static EntityStudent update(Connection cnx, EntityStudent student) {
        EntityStudent upStudent = null;
        String query = "UPDATE students SET "
                + "firstname = '" + student.getFirstname() + "', "
                + "lastname = '" + student.getLastname() + "', "
                + "birthdate = '" + student.getBirthdate() + "', "
                + "fk_city = '" + student.getCity().getCpl() + "' "
                + "WHERE idf_student = " + student.getMatricule();
        if(doUpdate(cnx, query) > 0) {
            upStudent = Ctrl_Student.findById(cnx, student.getMatricule());
        }
        return upStudent;
    }
    public static List<EntityStudent> doSelect(Connection cnx, String query) {
        List<EntityStudent> list = new ArrayList<>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()) {
                EntityCity city = Repo_City.findById(cnx, res.getInt("city"));
                EntityStudent student = new EntityStudent(
                        res.getInt("matricule"),
                        res.getString("firstname"),
                        res.getString("lastname"),
                        res.getTimestamp("birthdate"),
                        city
                );
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static EntityStudent findById(Connection cnx, int idf) {
        String query = "SELECT * FROM students "
                + "WHERE matricule = " + idf;
        return doSelect(cnx, query).get(0);
    }

    public static List<EntityStudent> findAll(Connection cnx) {
        String query = "SELECT * FROM students";
        return doSelect(cnx, query);
    }
}
