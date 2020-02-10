package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeInfoBean;

import oracleConnection.Connect;

public class EmployeeDetailDao {
	
	Connect conn = new Connect();
	Connection con = conn.con();
	
	public List<EmployeeInfoBean> employeeDetail(String id){
		List<EmployeeInfoBean> emps = new ArrayList<EmployeeInfoBean>();
		
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from modules where emp_id = ?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				EmployeeInfoBean employee = new EmployeeInfoBean();
				employee.setProjectCode(rs.getString(1));
				employee.setStartDate(rs.getDate(2));
				employee.setModuleName(rs.getString(3));
				employee.setEndDate(rs.getString(5));				
				emps.add(employee);
			}
		}
		
		catch(Exception e){
			System.out.println("Error in Employee Page");
		}
		
		
		
		return emps;
	}
	

}
