package model;
import java.awt.*;

public class Shape {

    private Coordinate[] pos = new Coordinate[2];
    private Color color = Color.black;
    private String shape = "";

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


    public Color getColor(){
        return color;
    }

    

    public void render(Graphics2D graphics2d){
        graphics2d.setColor(color);

        if (pos[0] == null && pos[1] == null){
            return;
        } else if (pos[1] == null){
            // graphics2d.fillOval(pos[0].getX(), pos[0].getY(), 1, 1);
            return;
        } else { // draw line
            graphics2d.drawLine(pos[0].getX(), pos[0].getY(), pos[1].getX(), pos[1].getY());
        }
    }
}