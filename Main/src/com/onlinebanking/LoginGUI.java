package com.onlinebanking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginGUI extends JFrame {
    private Bank bank;
    
    public LoginGUI(Bank bank) {
        this.bank = bank;

        setTitle("Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblAccountNumber = new JLabel("Account Number:");
        lblAccountNumber.setBounds(20, 20, 120, 25);
        add(lblAccountNumber);

        JTextField txtAccountNumber = new JTextField();
        txtAccountNumber.setBounds(150, 20, 120, 25);
        add(txtAccountNumber);

        JLabel lblPassword = new JLabel("Pin:");
        lblPassword.setBounds(20, 60, 120, 25);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 60, 120, 25);
        add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 100, 80, 25);
        add(btnLogin);

        JButton btnCreateAccount = new JButton("Sign Up");
        btnCreateAccount.setBounds(150, 100, 100, 25);
        add(btnCreateAccount);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(txtAccountNumber.getText());
                String password = new String(txtPassword.getPassword());
                Account account = bank.login(accountNumber, password);

                if (account != null) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new MainMenuGUI(bank, account);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials");
                }
            }
        });

        btnCreateAccount.addActionListener(e -> {
            new CreateAccountGUI(bank);
            dispose();
        });

        setVisible(true);
    }
}