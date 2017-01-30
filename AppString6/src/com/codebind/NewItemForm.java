package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladislav Gasanov on 30.01.2017.
 */
public class NewItemForm extends JFrame {

    Runnable onOkTask;
    String name = "ttt.txt";
    JLabel nameLabel = new JLabel("Задайте имя");
    JTextField nameField = null;
    JButton OK = new JButton("OK");

    public NewItemForm(Runnable _onOkTask) throws HeadlessException {
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameField = new JTextField(15);
        contents.add(nameLabel);
        contents.add(nameField);
        contents.add(OK);
        add(contents);
        setBounds(100, 100, 300, 200);

        onOkTask = _onOkTask;
        setVisible(false);

        new Thread(onOkTask).start(); // Action Listner for OK
    }


}
