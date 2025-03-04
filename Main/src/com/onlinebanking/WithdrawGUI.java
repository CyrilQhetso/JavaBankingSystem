package com.onlinebanking;

import java.awt.*;
import javax.swing.*;

public class WithdrawGUI extends JFrame {
    public WithdrawGUI(Bank bank, Account account) {
        setTitle("Withdraw - Account: " + account.getAccountNumber());
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblAmount = new JLabel("Withdraw Amount:", SwingConstants.CENTER);
        JTextField txtAmount = new JTextField();
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnBack = new JButton("Back");

        add(lblAmount);
        add(txtAmount);
        add(btnWithdraw);
        add(btnBack);

        btnWithdraw.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(txtAmount.getText());
                if (amount > 0 && account.withdraw(amount)) {
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful! New Balance: $" + account.getBalance());
                    new MainMenuGUI(bank, account);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance or invalid amount.");
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