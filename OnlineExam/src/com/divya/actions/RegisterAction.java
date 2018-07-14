package com.divya.actions;
import com.divya.actions.question.Qoperations;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.divya.actions.question.Qoperations;
import com.divya.actions.question.Questions;

public class RegisterAction {
	private String Username;
	public int getTotalQ() {
		return TotalQ;
	}
	public void setTotalQ(int totalQ) {
		TotalQ = totalQ;
	}
	private String Password;
	private String r;
	UserDAO userDAO = new UserDAO();
	HashSet<Questions> List=new HashSet();
	int TotalQ;
public HashSet<Questions> getList() {
		return List;
	}
	public void setList(HashSet<Questions> list) {
		List = list;
	}
String ques;
String Ans[];
String yourAns="NIL";
String Uans="NIL";
public String getUans() {
	return Uans;
}
public void setUans(String uans) {
	Uans = uans;
}

int i=0 ;
public String getYourAns() {
	return yourAns;
}
public void setYourAns(String yourAns) {
	this.yourAns = yourAns;
}

public String getQues() {
	return ques;
}
public void setQues(String ques) {
	this.ques = ques;
}
public String[] getAns() {
	return Ans;
}
public void setAns(String[] ans) {
	Ans = ans;
}


public int getI() {
	return i;
}
public void setI(int i) {
	this.i = i;
}

	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String Username) {
		this.Username = Username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}



	public String Registered() throws ClassNotFoundException, SQLException{
		userDAO.Register(Username,Password);
		System.out.println(Username);
		System.out.println(Password);
		System.out.println("Registered......");
return "registered";
	}
	public String Login() throws ClassNotFoundException, SQLException{
	
		if(userDAO.isUserExist(Username,Password))
			{
			System.out.println("Logined......");
	
			AddQ();
			
			return "login";
			}
		else
			{
			System.out.println("Register Firstly......");
			r="Register First";
			return "NotRegistered";
			}
	}


	
public Questions AddQ() throws ClassNotFoundException, SQLException {
	
	List=Qoperations.FirstQ();
	TotalQ=List.size();
	System.out.println(TotalQ);
	Questions Q=getQuestionByIndex(Qoperations.d);	
	System.out.println(Qoperations.d);
	 i=(Qoperations.d)+1;
	 Q.setQid(i);
	ques=Q.getQuestion();
		Ans=Q.getAnswer();
		if(Q.getYAns()!="NIL"){
		Uans=Q.getYAns();
		}
	/*	System.out.println(ques);
		
		
		System.out.println(Ans[0]);
		System.out.println(Ans[1]);
		System.out.println(Ans[2]);
		System.out.println(Ans[3]);*/
		return Q;

}

public Questions getQuestionByIndex(int index) {
	int start = 0;
	Questions currentQuestion = null;
	Iterator<Questions> questionItr = List.iterator();
	while(questionItr.hasNext()){
		 currentQuestion = questionItr.next();
		 System.out.println( currentQuestion);
		if(start==index){
			break;
		}
		start++;
	}
	
	return currentQuestion;
}

public String NextQ() throws ClassNotFoundException, SQLException {
	
	Qoperations.Nextq();
		AddQ();
		System.out.println("i m next....");
		return "next";
}

public String PreviousQ() throws ClassNotFoundException, SQLException {
	Qoperations.Preq();
	AddQ();
	System.out.println("i m previous.....");
	return "Previous";
}

public String Submit() throws ClassNotFoundException, SQLException{
 Questions q=AddQ();
	 Uans=yourAns;
	 q.setYAns(yourAns);
	 System.out.println(q.getYAns());
	 System.out.println(q.getRAns());
	 if(q.getYAns().equals(q.getRAns())){
		 q.setAnswered(true);
		 
		 System.out.println(q.isAnswered());}
	 else{
		 q.setAnswered(false);
		 System.out.println(q.isAnswered());
		 }
	return "submitted";
}

public String Execute() throws ClassNotFoundException, SQLException{

	List=Qoperations.FirstQ();
	
	return "done";
	
}
}