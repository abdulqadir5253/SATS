package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracleConnection.Connect;

public class EmpSubmitModuleDao {
	
	Connect conn = new Connect();
	Connection con = conn.con();
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	public void insertValue(String ui, String moduleName){
		Date assignedDate = null;
		String managerId = null;
		String projectCode = null;
		try{
			
			PreparedStatement pstmt = con.prepareStatement("select * from modules where modulename = ?");
			pstmt.setString(1, moduleName);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				projectCode  = rs.getString(1);
				assignedDate = rs.getDate(2);
			}
			
			PreparedStatement pst = con.prepareStatement("select manager.emp_id from  manager, modules where manager.project_code = modules.projectcode and modules.modulename = ?");
			pst.setString(1, moduleName);
			ResultSet rs1 = pst.executeQuery();			
			while(rs1.next()){							
					 managerId = rs1.getString(1);
			}					
			
			Date submittedDate = getCurrentDate();
			PreparedStatement ps = con.prepareStatement("insert into projectLog values(?, ?, ?, ?, ?)");
			ps.setString(1, ui);
			ps.setString(2, projectCode );
			
			ps.setDate(3, assignedDate);
			ps.setDate(4, submittedDate);
			ps.setString(5, moduleName);				
			
			ps.executeUpdate();
			System.out.println("EmpSubmitModuleDao Values inserted");
			
			PreparedStatement ps1 = con.prepareStatement("delete from modules where modulename = ?");
			ps1.setString(1, moduleName);
			ps1.executeQuery();
			System.out.println("EmpSubmitModuleDao Row deleted");
								
		}
		
		catch(Exception e){
			System.out.println(e+ " EmpSubmitModuleDao");
		}
	}
	
}
