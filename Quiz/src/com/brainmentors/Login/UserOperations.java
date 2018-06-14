package com.brainmentors.Login;

import java.util.ArrayList;

public class UserOperations {
	private UserOperations(){};
	static private UserOperations u;
	ArrayList<UserInfo> list=new ArrayList();
	
	public String AddUser(UserInfo I){
		System.out.println(list.add(I));
		return "User Added";
	}
	
	public ArrayList<UserInfo> getItems(){
				return list;
		}
	
	public int RegCheck( int id, String pwd){
	UserInfo user = new UserInfo (id ,pwd);
return list.indexOf(user);
		
	}
	
	public static  UserOperations getInstance(){
		if(u==null){
		u=new UserOperations();
		}
		return u;
	}

}
