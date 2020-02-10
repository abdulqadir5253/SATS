package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracleConnection.Connect;


public class AddModuleToEmpDao {
	
	Connect connect = new Connect();
	Connection con = connect.con();
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	public Boolean insert(String module, String projecCode, String endDate, String emp_id){
		
		try {
									
			PreparedStatement ps = con.prepareStatement("insert into modules values(?, ?, ?, ?, ?)");
			ps.setString(1, projecCode);
			ps.setDate(2, getCurrentDate());
			
			ps.setString(3, module);
			ps.setString(4, emp_id);
			ps.setString(5, endDate);
			
			int row = ps.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("AddModuleToEmpDao Insertion error");
			e.printStackTrace();
		}
		return true;
	}
}
