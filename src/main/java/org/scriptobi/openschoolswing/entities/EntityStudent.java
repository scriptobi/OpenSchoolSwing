package org.scriptobi.openschoolswing.entities;

import java.sql.Timestamp;

public class EntityStudent {
    private int matricule;
    private String firstname;
    private String lastname;
    private Timestamp birthdate;
    private EntityCity city;

    public EntityStudent() {}
    public EntityStudent(int matricule, String firstname, String lastname, Timestamp birthdate, EntityCity city) {
        this.matricule = matricule;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.city = city;
    }

    public int getMatricule() { return matricule; }
    public void setMatricule(int matricule) { this.matricule = matricule; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public Timestamp getBirthdate() { return birthdate; }
    public void setBirthdate(Timestamp birthdate) { this.birthdate = birthdate; }
    public EntityCity getCity() { return city; }
    public void setCity(EntityCity city) { this.city = city; }
}
