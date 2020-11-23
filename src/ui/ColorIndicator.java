package ui;


import java.awt.*;

import javax.swing.* ;
//each block is an instance of ColorIndicator
public class ColorIndicator extends JPanel
{
	private final DrawingApp drawingApp ;
	private int x;
	private int y;
	

	public ColorIndicator(DrawingApp drawingApp, Color cl,int x, int y)
	{
			this.drawingApp = drawingApp ;
			this.x = x;
			this.y = y;
			setPreferredSize(new Dimension(100,100)) ;
			setBackground(cl);
			addMouseListener(drawingApp);
	}
	public int getXCoord() {
		return x;
}
	public int getYCoord() {
		return y;
 }
	
}
