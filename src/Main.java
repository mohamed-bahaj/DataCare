import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main{

    private void initSwingComponents() {
        JFrame frame = new JFrame("Java FX in Swing");
        final JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel, BorderLayout.CENTER);
        final JPanel swingButtons = new JPanel();
        final JButton okButton = new JButton("OK");
        okButton.addActionListener(event -> System.out.println("Swing says 'OK'"));
        final JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(event -> System.exit(0));
        swingButtons.add(okButton);
        swingButtons.add(exitButton);
        frame.add(swingButtons, BorderLayout.SOUTH);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        okButton.requestFocus();

        Platform.runLater(() -> initFX(jfxPanel));
    }

    private void initFX(JFXPanel jfxPanel) {
        try {
            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/test.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("test.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            jfxPanel.setScene(scene);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Main test = new Main();
        SwingUtilities.invokeLater(() -> test.initSwingComponents() );
    }



}
