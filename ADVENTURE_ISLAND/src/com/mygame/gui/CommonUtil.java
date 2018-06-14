package com.mygame.gui;

import java.util.Random;

public class CommonUtil {
	Random r=new Random();
	public  int GetRandom(int range){
		int i=r.nextInt(range);
		return i;
	}

}