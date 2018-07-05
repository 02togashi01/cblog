package jp.co.axiz.entity;

public class Users {

	private String user_id;
	private String pass;
	private String name;
	private Integer role;		//1なら管理者、2なら一般ユーザ



	public Users(String user_id,String pass,String name) {
		this.user_id = user_id;
		this.pass=pass;
		this.name=name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}

}