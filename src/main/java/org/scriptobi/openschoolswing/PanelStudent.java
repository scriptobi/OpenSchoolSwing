package org.scriptobi.openschoolswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStudent extends JPanel {
    JTextField fldMatricule;
    JTextField fldFirstname;
    JTextField fldLastname;
    JTextField fldBirthdate;
    JTextField fldCity;
    JButton btnSubmit;

    public PanelStudent() {
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

            }
        }
    }
}
