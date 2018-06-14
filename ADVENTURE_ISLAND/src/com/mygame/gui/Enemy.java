package com.mygame.gui;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;



public class Enemy extends Sprite implements GameConstant,NoEnemy {
	ArrayList<Fish> fishlist=new ArrayList<>();

	
	SpriteLoader sloader=new SpriteLoader();
	BufferedImage[] bf;
	boolean IsVisible;
	public boolean isIsVisible() {
		return IsVisible;
	}

	public void setIsVisible(boolean isVisible) {
		IsVisible = isVisible;
	}

	public Enemy(int x,int gap,int choice ){
IsVisible=true;
this.x=x+ 300*gap;

	this.h = this.w = 30;
	this.y = FLOOR - h;
	
	this.speed = 0;
	ChooseEnemy(choice);
	
	
	}

	public void move(){
		
		speed = SPEED;
		x-=speed;
		
	}
	
	
	public void ChooseEnemy(int choice){
		switch (choice){
		case SNAIL:
		{bf=sloader.SnailDefaultMove();

			break;
		}
		case OCTO:
		{
			bf=sloader.OctoDefaultMove();	
			break;
		}
		case SNAKE:
		{
			bf=sloader.SnakeDefaultMove();
			break;
			
		}
			
		}
	}
	
	
	public void fire(){
		Fish fish= new Fish(x+w/2,y+h/2);
		fishlist.add(fish);
	}
	int CurrentMove=0;
	
	public  void drawEnemyDefault(Graphics g){
		g.drawImage(bf [CurrentMove],x,y,w,h,null);
	
		if(Board.count%2==0){
		CurrentMove++;
	
		if(CurrentMove>1){
			CurrentMove=0;
			
		}
	}
	}
	}
