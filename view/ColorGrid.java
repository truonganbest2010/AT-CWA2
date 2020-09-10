package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorGrid extends JPanel implements MouseListener {

	private DrawingPanel panel;

	private int gridRows; 
	private int gridCols; 
	private Color[][] gridColor; 	                                
	private Color lineColor;

	private Color currentColor;


	public ColorGrid(DrawingPanel panel, int rows, int columns, int preferredSquareSize) {
		this.panel = panel;
		gridColor = new Color[rows][columns]; 
		gridRows = rows;
		gridCols = columns;
		lineColor = Color.BLACK;
		setPreferredSize( new Dimension(preferredSquareSize*columns, 
				preferredSquareSize*rows) );
		setBackground(Color.WHITE); 
		addMouseListener(this);     
	}
	
	private int findRow(int pixelY) {
		return (int)(((double)pixelY)/getHeight()*gridRows);
	}
	
	private int findColumn(int pixelX) {
		return (int)(((double)pixelX)/getWidth()*gridCols);
	}
	
	public void mousePressed(MouseEvent evt) {
		int row, col;
		row = findRow( evt.getY() );
		col = findColumn( evt.getX() );
		gridColor[row][col] = new Color( (int)(225*Math.random()),
				(int)(225*Math.random()),(int)(225*Math.random()) );
		currentColor = gridColor[row][col];	
		panel.getRedBtn().setSelected(false);
		panel.getGreenBtn().setSelected(false);
		panel.getBlueBtn().setSelected(false);
		panel.getYellowBtn().setSelected(false);
		panel.getBlackBtn().setSelected(false);
		panel.setColor(currentColor);
		repaint();
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