import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;


/*
 *filename: Node.java
 *Author:SuizhuShengqi
 *Date 2015Äê1ÔÂ7ÈÕ
 *Class:CSC172
 *Lab Session:MW	18:15-19:30
 */

public class Node{

	//starting coordinates
	int x;
	int y;
	int base = 10;
	double Width;
	double Height;
	
	Shape shape = null;
	Color color = Color.gray;
	
	public Node(int x, int y, int Width, int Height) {
		this.x = x;
		this.y =y;
		this.Width = Width;
		this.Height= Height;

		this.shape = new Ellipse2D.Float(x, y,(int)Width, (int)Height);
	}

	public Node(int x, int y, int Width, int Height, Color c) {
		this.x = x;
		this.y =y;
		this.Width = Width;
		this.Height= Height;
		this.color = c;
		this.shape = new Ellipse2D.Float(x, y,(int)Width, (int)Height);
	}
	
    protected void paintComponent(Graphics g) {
    	g.setColor(color);
        g.fillOval(x, y,(int)Width, (int)Height);

    }
    
    public boolean contains(int x, int y) {
        return shape.contains(x, y);
    }
    




}
