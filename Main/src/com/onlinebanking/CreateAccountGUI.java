package com.onlinebanking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateAccountGUI extends JFrame {
    private Bank bank;

    public CreateAccountGUI(Bank bank) {
        this.bank = bank;

        setTitle("Create Account");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(20, 20, 120, 25);
        add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(150, 20, 120, 25);
        add(txtName);

        JLabel lblPassword = new JLabel("Pin:");
        lblPassword.setBounds(20, 60, 120, 25);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 60, 120, 25);
        add(txtPassword);

        JLabel lblInitialDeposit = new JLabel("Initial Deposit:");
        lblInitialDeposit.setBounds(20, 100, 120, 25);
        add(lblInitialDeposit);

        JTextField txtInitialDeposit = new JTextField();
        txtInitialDeposit.setBounds(150, 100, 120, 25);
        add(txtInitialDeposit);

        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(50, 140, 80, 25);
        add(btnCreate);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 140, 80, 25);
        add(btnBack);

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String password = new String(txtPassword.getPassword());
                double deposit = Double.parseDouble(txtInitialDeposit.getText());

                Account account = bank.createAccount(name, password, deposit);
                JOptionPane.showMessageDialog(null, "Account Created! Your Account Number: " + account.getAccountNumber());
                new LoginGUI(bank);
                dispose();
            }
        });

        btnBack.addActionListener(e -> {
            new LoginGUI(bank);
            dispose();
        });

        setVisible(true);
    }
}