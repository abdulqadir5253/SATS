package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.ManagerInfoBean;

public class ManagerDetailsDao {
	
	ArrayList<String> manager = new ArrayList<String>();
	
	
	public List<ManagerInfoBean> managerInfo (String userId){
			
		List<ManagerInfoBean> manager = new ArrayList<ManagerInfoBean>();
		Connection conn = con();		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from manager where emp_id = ?");
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				ManagerInfoBean employee = new ManagerInfoBean();
				employee.setEmpId(rs.getString(1));
				
				employee.setProjName(rs.getString(2));
				employee.setStatus(rs.getString(3));
				manager.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;		
	}
	
	static Connection con(){
		Connection con1;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");		  		 
			//step2 create  the connection object  
			
			con1=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:orcl","hr","oracle");
			return con1;
		}
		catch(Exception e){
			
		}
		return null; 
	}
}
