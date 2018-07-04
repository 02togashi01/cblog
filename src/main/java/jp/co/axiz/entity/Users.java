package jp.co.axiz.entity;

public class Users {

	private String id;
	private String pass;
	private String name;
	private String bestScore;
	private String date;
	private Integer role;		//1なら管理者、2なら一般ユーザ



	public Users() {

	}

	public Users(String id,String pass,String name) {
		this.id=id;
		this.pass=pass;
		this.name=name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBestScore() {
		return bestScore;
	}
	public void setBestScore(String bestScore) {
		this.bestScore = bestScore;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}






}
