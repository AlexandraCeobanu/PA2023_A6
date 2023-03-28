package org.example.Laborator6;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        }
        private void createOffscreenImage() {
            image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, 800, 600);
        }
    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = Double.parseDouble((String) frame.configPanel.linesCombo.getSelectedItem()) ;
        createOffscreenImage();
        createVertices( graphics,10);
        drawVertices();
        drawLines();
        repaint();
    }
    private void createVertices(Graphics g,int diameter) {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / 6; // the angle
        x=new int[numVertices];
        y=new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            //g.setColor(Color.BLACK);
            //g.fillOval(x[i], y[i], diameter, diameter);
        }
    }
    private void drawVertices()
    {
        graphics.setColor(Color.BLACK);
        for(int i=0;i<numVertices;i++)
        {
        graphics.fillOval(x[i], y[i], 10, 10);}
    }
    private void drawLines()
    {
        for(int i=0;i<numVertices;i++)
        {
            for(int j=i+1;j<numVertices;j++)
            {
                graphics.drawLine(x[i]+5,y[i]+5,x[j]+5,y[j]+5);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}
