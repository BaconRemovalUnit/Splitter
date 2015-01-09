import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

/*
 *filename: Morph.java
 *Author:SuizhuShengqi
 *Date 2015Äê1ÔÂ9ÈÕ
 *Class:CSC172
 *Lab Session:MW	18:15-19:30
 */

public class Morph {
	
	boolean complete = false; //true when reaches maximu step
	int steps = 10; //default
	int Timer = 0; // starts at 0;
	int BaseLength;
	int x;
	int y;
	int base = 10;
	double	Width;
	double	Height;
	double	OldWidth;
	double	OldHeight;
	Color	color;
	
	
	/**
	 * @param a
	 * @param time
	 */
	public Morph(Node a) {
		this.x = a.x;
		this.y = a.y;
		this.OldHeight = a.Height;
		this.OldWidth = a.Width;
		this.color = a.color;
		// TODO Auto-generated constructor stub
		
		if(OldWidth<=BaseLength||OldHeight<=BaseLength)
			complete = true;
		
	}


	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @param timer2
	 */
	public void update() {
		Timer++;
		if(Timer==steps)
		{
			complete = true;
			return;
		}
		
		
		// TODO Auto-generated method stub
		
		
	}
}
