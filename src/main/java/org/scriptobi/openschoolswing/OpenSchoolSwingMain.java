package org.scriptobi.openschoolswing;

import org.scriptobi.openschoolswing.views.PanelStudent;

import javax.swing.*;
import java.sql.Connection;

public class OpenSchoolSwingMain {
    public static void main(String ... args) {
        MySQLConnector connector = new MySQLConnector();
        JPanel panelStudent = new PanelStudent(connector.getCnx());

    }
}
