package controller;

import java.awt.*;
import java.awt.event.*;

import model.Shape;
import view.DrawingPanel;

public class DrawingEventListener implements ActionListener, MouseListener, MouseMotionListener {

    private DrawingPanel panel;
    private Shape shape;
    private boolean fill;
    private Color color;

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
        }
        if (source == panel.getClearBtn()){
            panel.getCanvas().getShapeList().clear();
            panel.setMouseStatuslbl().setText("Cleared!");
            panel.getCanvas().repaint();
        }
        if (source == panel.getGenerateBtn()){
            panel.getColorGrid().generateColor();
            panel.getColorGrid().repaint();

        }

        // shape
        if (panel.getPencilBtn().isSelected() || panel.getLineBtn().isSelected()){
            panel.getFillBtn().setEnabled(false);
            panel.getTransparentBtn().setEnabled(false);
            panel.getNoneBtn().setSelected(true);
        } else if (panel.getCircleBtn().isSelected() || panel.getOvalBtn().isSelected() || panel.getRectangleBtn().isSelected() || panel.getSquareBtn().isSelected() ){
            panel.getFillBtn().setEnabled(true);
            panel.getTransparentBtn().setEnabled(true);
        }

        // color
        if (source == panel.getRedBtn()){
            panel.setColor(Color.red);
            panel.getColorSetShow().setColor(Color.red);
            panel.getColorSetShow().repaint();
            panel.getCurrentColor().addColor(Color.red);
            panel.getCurrentColor().repaint();
        }
        if (source == panel.getGreenBtn()){
            panel.setColor(Color.green);
            panel.getColorSetShow().setColor(Color.green);
            panel.getColorSetShow().repaint();
            panel.getCurrentColor().addColor(Color.green);
            panel.getCurrentColor().repaint();
        }
        if (source == panel.getBlueBtn()){
            panel.setColor(Color.blue);
            panel.getColorSetShow().setColor(Color.blue);
            panel.getColorSetShow().repaint();
            panel.getCurrentColor().addColor(Color.blue);
            panel.getCurrentColor().repaint();
        }
        if (source == panel.getYellowBtn()){
            panel.setColor(Color.yellow);
            panel.getColorSetShow().setColor(Color.yellow);
            panel.getColorSetShow().repaint();
            panel.getCurrentColor().addColor(Color.yellow);
            panel.getCurrentColor().repaint();
        }
        if (source == panel.getBlackBtn()){
            panel.setColor(Color.black);
            panel.getColorSetShow().setColor(Color.black);
            panel.getColorSetShow().repaint();
            panel.getCurrentColor().addColor(Color.black);
            panel.getCurrentColor().repaint();
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse:...";

        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("" + msg);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if (panel.getNoneBtn().isSelected()){
            fill = false;
            color = panel.getColor();
        }
        if (panel.getFillBtn().isSelected()){
            fill = true;
            color = panel.getColor();
        }
        if (panel.getTransparentBtn().isSelected()){
            fill = true;
            int getR = panel.getColor().getRed();
            int getG = panel.getColor().getGreen();
            int getB = panel.getColor().getBlue();
            color = new Color(getR, getG, getB, 127);
        }

        msg = "Mouse: Drawing...";
        startPoint = e.getPoint();
        if (panel.getPencilBtn().isSelected()){
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            shape.setShape("Point");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setColor(color);
        }
        if (panel.getLineBtn().isSelected()){  
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            shape.setShape("Line");
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(color);
        }
        if (panel.getCircleBtn().isSelected()){  
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            shape.setShape("Circle");
            shape.setFill(fill);
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(color);
        }
        if (panel.getOvalBtn().isSelected()){  
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            shape.setShape("Oval");
            shape.setFill(fill);
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(color);
        }
        if (panel.getRectangleBtn().isSelected()){  
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            shape.setShape("Rectangle");
            shape.setFill(fill);
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(color);
        }
        if (panel.getSquareBtn().isSelected()){  
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            shape.setShape("Square");
            shape.setFill(fill);
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setMouseStart(startPoint);
            panel.getCanvas().setColor(color);
        }


        panel.getCanvas().repaint();

        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("" + msg);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Done...";
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
        panel.setMouseStatuslbl().setText("" + msg);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // System.out.println("Exited: " + e.getX() + ", " + e.getY());
        msg = "Setting...";

        panel.getCanvas().setMouseStart(e.getPoint());
        panel.getCanvas().setMouseEnd(e.getPoint());

        panel.setMouseStatuslbl().setText("" + msg);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        if (panel.getLineBtn().isSelected() || panel.getPencilBtn().isSelected()){
        msg = "Drawing...";
        } else {
        msg = "Measuring...";
        }

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
            shape.setColor(color);
            shape.setShape("Point");
            panel.getCanvas().getShapeList().add(shape);
        }
        
        panel.getCanvas().repaint();
        if (e.getX() > -1 && e.getY() > -1)
            panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("" + msg);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse:...";
        panel.getCanvas().setMouseStart(e.getPoint());
        panel.getCanvas().setMouseEnd(e.getPoint());
        
        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("" + msg);
    }

    
}