package com.mygame.gui;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Egg extends Sprite implements GameConstant{
	boolean Visible;
	public boolean isVisible() {
		return Visible;
	}
	public void setVisible(boolean visible) {
		Visible = visible;
	}
	public Egg(){
		Visible=true;
		x=800;
		h=w=30;
		y=FLOOR-h;
		try {
			img=ImageIO.read(Board.class.getResource(FRUIT_IMG)).getSubimage(3, 2, 22, 16);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void drawEgg(Graphics g){
		g.drawImage(img,x,y,w,h,null);
	}
public void move(){
		
		speed = SPEED;
		x-=speed;
		
	}
	

}
