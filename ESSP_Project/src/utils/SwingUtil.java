package utils;

import javax.swing.*;

public class SwingUtil {

    public static void info(String msg) {

        JOptionPane.showMessageDialog(
            null,
            msg,
            "Information",
            JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String msg) {

        JOptionPane.showMessageDialog(
            null,
            msg,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    public static void warning(String msg) {

        JOptionPane.showMessageDialog(
            null,
            msg,
            "Warning",
            JOptionPane.WARNING_MESSAGE);
    }
}