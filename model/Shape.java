package model;
import java.awt.*;

public class Shape {

    public static final String LINE = "Line";
    public static final String CIRCLE = "Circle";
    public static final String OVAL = "Oval";
    public static final String RECTANGLE = "Rectangle";
    public static final String SQUARE = "Square";
    public static final String POINT = "Point";

    private Coordinate[] pos = new Coordinate[2];
    private Color color;
    private String shape = "";
    private boolean fill = false;

    public void setPos(int i, int x, int y){
        // at most 2 positions
        pos[i] = new Coordinate(x, y);
    }
    
    public void setColor(Color color){
        this.color = color;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }


    public Color getColor(){
        return color;
    }

    public String getShape(){
        return shape;
    }

    

    public void render(Graphics2D graphics2d){
        graphics2d.setColor(color);

        if (shape == LINE){
            if (pos[0] != null && pos[1] != null){
                // draw line
                graphics2d.drawLine(pos[0].getX(), pos[0].getY(), pos[1].getX(), pos[1].getY());
            } else return;

        } else if (shape == CIRCLE){
            if (pos[0] != null && pos[1] != null){
                int length;
                    if (pos[1].getX()-pos[0].getX() > pos[1].getY()-pos[0].getY())
                        length = pos[1].getX()-pos[0].getX();
                    else length = pos[1].getY()-pos[0].getY(); 
                if (!fill){
                    // draw circle
                    graphics2d.drawOval(pos[0].getX(), pos[0].getY(), length, length);
                } else {
                    // fill circle
                    graphics2d.fillOval(pos[0].getX(), pos[0].getY(), length, length);
                }
            } else return;

        } else if (shape == OVAL){
            if (pos[0] != null && pos[1] != null){
                if (!fill){
                    // draw oval
                    graphics2d.drawOval(pos[0].getX(), pos[0].getY(), pos[1].getX()-pos[0].getX(), pos[1].getY()-pos[0].getY());
                } else {
                    // fill oval
                    graphics2d.fillOval(pos[0].getX(), pos[0].getY(), pos[1].getX()-pos[0].getX(), pos[1].getY()-pos[0].getY());
                }
            } else return;

        } else if (shape == RECTANGLE){
            if (pos[0] != null && pos[1] != null){
                if (!fill){
                    // draw rectangle
                    graphics2d.drawRect(pos[0].getX(), pos[0].getY(), pos[1].getX()-pos[0].getX(), pos[1].getY()-pos[0].getY());
                } else {
                    // fill rectangle
                    graphics2d.fillRect(pos[0].getX(), pos[0].getY(), pos[1].getX()-pos[0].getX(), pos[1].getY()-pos[0].getY());
                } 
            } else return;

        } else if (shape == SQUARE){
            if (pos[0] != null && pos[1] != null){
                int length;
                    if (pos[1].getX()-pos[0].getX() > pos[1].getY()-pos[0].getY())
                        length = pos[1].getX()-pos[0].getX();
                    else length = pos[1].getY()-pos[0].getY(); 
                if (!fill){
                    // draw square
                    graphics2d.drawRect(pos[0].getX(), pos[0].getY(), length, length);
                } else {
                    // fill square
                    graphics2d.fillRect(pos[0].getX(), pos[0].getY(), length, length);
                }
            } else return;

        } else if (shape == POINT){
            graphics2d.fillOval(pos[0].getX(), pos[0].getY(), 2, 2);
        }


    }
}