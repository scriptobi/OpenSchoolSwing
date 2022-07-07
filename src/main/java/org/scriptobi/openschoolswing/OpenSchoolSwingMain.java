package org.scriptobi.openschoolswing;

import org.scriptobi.openschoolswing.views.PanelStudentDetails;

import javax.swing.*;

public class OpenSchoolSwingMain {
    public static void main(String ... args) {
        MySQLConnector connector = new MySQLConnector();
        JPanel panelStudent = new PanelStudentDetails(connector.getCnx(), null);

    }
}
