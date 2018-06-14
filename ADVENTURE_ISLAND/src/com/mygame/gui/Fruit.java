package com.mygame.gui;

import java.awt.Graphics;
import java.awt.Image;


public class Fruit extends Sprite implements GameConstant {
	boolean Visible;
	public boolean isVisible() {
		return Visible;
	}
	public void setVisible(boolean visible) {
		Visible = visible;
	}
	public Fruit(int x,Image img){
		Visible=true;

		this.x = x;
			this.h = this.w = 30;
			this.y = 450;
			
			//this.speed = -10;
			this.img = img;
			}
			public void drawFruit(Graphics g){
						g.drawImage(img, x, y, w, h, null);
			}
	
			public void move(){
	
				speed = SPEED;
				x-=speed;
				
			}
	}


