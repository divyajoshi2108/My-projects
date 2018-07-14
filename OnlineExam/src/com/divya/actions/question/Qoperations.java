package com.divya.actions.question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.divya.actions.UserDAO;

 public class Qoperations {
	static  public HashSet<Questions> List=null;
	public static int d=0;

public static HashSet<Questions> FirstQ() throws ClassNotFoundException, SQLException{

	
	if(List==null){
		List=new HashSet();
		UserDAO UserDAO=new UserDAO();
		List=UserDAO.GetQ();
		System.out.println(List);
	}
	
	return List;
	
}
public static void Nextq(){
	if(d<2){
	d++;
	}
}

public static void Preq(){
	if(d>0){
	d--;	
	}
}
	

}
