package bean;

public class ManagerInfoBean {		
	private String ProjName;
	private String status;
	private String EmpId;
	
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String id) {
		EmpId = id;
	}
	public String getProjName() {
		return ProjName;
	}
	public void setProjName(String projName) {
		ProjName = projName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
