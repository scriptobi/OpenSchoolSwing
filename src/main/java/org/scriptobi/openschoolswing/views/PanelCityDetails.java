package org.scriptobi.openschoolswing.views;

import org.scriptobi.openschoolswing.entities.EntityCity;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class PanelCityDetails extends JPanel {
    Connection cnx;
    JTextField fldCpl;
    JTextField fldName;
    JButton btnSubmit;

    public PanelCityDetails(Connection cnx, EntityCity city) {
        this.cnx = cnx;
        setLayout(new GridLayout(2, 2));

        JLabel lblCpl = new JLabel("Code postal :");
        JLabel lblName = new JLabel("Nom :");

        fldCpl = new JTextField(10);
        fldName = new JTextField(10);

        if(city != null) {
            fldCpl.setEditable(false);
            fldCpl.setText("" + city.getCpl());
            fldName.setText(city.getName());
        }

        btnSubmit = new JButton("Submit");

        add(lblCpl);
        add(fldCpl);
        add(lblName);
        add(fldName);
        add(btnSubmit);
    }
}
