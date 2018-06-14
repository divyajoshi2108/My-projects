package com.brainmentors.Questions;

import java.util.ArrayList;

import com.brainmentors.Login.UserInfo;
import com.brainmentors.Login.UserOperations;


public class QOperations {
	private QOperations(){};
	static private  QOperations q;
	ArrayList<Questions> list=new ArrayList();
	
	public static   QOperations  getInstance(){
		if(q==null){
		q=new  QOperations ();
		}
		return q;
	}
	int r=0;
	public void AddQ(){
		CommonUtils c=new CommonUtils();
		 r=c.GetRandom(3);
		 
		list.add(new Questions(r));
		//System.out.println(r);
		
	//	int a=unique();
		list.add(new Questions(unique()));
		//System.out.println(a);
		
	//	int b=unique();
		list.add(new Questions(unique()));
		//System.out.println();
		
		System.out.println(list.get(0).getQuestion());
		System.out.println(list.get(1).getQuestion());
		System.out.println(list.get(2).getQuestion());
		
	}
	public ArrayList<Questions> getQ(){
		return list;
}
	
private int unique(){
		

	if(r>=2){
		r=0;
	}
	else
	{
	r++;
	}
	return r;
	}

}
