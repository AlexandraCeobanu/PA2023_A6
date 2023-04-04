package org.example.tema6;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.Serializable;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        linesLabel = new JLabel("Line probabiity:");
        createButton = new JButton("New Game");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        String[] options = {"0.0","0.1", "0.2", "0.3","0.4", "0.5", "0.6","0.7", "0.8", "0.9","1"};
        linesCombo=new JComboBox<>(options);
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
        createButton.addActionListener(this::createButton);
    }
    private void createButton(ActionEvent e)
    {
        frame.canvas.createNewGame();
    }
}

