package com.onlinebanking;

import javax.swing.SwingUtilities;

/**
 *
 * @author 10728009
 */
public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI(bank);
            loginGUI.show();
        });
    }
}
