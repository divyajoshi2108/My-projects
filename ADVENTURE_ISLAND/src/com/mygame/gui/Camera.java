package  com.mygame.gui;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import javax.imageio.ImageIO;

public class Camera implements GameConstant {
	BufferedImage bi;
	int speed;
		int x;
int y;
	public void move(){
		x+=speed;
	}
	public void left(){
		if(x>SPEED){
		speed = -10;
		move();
		}
	}
	public void right(){
		
	
		if(x<(3990-GAME_WIDTH))
		{
		speed  = SPEED;

	move();
		}
	}
	public int  getX(){
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void drawBG(Graphics g){
		BufferedImage subI = bi.getSubimage(x, y, Gwidth, Gheight);
		g.drawImage(subI,0,0,Gwidth, Gheight,null);
	}
	public Camera(){
		
			
		try {
			bi  = ImageIO.read(Camera.class.getResource(BG_IMG));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Background not found ");
			e.printStackTrace();
		}
		
		}}
	
