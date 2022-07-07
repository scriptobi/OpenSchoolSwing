package org.scriptobi.openschoolswing.entities;

import org.scriptobi.openschoolswing.controllers.Ctrl_City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EntityStudent {
    private String matricule;
    private String firstname;
    private String lastname;
    private Timestamp birthdate;
    private EntityCity city;

    public EntityStudent() {}
    public EntityStudent(String matricule, String firstname, String lastname, Timestamp birthdate, EntityCity city) {
        this.matricule = matricule;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.city = city;
    }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    public String getFirstname() { return firstname; }
    public void setLastname() { this.lastname = lastname; }
    public Timestamp getBirthdate() { return birthdate; }
    public void setBirthdate(Timestamp birthdate) { this.birthdate = birthdate; }
    public EntityCity getCity() { return city; }
    public void setCity(EntityCity city) { this.city = city; }
}
