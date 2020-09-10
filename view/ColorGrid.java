package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents a "panel" that displays a grid of colored squares.
 * The class also include a main() routine that creates a window containing
 * a panel of this type.
 */
public class ColorGrid extends JPanel implements MouseListener {

	private int gridRows; // Number of rows of squares.
	private int gridCols; // Number of columns of squares.
	private Color[][] gridColor; /* gridColor[r][c] is the color for square in row r, column c; 
	                                 if it  is null, the square has the panel's background color.*/
	private Color lineColor; // Color for lines drawn between squares; if null, no lines are drawn.

	public ColorGrid(int rows, int columns, int preferredSquareSize) {
		gridColor = new Color[rows][columns]; // Create the array that stores square colors.
		gridRows = rows;
		gridCols = columns;
		lineColor = Color.BLACK;
		setPreferredSize( new Dimension(preferredSquareSize*columns, 
				preferredSquareSize*rows) );
		setBackground(Color.WHITE); // Set the background color for this panel.
		addMouseListener(this);     // Mouse actions will call methods in this object.
	}
	
	private int findRow(int pixelY) {
		return (int)(((double)pixelY)/getHeight()*gridRows);
	}
	
	private int findColumn(int pixelX) {
		return (int)(((double)pixelX)/getWidth()*gridCols);
	}
	
	public void mousePressed(MouseEvent evt) {
		int row, col; // the row and column in the grid of squares where the user clicked.
		row = findRow( evt.getY() );
		col = findColumn( evt.getX() );
		gridColor[row][col] = new Color( (int)(225*Math.random()),
				(int)(225*Math.random()),(int)(225*Math.random()) );
		repaint(); // Causes the panel to be redrawn, by calling the paintComponent method.
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
	
	public void mouseClicked(MouseEvent evt) { }
	public void mouseEntered(MouseEvent evt) {	}
	public void mouseExited(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }	
}