package com.divya.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.HashSet;

import com.divya.actions.question.Questions;

public class UserDAO {
	private Connection createConnection() throws ClassNotFoundException, SQLException{
		/*ResourceBundle rb = ResourceBundle.getBundle("global.properties");
		Class.forName(rb.getString("drivername"));
		Connection connection = DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),rb.getString("password"));*/
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb","root","database");
		
		return connection;
		
	}
	public void Register(String username,String password) throws SQLException, ClassNotFoundException{
		
		Connection connection = null;
		PreparedStatement pstmt = null;
	
		 String query = "insert into user_mst (username,password)"
			        + " values (?, ?)";
		try{
			connection = createConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			int rowCount = pstmt.executeUpdate();
			System.out.println("Row Count is "+rowCount);
		
			}
		
		finally{
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		
	}
	
	public boolean isUserExist(String username,String password) throws ClassNotFoundException, SQLException{
		boolean isExist = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			con = createConnection();
			pstmt = con.prepareStatement("select username,password from user_mst where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				isExist = true;
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return isExist;
	}
	public HashSet <Questions> GetQ() throws ClassNotFoundException, SQLException{
		HashSet <Questions> QList =new HashSet();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			con = createConnection();
			pstmt = con.prepareStatement("select Qid,Question,Ans1,Ans2,Ans3,Ans4,YAns,RAns from Qmst ");
		   rs = pstmt.executeQuery();
			while(rs.next()){
				String Qid=rs.getString("Qid");
				String Q=rs.getString("Question");
				String Ans1=rs.getString("Ans1");
				String Ans2=rs.getString("Ans2");
				String Ans3=rs.getString("Ans3");
				String Ans4=rs.getString("Ans4");
				String YAns=rs.getString("YAns");
				String RAns=rs.getString("RAns");
			
				String Answers[]={Ans1,Ans2,Ans3,Ans4};
				Questions q =new Questions(Integer.parseInt(Qid),Q,Answers,YAns,RAns);
				QList.add(q);
			
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return QList;

		
	}

}


