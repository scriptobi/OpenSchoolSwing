package org.scriptobi.openschoolswing.controllers;

import org.scriptobi.openschoolswing.entities.EntityCity;
import org.scriptobi.openschoolswing.entities.EntityStudent;
import org.scriptobi.openschoolswing.repositories.Repo_City;
import org.scriptobi.openschoolswing.repositories.Repo_Student;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

public class Ctrl_Student {
    public static EntityStudent save(Connection cnx, String firstname, String lastname, Timestamp birthdate, int idfCity) {
        EntityCity city = Repo_City.findById(cnx, idfCity);
        EntityStudent student = new EntityStudent(
                0,
                firstname,
                lastname,
                birthdate,
                city
        );
        Repo_Student.save(cnx, student);

        return Repo_Student.save(cnx, student);
    }

    public static EntityStudent findById(Connection cnx, int idf) {
        return Repo_Student.findById(cnx, idf);
    }

    public static List<EntityStudent> findAll(Connection cnx) {
        return Repo_Student.findAll(cnx);
    }

    public static EntityStudent updateStudent(Connection cnx, int matricule, String firstname, String lastname, Timestamp birthdate, int idfCity) {
        EntityStudent student = new EntityStudent();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setBirthdate(birthdate);
        EntityCity city = Repo_City.findById(cnx, idfCity);
        student.setCity(city);
        return Repo_Student.update(cnx, student);
    }
}
