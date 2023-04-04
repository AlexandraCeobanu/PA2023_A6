package org.example.tema6;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

public class ControlPanel extends JPanel implements Serializable{
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    DrawingPanel canvas;
    private RenderedImage image;

    //create all buttons (Load, Exit, etc.)
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()   {
        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
    }

    private void setLayout(GridLayout gridLayout) {
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void loadGame(ActionEvent e){
        FileInputStream fileInputStream=null;
        try{
         fileInputStream = new FileInputStream("game.txt");}
        catch (FileNotFoundException ex)
        {
            throw new RuntimeException();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream=null;
        try
        {objectInputStream = new ObjectInputStream(bufferedInputStream);}
        catch (IOException ex)
        {
            throw new RuntimeException();
        }
        try{
        DrawingPanel canva = (DrawingPanel) objectInputStream.readObject();}
        catch (ClassNotFoundException ex)
        {
            throw new RuntimeException();
        }
        catch (IOException ex)
        {
            throw new RuntimeException();
        }
        try{
        objectInputStream.close();}
        catch (IOException ex) {
            throw new RuntimeException();
        }
    }
    private void saveGame(ActionEvent e)  {
        BufferedImage image = new BufferedImage(frame.getContentPane().getWidth(), frame.getContentPane().getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        frame.getContentPane().paint(graphics);
        graphics.dispose();
        try {
            File output = new File("imagine.png");
            ImageIO.write(image, "png", output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        OutputStream output=null;
        try{
        output=new FileOutputStream("game.txt");}
        catch (FileNotFoundException ex)
        {
            throw new RuntimeException(ex);
        }
        ObjectOutputStream objectOutputStream=null;
        try{
         objectOutputStream=new ObjectOutputStream(output);}
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
        DrawingPanel canvas2= canvas;
        try{
        objectOutputStream.writeObject(canvas2);}
        catch (IOException ex)
        {
            throw  new RuntimeException(ex);
        }
        try {
            objectOutputStream.flush();
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
    private void resetGame(ActionEvent e)
    {
        frame.canvas.resetGame();
    }
}


