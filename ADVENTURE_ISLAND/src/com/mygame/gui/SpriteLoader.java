package com.mygame.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteLoader implements GameConstant  {
	BufferedImage img;
	BufferedImage img1;
	
	public SpriteLoader(){
		SpriteLoader();
		
		
	}
 public void SpriteLoader() {
	try {
		img=ImageIO.read(SpriteLoader.class.getResource(PLAYER_IMG));
		img1=ImageIO.read(SpriteLoader.class.getResource(ENEMY_IMG));		;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }

public BufferedImage[] PlayerDefaultMove(){
	BufferedImage bf[]=new BufferedImage[2];
	bf[0]=img.getSubimage(161, 40, 16, 32);
	bf[1]=img.getSubimage(186, 40, 16, 32);
			
						return bf;
}
public BufferedImage[] PlayerFilpMove(){
	BufferedImage bf[]=new BufferedImage[2];
	bf[0]=img.getSubimage(132, 5, 19, 32);
	bf[1]=img.getSubimage(81, 5, 16, 32);
			
						return bf;
}
public BufferedImage[] PlayerSkateMove(){
	BufferedImage bf[]=new BufferedImage[3];
	bf[0]=img.getSubimage(161, 111, 24, 32);
	bf[1]=img.getSubimage(193, 111, 24, 32);
	bf[2]=img.getSubimage(225, 111, 24, 32);
			
						return bf;
}

public BufferedImage[] SnailDefaultMove(){
	BufferedImage bf[]=new BufferedImage[2];
	bf[0]=img1.getSubimage(26, 7, 24, 24);
	bf[1]=img1.getSubimage(53, 15, 24, 16);
			
						return bf;
}
public BufferedImage[] OctoDefaultMove(){
	BufferedImage bf[]=new BufferedImage[2];
	bf[0]=img1.getSubimage(103, 144, 16, 20);
	bf[1]=img1.getSubimage(85, 143, 12, 21);
			
						return bf;
}

public BufferedImage[] SnakeDefaultMove(){
	BufferedImage bf[]=new BufferedImage[2];
	bf[0]=img1.getSubimage(102, 8, 15, 23);
	bf[1]=img1.getSubimage(82, 8, 15, 23);
			
						return bf;
}
public BufferedImage[] HammerMove(){
	BufferedImage bf[]=new BufferedImage[4];
	bf[0]=img1.getSubimage(142, 61, 16, 15);
	bf[1]=img1.getSubimage(101, 61, 16, 15);
	bf[2]=img1.getSubimage(122, 60, 15, 16);
	bf[3]=img1.getSubimage(79, 60, 15, 16);
			
						return bf;
}
}