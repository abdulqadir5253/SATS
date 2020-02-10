package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AddTaskSearchBean;
import oracleConnection.Connect;

public class AddtaskSearchDao {
	
	Connect con = new Connect();
	Connection conn = con.con();
	List<AddTaskSearchBean> emps = new ArrayList<AddTaskSearchBean>();
	
	public List<AddTaskSearchBean> empList(String search) throws SQLException{
		
		PreparedStatement ps = conn.prepareStatement("select * from skillsReview where skills like ?");
		ps.setString(1, "%"+search+"%");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			AddTaskSearchBean emp = new AddTaskSearchBean();
			emp.setId(rs.getString(1));
			emp.setTech(rs.getString(2));
			emp.setReview(rs.getInt(3));
			emps.add(emp);
		}
		
		return emps;		
	}
}
