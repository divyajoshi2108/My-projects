package com.mygame.gui;


import javax.swing.JFrame;

public class Frame extends JFrame implements GameConstant {
	public Frame(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		Board Board =new Board();
		add(Board);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		Frame Frame=new Frame();
		
	}

}
