import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/*
 *filename: Map.java
 *Author:SuizhuShengqi
 *Date 2015Äê1ÔÂ8ÈÕ
 *Class:CSC172
 *Lab Session:MW	18:15-19:30
 */

public class Map extends JPanel{
	ArrayList<Node> nodes = new ArrayList<Node>();
	ArrayList<Node> dead = new ArrayList<Node>();
	ArrayList<Morph> animate = new ArrayList<Morph>();
	Point location = new Point(0,0);
	private Timer timer;
	int DELAY = 30;

	
	
	public static void main(String[] args)
	{
        JFrame frame = new JFrame("Spliter");
        frame.setSize(900, 900);
        frame.add(new Map());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Map()
	{
		LocationListener listen = new LocationListener();
		addMouseListener(listen);
		addMouseMotionListener(listen);
		Node init = new Node(0,0,850,850);
		nodes.add(init);
		timer = new Timer(DELAY, new BoardListener());
		timer.start();
		
	}
	
	private class LocationListener implements MouseListener,MouseMotionListener
	{

		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			location = e.getPoint();
		}

		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			location = e.getPoint();	
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	private class BoardListener implements ActionListener
	{
		int i = 50;
		public void actionPerformed(ActionEvent e) 
		{
			Node a =getSelectedNode();
			if(a!=null) {
				
				if( (int)a.Width > a.base)	{
				Morph b = new Morph(a);
				animate.add(b);
				nodes.remove(a);
				}
			}
			animation();
			

			repaint();
		}

		private Node getSelectedNode() {
			for(Node n : nodes) {
				if(n.contains(location.x,location.y)) {
					return n;
				}
			}
			return null;
		}

		private void animation() {
			
			// TODO Auto-generated method stub

			for(int i =0; i<animate.size(); i++)
			{
				Morph m = animate.get(i);
				if(!m.complete)
				m.update();
				else
				{
				
				animate.remove(m);
				int a1 = ((int)m.OldWidth)/2+m.x;
				int b1 = ((int)m.OldHeight)/2+m.y;
				Node nw = new Node(m.x,m.y,(int)m.OldWidth/2, (int)m.OldHeight/2,new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				Node ne = new Node(a1,m.y,(int)m.OldWidth/2, (int)m.OldHeight/2,new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				Node sw = new Node(m.x,b1,(int)m.OldWidth/2, (int)m.OldHeight/2,new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				Node se = new Node(a1,b1,(int)m.OldWidth/2, (int)m.OldHeight/2,new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				if(((int)m.OldWidth)/2<=m.base)	{
				dead.add(nw);
				dead.add(ne);
				dead.add(sw);
				dead.add(se);
				}
				else	{

				nodes.add(nw);
				nodes.add(ne);
				nodes.add(sw);
				nodes.add(se);
				}
				//Node nw = new Node(a.x,a.y,a.Width/2, a.Height/2)
				//nodes.add();
				}
			}

			//add four nodes before reaching base case
			//if(width/4>base case)
			//nodes.add()
			//nodes.add(e)
			//
			
		}
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		paintNodes(g);
		paintDeadNodes(g);
		 
		//paintMorphs(g);
	}

	private void paintMorphs(Graphics g) {
		for(Morph m : animate)
			m.paintComponent(g);
	}
	

	private void paintNodes(Graphics g) {
		for(Node n : nodes)
			n.paintComponent(g);
	}
	
	private void paintDeadNodes(Graphics g) {
		for(Node n : dead)
			n.paintComponent(g);
	}
	
}