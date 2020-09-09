package controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import model.Shape;
import view.DrawingPanel;
import view.MenuScreen;

public class DrawingEventListener implements ActionListener, MouseListener, MouseMotionListener {

    private DrawingPanel panel;
    private Shape shape;

    private Point startPoint = new Point();
    private Point endPoint = new Point();

    private Color color = Color.black;
    private String msg = "";

    public DrawingEventListener(DrawingPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        Object source = e.getSource();
        if (source == panel.getExitBtn()){ // control
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        
        } else if (source == panel.getClearBtn()){
            panel.getCanvas().getShapeList().clear();
            panel.getCanvas().repaint();
        } // color


        else if (source == panel.getRedBtn()){
            color = Color.red;
        } else if (source == panel.getGreenBtn()){
            color = Color.green;
        } else if (source == panel.getBlueBtn()){
            color = Color.blue;
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
        if (panel.getLineBtn().isSelected()){  
            startPoint = e.getPoint();
            shape = new Shape();
            shape.setPos(0, e.getX(), e.getY());
            shape.setColor(color);
            panel.getCanvas().getShapeList().add(shape);
            panel.getCanvas().setStartDrag(startPoint);
            panel.getCanvas().setColor(color);
        
        }
        panel.getCanvas().repaint();

        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Releasing...";
        if (panel.getLineBtn().isSelected()){
            shape.setPos(1, e.getX(), e.getY());
            panel.getCanvas().setStartDrag(startPoint);
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

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        msg = "Mouse: Dragging...";
        if (panel.getLineBtn().isSelected()){
            panel.getCanvas().setEndDrag(e.getPoint());
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
        panel.getCanvas().setStartDrag(e.getPoint());
        panel.getCanvas().setEndDrag(e.getPoint());
        
        panel.setXYStatuslbl().setText(String.valueOf(e.getX()) + " x " + String.valueOf(e.getY()));
        panel.setMouseStatuslbl().setText("  " + msg);
    }

    
}