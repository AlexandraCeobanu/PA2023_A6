package org.example.tema6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static java.awt.geom.Line2D.ptSegDistSq;
import static java.lang.Math.abs;

public class DrawingPanel extends JPanel implements Serializable, MouseListener {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private int[] linex1,linex2,liney1,liney2;
    private int[] color ;
    BufferedImage image; //the offscreen image
    Graphics2D graphics;
    List<Line2D> lines =new ArrayList<>();
    private int jucator=0;
    private int xclick,yclick;
    public DrawingPanel(MainFrame frame) {
        super();
        addMouseListener(this);
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
        }
    }
    private void drawVertices()
    {
        graphics.setColor(Color.BLACK);
        for(int i=0;i<numVertices;i++)
        {
            graphics.fillOval(x[i], y[i], 5, 5);}
    }
    private void drawLines()
    {
        graphics.setStroke(new BasicStroke(5));
        linex1=new int[numVertices*(numVertices-1)/2];
        linex2=new int[numVertices*(numVertices-1)/2];
        liney1=new int[numVertices*(numVertices-1)/2];
        liney2=new int[numVertices*(numVertices-1)/2];
        color=new int[numVertices*(numVertices-1)/2];
        int k=0;
        for(int i=0;i<numVertices;i++)
        {
            for(int j=i+1;j<numVertices;j++)
            {
                linex1[k]=x[i];
                linex2[k]=x[j];
                liney1[k]=y[i];
                liney2[k]=y[j];
                color[k]=-1;
               Line2D line= new Line2D.Double(linex1[i],liney1[i],linex2[i],liney2[i]);
               lines.add(line);
               graphics.drawLine(linex1[k],liney1[k],linex2[k],liney2[k]);
                k=k+1;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
            xclick = e.getX();
            yclick = e.getY();
            System.out.println("S a apasat click");
            drawColorLine();
            repaint();
            checkTriangle();
    }

    public void drawColorLine() {
        int ec1 ,ec2;
        for (int i = 0; i < getNumberLines(); i++) {
            if(ptSegDistSq(linex1[i],liney1[i],linex2[i],liney2[i],xclick,yclick)<2)
            {
                if(jucator%2==0) {
                    graphics.setColor(Color.RED);
                    color[i]=0;
                }
                else {
                    graphics.setColor(Color.GREEN);
                    color[i]=1;
                }
                System.out.println("e pe liniee helllllloooooooooooooooo");
                graphics.drawLine(linex1[i], liney1[i], linex2[i], liney2[i]);
                ++jucator;
                break;
            }
            /*
            int a=liney2[i]-liney1[i];
            int b=-linex2[i]+linex1[i];
            int c=linex1[i]*liney2[i] - linex2[i]*liney1[i];
            int distance=abs(a*xclick+b*yclick+c)/(a*a+b*b);
            if(distance<1) {
                graphics.setColor(Color.RED);
                System.out.println("e pe liniee helllllloooooooooooooooo");
                graphics.drawLine(linex1[i], liney1[i], linex2[i], liney2[i]);
                break;
            }*/
        }
    }



    public int getNumVertices() {
        return numVertices;
    }
    public int getNumberLines()
    {
        return linex1.length;
    }
    public void resetGame()
    {
        jucator=0;
        createOffscreenImage();
        createVertices( graphics,10);
        drawVertices();
        drawLines();
        /*for(int i=0;i<getNumberLines();i++)
        {
            graphics.setColor(Color.BLACK);
            graphics.drawLine(linex1[i],liney1[i],linex2[i],liney2[i]);
        }*/
        repaint();
    }
    public void createNewGame()
    {
        jucator=0;
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = Double.parseDouble((String) frame.configPanel.linesCombo.getSelectedItem()) ;
        //createOffscreenImage();
        createBoard();
        for(int i=0;i<getNumberLines();i++)
        {
            graphics.setColor(Color.BLACK);
            graphics.drawLine(linex1[i],liney1[i],linex2[i],liney2[i]);
        }
        repaint();
    }
    public void checkTriangle()
    {
        for(int i=0;i<getNumberLines();i++)
        {
            for(int j=0;j<getNumberLines();j++)
            {
                for(int z=0;z<getNumberLines();z++)
                {
                    if(lines.get(i)!= lines.get(j) && lines.get(j)!=lines.get(z) && color[i] == color[j] && color[i]==color[z] && color[i]!=-1 && color[j]!=-1 && color[z]!=-1)
                    {
                        if(linex1[i]==linex1[j] && liney1[i]==liney1[j] && (linex2[j]==linex1[z] && liney2[j]==liney1[z]) && (linex2[z]==linex2[i] && liney2[z]==liney2[i]))
                        {

                            createOffscreenImage();
                            graphics.setStroke(new BasicStroke(5));
                            if((jucator-1)%2==0)
                            graphics.setColor(Color.RED);
                            else
                                graphics.setColor(Color.GREEN);

                            graphics.drawLine(linex1[i],liney1[i],linex2[i],liney2[i]);
                            graphics.drawLine(linex1[j],liney1[j],linex2[j],liney2[j]);
                            graphics.drawLine(linex1[z],liney1[z],linex2[i],liney2[z]);
                        }
                    }
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    };

    @Override
    public void mouseEntered(MouseEvent e){};

    @Override
    public void mouseExited(MouseEvent e) {};
}

