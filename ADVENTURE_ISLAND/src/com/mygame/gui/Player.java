package com.mygame.gui;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Sprite implements GameConstant {
	
	ArrayList<Hammer> hammerlist=new ArrayList<>();

	public ArrayList<Hammer> getHammerlist() {
		return hammerlist;
	}
	public void setHammerlist(ArrayList<Hammer> hammerlist) {
		this.hammerlist = hammerlist;
	}
	SpriteLoader sloader=new SpriteLoader();
	BufferedImage[] DEFAULT_MOVE;
	boolean Visible;
	public boolean isVisible() {
		return Visible;
	}
	public void setVisible(boolean visible) {
		Visible = visible;
	}
	public Player(){
		x=10;
		h=w=45;
		y=FLOOR-h;
		speed=0;
	Visible=true;
	
	}
	
	public void move()
	{
		x=x+speed;
	}
	
	int acc;
		public void fall(){
				if(y<(FLOOR-h)){
					acc = acc + GRAVITY;
					y += acc;
				}
				if(y>=(FLOOR-h)){
				y  =(FLOOR-h);
					isJump = false;
				}
			}
			private boolean isJump;
		public void jump(){
				if(!isJump){
				 acc = -15;
				 y+=acc;
				isJump = true;
			}
			}


	int CurrentMove=0;
public boolean reverse=false;
public boolean SkateMode;
	public  void drawaPlayerDefault(Graphics g){
		if (reverse==true)
		{
			DEFAULT_MOVE=sloader.PlayerFilpMove();
			System.out.println("back");
			}
		else if(SkateMode==true){
			DEFAULT_MOVE=sloader.PlayerSkateMove();
			
		}
		else{
			
			DEFAULT_MOVE=sloader.PlayerDefaultMove();
		}
		g.drawImage(DEFAULT_MOVE[CurrentMove],x,y,w,h,null);
		if(Board.count%3==0){
		CurrentMove++;
		
		if(CurrentMove>1){
			CurrentMove=0;
			
		}}
	}


		
	public void fire(){
				Hammer hammer= new Hammer(x+w/2,y+h/2);
				hammerlist.add(hammer);
				
}}