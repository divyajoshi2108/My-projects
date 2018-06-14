package com.mygame.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Hammer extends Sprite implements GameConstant {
	
	SpriteLoader sloader=new SpriteLoader();
BufferedImage [] bf=sloader.HammerMove();
	
	public boolean isVisible() 
	{
		return isVisible;
	}
	private boolean isVisible;
public void setVisible(boolean isVisible) {
	this.isVisible = isVisible;
}
		public Hammer(int x, int y){
	this.x = x;
		this.y = y;
		this.speed = 10;
		this.h = this.w = 15;
		isVisible = true;
		
	}
		int CurrentMove=0;
		
	public void drawHammer(Graphics g){
		g.drawImage(bf[CurrentMove],x,y,w,h,null);
		if(Board.count%3==0){
		CurrentMove++;
	
		if(CurrentMove>1){
			CurrentMove=0;
			
		}}
	move();
	
	}
		

	public void Flipmove(){
		x-=speed;
}
	public void outOfScreen(){
		if(x>=GAME_WIDTH ||y>=FLOOR){
			isVisible = false;
		}
	}
	int acc=-5;
	
	public void move(){

y+=acc;
acc++;
x+=10*GRAVITY;


			
			}
	}
	