package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.LoggedInBean;

public class LoginDao {
	 		
	public static void main(String args[]){
//		LoginDao login = new LoginDao();
//		Boolean valid = login.hi("16ESKIT006", "161");
//		System.out.println(valid);
	}
	public  String hi(String uname, String pswd){		
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");		  		 
		//step2 create  the connection object  
		
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:orcl","hr","oracle");		
		
		PreparedStatement pstmt = con.prepareStatement("select * from Login where user_id = ?");
		
		pstmt.setString(1, uname);
		
		ResultSet rs = pstmt.executeQuery();	
		
		if(!rs.next())
			return("userId");
		else{
			if(rs.getString(2).equals(pswd)){				
				{
					String userId = rs.getString(1);					
					LoggedInBean login = new LoggedInBean();					
					login.setId(rs.getString(1));
					
					pstmt = con.prepareStatement("select project_code from manager where emp_id=?");
					pstmt.setString(1, userId);
					rs = pstmt.executeQuery();
					if(!rs.next())
						return("employee");
					else
						return("manager");
				}
			}
			else{				
				return("password");
			}
		}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error LoginDao");
			e.printStackTrace();
		}
		return null;
		
	}
}
