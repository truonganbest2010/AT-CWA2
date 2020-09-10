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

    private Point mouseStart;
    private Point mouseEnd;

    private ArrayList<Shape> shapeList = new ArrayList<>();

    public DrawingCanvas(DrawingPanel panel){
        this.panel = panel;
        setPreferredSize(new Dimension(600, 740));
        setBackground(new ColorUIResource(240, 240, 240));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (mouseStart == null || mouseEnd == null){
            return;
        }
        else {
            if (panel.getPencilBtn().isSelected() && mouseStart.x < 600 && mouseStart.y < 740){
                g2.setColor(color);
                g2.fillOval(mouseEnd.x, mouseEnd.y, 2, 2); 
            }
            if (panel.getLineBtn().isSelected() && mouseStart.x < 600 && mouseStart.y < 740){
                g2.setColor(color);
                g2.drawLine(mouseStart.x, mouseStart.y, mouseEnd.x, mouseEnd.y); 
            }
            if (panel.getCircleBtn().isSelected() && mouseStart.x < 600 && mouseStart.y < 740){
                int length;
                if (mouseEnd.x-mouseStart.x > mouseEnd.y-mouseStart.y)
                    length = mouseEnd.x-mouseStart.x;
                else length = mouseEnd.y-mouseStart.y;

                g2.setColor(color);
                g2.drawOval(mouseStart.x, mouseStart.y, length, length);
            }
            
            if (panel.getOvalBtn().isSelected() && mouseStart.x < 600 && mouseStart.y < 740){
                g2.setColor(color);
                g2.drawOval(mouseStart.x, mouseStart.y, mouseEnd.x-mouseStart.x, mouseEnd.y-mouseStart.y);
            }
            if (panel.getRectangleBtn().isSelected() && mouseStart.x < 600 && mouseStart.y < 740){
                g2.setColor(color);
                g2.drawRect(mouseStart.x, mouseStart.y, mouseEnd.x-mouseStart.x, mouseEnd.y-mouseStart.y);
            }
            if (panel.getSquareBtn().isSelected() && mouseStart.x < 600 && mouseStart.y < 740){
                int length;
                if (mouseEnd.x-mouseStart.x > mouseEnd.y-mouseStart.y)
                    length = mouseEnd.x-mouseStart.x;
                else length = mouseEnd.y-mouseStart.y;
                
                g2.setColor(color);
                g2.drawRect(mouseStart.x, mouseStart.y, length, length);
            }
        
            if (!shapeList.isEmpty()){
                for (Shape s: shapeList)
                    s.render(g2);     
            }
        }

    }

    public ArrayList<Shape> getShapeList(){
        return shapeList;
    }

    public Color setColor(Color color){
        return this.color = color;
    }

// Set point x1, y1. x2, y2

    public Point setMouseStart(Point point){
        mouseStart = new Point(point);
        return mouseStart;
    }

    public Point setMouseEnd(Point point){
        mouseEnd = new Point(point);
        return mouseEnd;
    }


}