package org.example.tema6;

import org.example.tema6.ConfigPanel;
import org.example.tema6.ControlPanel;
import org.example.tema6.DrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    public MainFrame() {
        super("My Drawing Application");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);
        canvas = new DrawingPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas,  BorderLayout.CENTER);
        pack();
    }
}

