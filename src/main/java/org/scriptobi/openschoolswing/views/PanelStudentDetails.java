package org.scriptobi.openschoolswing.views;

import org.scriptobi.openschoolswing.controllers.Ctrl_Student;
import org.scriptobi.openschoolswing.entities.EntityStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Timestamp;

public class PanelStudentDetails extends JPanel {
    Connection cnx;
    EntityStudent student;
    JTextField fldMatricule;
    JTextField fldFirstname;
    JTextField fldLastname;
    JTextField fldBirthdate;
    JTextField fldCity;
    JButton btnSubmit;
    JButton btnUpdate;

    public PanelStudentDetails(Connection cnx, EntityStudent student) {
        this.cnx = cnx;
        // List<EntityCity> cities = Repo_City.findAll(cnx);
        setLayout(new GridLayout(6, 2));

        JLabel lblMatricule = new JLabel("Matricule :");
        JLabel lblFirstname = new JLabel("Firstname :");
        JLabel lblLastname = new JLabel("Lastname :");
        JLabel lblBirthdate = new JLabel("Birthdate :");
        JLabel lblCity = new JLabel("City :");

        fldMatricule = new JTextField(10);
        fldMatricule.setEditable(false);
        fldFirstname = new JTextField(10);
        fldLastname = new JTextField(10);
        fldBirthdate = new JTextField(10);
        fldCity = new JTextField(10); // TODO: dropBox

        btnSubmit = new JButton("Submit");
        btnUpdate = new JButton("Update");

        if(student != null) {
            fldMatricule.setText("" + student.getMatricule());
            fldFirstname.setText(student.getFirstname());
            fldLastname.setText(student.getLastname());
            fldBirthdate.setText(student.getBirthdate().toString()); // TODO: 3 fld date
            fldCity.setText(student.getCity().getName()); // TODO: dropBox with cities list
        }

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
        add(btnUpdate);
    }

    private class PanStudent_AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if(btn == btnSubmit) {
                if(btn == btnSubmit) {
                    student = Ctrl_Student.save(cnx,
                            fldFirstname.getText(),
                            fldLastname.getText(),
                            Timestamp.valueOf(fldBirthdate.getText()),
                            Integer.parseInt(fldCity.getText())
                            );
                } else if(btn == btnUpdate) {
                    student = Ctrl_Student.updateStudent(cnx,
                            Integer.parseInt(fldMatricule.getText()),
                            fldFirstname.getText(),
                            fldLastname.getText(),
                            Timestamp.valueOf(fldBirthdate.getText()),
                            Integer.parseInt(fldCity.getText())
                            );
                }
            }
        }
    }
}
