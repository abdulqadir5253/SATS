package oracleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
	public static void main(String args[]){  
		try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:orcl","hr","oracle");  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		System.out.println("Connection succeeded");  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from hi");  
		while(rs.next())  
		System.out.println(rs.getString(1));  
		  
		//step5 close the connection object  
		con.close();  		 
		}catch(Exception e){ System.out.println(e);}  
		  
		}
	
	public Connection con(){
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","hr","oracle");
			
			return con;
		}
		catch(Exception e){
			System.out.println("COnnection error");
		}
		
		return null;
	}
}
