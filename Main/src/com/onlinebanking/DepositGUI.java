package com.onlinebanking;

import java.awt.*;
import javax.swing.*;

public class DepositGUI extends JFrame {
    public DepositGUI(Bank bank, Account account) {
        setTitle("Deposit - Account: " + account.getAccountNumber());
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblAmount = new JLabel("Deposit Amount:", SwingConstants.CENTER);
        JTextField txtAmount = new JTextField();
        JButton btnDeposit = new JButton("Deposit");
        JButton btnBack = new JButton("Back");

        add(lblAmount);
        add(txtAmount);
        add(btnDeposit);
        add(btnBack);

        btnDeposit.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(txtAmount.getText());
                if (amount > 0) {
                    account.deposit(amount);
                    JOptionPane.showMessageDialog(null, "Deposit Successful! New Balance: $" + account.getBalance());
                    new MainMenuGUI(bank, account);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a valid amount.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Enter a numeric value.");
            }
        });

        btnBack.addActionListener(e -> {
            new MainMenuGUI(bank, account);
            dispose();
        });

        setVisible(true);
    }
}