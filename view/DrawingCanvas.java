package view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import model.Shape;

import java.awt.*;

public class DrawingCanvas extends JPanel {
    
    private DrawingPanel panel;
    private Color color;

    private Point startDrag;
    private Point endDrag;

    private ArrayList<Shape> shapeList = new ArrayList<>();

    public DrawingCanvas(DrawingPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(new ColorUIResource(235, 235, 235));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (startDrag == null || endDrag == null){
            return;
        }
        else {
            g2.setColor(color);
            g2.drawLine(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
        } 
        

        if (!shapeList.isEmpty()){
            for (Shape s: shapeList)
                s.render(g2);     
        }


    }

    public ArrayList<Shape> getShapeList(){
        return shapeList;
    }

    public Color setColor(Color color){
        return this.color = color;
    }

// Set point x1, y1. x2, y2

    public Point setStartDrag(Point point){
        startDrag = new Point(point);
        return startDrag;
    }

    public Point setEndDrag(Point point){
        endDrag = new Point(point);
        return endDrag;
    }


}