package main;

import javax.swing.SwingUtilities;
import ui.LoginFrame;

public class MainApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}