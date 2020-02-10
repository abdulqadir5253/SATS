package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ReviewProjectBean;
import oracleConnection.Connect;

public class ProjectReviewDao {

	
	public List<ReviewProjectBean> getInfo(String projectCode){
		Connect conn = new Connect();
		Connection con = conn.con();
		List<ReviewProjectBean> info =  new ArrayList<ReviewProjectBean>();
		
		
		try{
			PreparedStatement pst = con.prepareStatement("select * from projectLog where projectcode = ?");
			pst.setString(1, projectCode);
			ResultSet rs = pst.executeQuery();
			System.out.println("inside Review Project Dao");
			while(rs.next()){
				ReviewProjectBean r = new ReviewProjectBean();
				r.setEmpid(rs.getString(1));
				r.setAssignedDate(rs.getDate(3));
				r.setSubmittedDate(rs.getDate(4));
				r.setModuleName(rs.getString(5));		
				info.add(r);
			}
		}
		
		catch(Exception e){
			System.out.println(e + " ProjectReviewDao");
		}
		
		return info;
	}
}
