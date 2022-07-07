package org.scriptobi.openschoolswing.controllers;

import org.scriptobi.openschoolswing.entities.EntityStudent;

import java.sql.Connection;

public class Ctrl_Student {
    public static EntityStudent save(Connection cnx, EntityStudent student) {
        return student;
    }
}
