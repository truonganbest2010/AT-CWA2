package view;

import java.awt.*;
import javax.swing.*;

public class ColorSetShow extends JPanel{

	private int gridRows = 1; 
	private int gridCols = 1; 
	private Color[][] gridColor; 	                                
	private Color lineColor;

	public ColorSetShow(int preferredSquareSize) {
		gridColor = new Color[gridRows][gridCols];
		lineColor = Color.BLACK;
		setPreferredSize(new Dimension(preferredSquareSize*gridCols, 
                preferredSquareSize*gridRows) );
        setBackground(Color.WHITE);
        gridColor[0][0] = Color.BLACK;
    }
    
    public Color setColor(Color color){
        return gridColor[0][0] = color;
    }
	
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		int row, col;
		double cellWidth = (double)getWidth() / gridCols;
		double cellHeight = (double)getHeight() / gridRows;
		for (row = 0; row < gridRows; row++) {
			for (col = 0; col < gridCols; col++) {
				if (gridColor[row][col] != null) {
					int x1 = (int)(col*cellWidth);
					int y1 = (int)(row*cellHeight);
					int x2 = (int)((col+1)*cellWidth);
					int y2 = (int)((row+1)*cellHeight);
					g.setColor(gridColor[row][col]);
					g.fillRect( x1, y1, (x2-x1), (y2-y1) );
				}
			}
		}
		if (lineColor != null) {
			g.setColor(lineColor);
			for (row = 1; row < gridRows; row++) {
				int y = (int)(row*cellHeight);
				g.drawLine(0,y,getWidth(),y);
			}
			for (col = 1; col < gridRows; col++) {
				int x = (int)(col*cellWidth);
				g.drawLine(x,0,x,getHeight());
			}
		}
	}

}