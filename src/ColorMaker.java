import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 *filename: ColorMaker.java
 *Author:SuizhuShengqi
 *Class:CSC172
 *Lab Session:MW	18:15-19:30
 */

public class ColorMaker {

 int boardX;
 int boardY;
 int imgX;
 int imgY;
 int leap = 10;
 File name;
 BufferedImage image;
 int[][] board;
 
 ColorMaker(String addr, int x, int y) 	{
	 name = new File("input.jpg");
	 System.out.println(name.getAbsolutePath());
	 this.boardX = x;
	 this.boardY = y;
	 try {
		image = ImageIO.read(name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 imgX = image.getWidth();
	 imgY = image.getHeight();
	 initialize();
 }
 
private void initialize() {
	board = new int[boardX][boardY];
	//convert to suitable board size
	double zoomX = (image.getWidth()*1.0)/(boardX*1.0);
	double zoomY = (image.getHeight()*1.0)/(boardY*1.0);

	for(int i=0; i<board.length; i++){
		for(int j=0; j<board[0].length; j++){
			board[i][j] = image.getRGB((int)(i*zoomX), (int)(j*zoomY));
		}
	}
	
}

public Color consult(int xcord, int ycord, int width, int height)	{
	 Color c = Color.gray;//default
	 int sum = 0;
	 try	{
		 for(int i=0; i<width; i++){
			 for(int j=0; j< height; j++) {
				 sum += board[xcord+i][ycord+j]; 
			 }
		}
		 c = new Color(sum/(width*height));
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
	 return c;
 }

}
