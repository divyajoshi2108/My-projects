package com.mygame.gui;

import java.awt.Graphics;

public class holes extends Sprite implements GameConstant {
	public holes(){
		x=300;
		w=h=50;
		y=FLOOR-h;
		
		
	}
public void drawholes(Graphics g){
		
	g.drawRect(x,y,w,h);
	
	if(Board.PlayerMove==true){
	move();
	System.out.println(x);
	}
	
}
public void move(){
	x-=speed;
}

}
