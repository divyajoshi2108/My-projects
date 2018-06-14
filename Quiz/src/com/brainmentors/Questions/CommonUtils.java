package com.brainmentors.Questions;

import java.util.Random;

public class CommonUtils {
Random r=new Random();
	
	public  int GetRandom(int range){
		int i=r.nextInt(range);
		return i;
	}

}
