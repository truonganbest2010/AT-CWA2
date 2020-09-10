package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrentColor extends JPanel implements MouseListener {

	private DrawingPanel panel;

	private int gridRows = 1; 
	private int gridCols = 10; 
	private Color[][] gridColor; 	                                
	private Color lineColor;

	private Color currentColor;


	public CurrentColor(DrawingPanel panel, int preferredSquareSize) {
		this.panel = panel;
		gridColor = new Color[gridRows][gridCols];
		lineColor = Color.BLACK;
		setPreferredSize( new Dimension(preferredSquareSize*gridCols, 
                preferredSquareSize*gridRows) );
        for (int i = 0; i < gridCols; i++){
            gridColor[0][i] = Color.white;
        }
		setBackground(Color.WHITE); 
		addMouseListener(this);     
    }
    
    public void addColor(Color color){
        for (int i = gridCols-1; i > 1; i--){
            gridColor[0][i] = gridColor[0][i-1];
        }
        gridColor[0][1] = color;
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
        currentColor = gridColor[row][col];	
        //
		panel.getColorGroup().clearSelection();
        //
        panel.setColor(currentColor);
		panel.getColorSetShow().setColor(currentColor);
        panel.getColorSetShow().repaint();
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