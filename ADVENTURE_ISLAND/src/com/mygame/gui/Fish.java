package com.mygame.gui;


import java.awt.Graphics;
import java.awt.Image;


public class Fish extends Sprite implements GameConstant {
	boolean Visible;
	public boolean isVisible() {
		return Visible;
	}
	public void setVisible(boolean visible) {
		Visible = visible;
	}
	public Fish(int x,int  y){
		Visible=true;

		this.x = x;
			this.h = this.w = 50;
			this.y = y;
			
			//this.speed = -10;
			
			}
			public void drawFruit(Graphics g){
						g.drawImage(img, x, y, w, h, null);
			}
	
			public void move(){
	
				speed = SPEED;
				x-=speed;
				
			}
	}
