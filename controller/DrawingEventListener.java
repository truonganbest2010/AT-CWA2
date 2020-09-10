package controller;

import java.awt.*;
import java.awt.event.*;

import model.Shape;
import view.DrawingPanel;

public class DrawingEventListener implements ActionListener, MouseListener, MouseMotionListener {

    private DrawingPanel panel;
    private Shape shape;

    private Point startPoint = new Point();
    private Point endPoint = new Point();

    private String msg = "";

    public DrawingEventListener(DrawingPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        Object source = e.getSource();
        if (source == panel.getExitBtn()){ // control
            System.exit(0);
        } else if (source == panel.getClearBtn()){
            panel.getCanvas().getShapeList().clear();
            panel.getCanvas().repaint();

        } // color


        else if (source == panel.getRedBtn()){
            panel.setColor(Color.red);
            panel.getColorSetShow().setColor(Color.red);
            panel.getColorSetShow().repaint();
        } else if (source == panel.getGreenBtn()){
            panel.setColor(Color.green);
            panel.getColorSetShow().setColor(Color.green);
            panel.getColorSetShow().repaint();
        } else if (source == panel.getBlueBtn()){
            panel.setColor(Color.blue);
            panel.getColorSetShow().setColor(Color.blue);
            panel.getColorSetShow().repaint();
        } else if (source == panel.getYellowBtn()){
            panel.setColor(Color.yellow);
            panel.getColorSetShow().setColor(Color.yellow);
            panel.getColorSetShow().repaint();
        } else if (source == panel.getBlackBtn()){
            panel.setColor(Color.black);
            panel.getColorSetShow().setColor(Color.black);
            panel.getColorSetShow().repaint();
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Clicking...";

        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Pressing...";
        startPoint = e.getPoint();
        if (panel.getPencilBtn().isSelected()){
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Point");
            panel.getCanvas().getShapeList().add(shape);
        }
        if (panel.getLineBtn().isSelected()){  
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Line");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(panel.getColor());
        }
        if (panel.getCircleBtn().isSelected()){  
            // startPoint = e.getPoint();
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Circle");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(panel.getColor());
        }
        if (panel.getOvalBtn().isSelected()){  
            // startPoint = e.getPoint();
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Oval");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(panel.getColor());
        }
        if (panel.getRectangleBtn().isSelected()){  
            // startPoint = e.getPoint();
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Rectangle");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(panel.getColor());
        }
        if (panel.getSquareBtn().isSelected()){  
            // startPoint = e.getPoint();
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Square");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(panel.getColor());
        }


        panel.getCanvas().repaint();

        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Releasing...";
        if (panel.getLineBtn().isSelected()
        || panel.getCircleBtn().isSelected() 
        || panel.getOvalBtn().isSelected() 
        || panel.getRectangleBtn().isSelected() 
        || panel.getSquareBtn().isSelected()
        ){
            shape.setPos(1, e.getX(), e.getY());
            panel.getCanvas().setMouseStart(startPoint);
        }
        
        panel.getCanvas().repaint();
        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // System.out.println("Exited: " + e.getX() + ", " + e.getY());
        panel.getCanvas().setMouseStart(e.getPoint());
        panel.getCanvas().setMouseEnd(e.getPoint());
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Dragging...";
        if (panel.getLineBtn().isSelected()
        || panel.getCircleBtn().isSelected() 
        || panel.getOvalBtn().isSelected() 
        || panel.getRectangleBtn().isSelected() 
        || panel.getSquareBtn().isSelected()
        || panel.getPencilBtn().isSelected()
        ){
            panel.getCanvas().setMouseEnd(e.getPoint());
        }
        if (panel.getPencilBtn().isSelected()){
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(panel.getColor());
            shape.setShape("Point");
            panel.getCanvas().getShapeList().add(shape);
        }
        
        panel.getCanvas().repaint();
        if (e.getX() > -1 && e.getY() > -1)
            panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: ...";
        panel.getCanvas().setMouseStart(e.getPoint());
        panel.getCanvas().setMouseEnd(e.getPoint());
        
        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    
}