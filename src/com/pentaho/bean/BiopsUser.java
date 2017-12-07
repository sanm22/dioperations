package com.pentaho.bean;

public class BiopsUser {
	private static int userId;
	private String userName;
	private String userPassword;
	private String recCreateDt;
	private String recUpdateDt;
	private String recCreateUser;
	private String recUpdateUser;

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		BiopsUser.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRecCreateDt() {
		return recCreateDt;
	}

	public void setRecCreateDt(String recCreateDt) {
		this.recCreateDt = recCreateDt;
	}

	public String getRecUpdateDt() {
		return recUpdateDt;
	}

	public void setRecUpdateDt(String recUpdateDt) {
		this.recUpdateDt = recUpdateDt;
	}

	public String getRecCreateUser() {
		return recCreateUser;
	}

	public void setRecCreateUser(String recCreateUser) {
		this.recCreateUser = recCreateUser;
	}

	public String getRecUpdateUser() {
		return recUpdateUser;
	}

	public void setRecUpdateUser(String recUpdateUser) {
		this.recUpdateUser = recUpdateUser;
	}

}
