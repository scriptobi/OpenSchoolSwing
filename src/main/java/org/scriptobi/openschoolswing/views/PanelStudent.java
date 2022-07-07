package org.scriptobi.openschoolswing.views;

import org.scriptobi.openschoolswing.controllers.Ctrl_Student;
import org.scriptobi.openschoolswing.entities.EntityStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Timestamp;

public class PanelStudent extends JPanel {
    Connection cnx;
    JTextField fldMatricule;
    JTextField fldFirstname;
    JTextField fldLastname;
    JTextField fldBirthdate;
    JTextField fldCity;
    JButton btnSubmit;

    public PanelStudent(Connection cnx) {
        this.cnx = cnx;
        setLayout(new GridLayout(4, 3));

        JLabel lblMatricule = new JLabel("Matricule :");
        JLabel lblFirstname = new JLabel("Firstname :");
        JLabel lblLastname = new JLabel("Lastname :");
        JLabel lblBirthdate = new JLabel("Birthdate :");
        JLabel lblCity = new JLabel("City :");

        fldMatricule = new JTextField(10);
        fldFirstname = new JTextField(10);
        fldLastname = new JTextField(10);
        fldBirthdate = new JTextField(10);
        fldCity = new JTextField(10);

        btnSubmit = new JButton("Submit");

        add(lblMatricule);
        add(fldMatricule);
        add(lblFirstname);
        add(fldFirstname);
        add(lblLastname);
        add(fldLastname);
        add(lblBirthdate);
        add(fldBirthdate);
        add(lblCity);
        add(fldCity);
        add(btnSubmit);
    }

    private class PanStudent_AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if(btn == btnSubmit) {
                EntityStudent student = new EntityStudent(
                        fldMatricule.getText(),
                        fldFirstname.getText(),
                        fldLastname.getText(),
                        Timestamp.valueOf(fldBirthdate.getText()),
                        null
                );
                Ctrl_Student.save(cnx, student);
            }
        }
    }
}
