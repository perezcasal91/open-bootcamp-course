package homework.task7.ui;

import javax.swing.*;

public class Task7Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            CarUI dialog = new CarUI();
            dialog.setSize(850, 400);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            System.exit(0);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

    }
}
