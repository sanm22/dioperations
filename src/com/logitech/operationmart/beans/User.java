package com.logitech.operationmart.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "BIOPS_USER")

public class User {
	
	@SuppressWarnings("unused")
	private final long serialVersionId = 4L;
	
	
	public int userId;
	public String userName;
	public String userPassword;
	public String recCreateDt;
	public String recUpdateDt;
	public String recCreateUser;
	public String recUpdateUser;
	public int isAdmin;

	public User() {
		super(); 
	}

	public User(int userId, String userName, String userPassword, String recCreateDt, String recUpdateDt,
			String recCreateUser, String recUpdateUser, int isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.recCreateDt = recCreateDt;
		this.recUpdateDt = recUpdateDt;
		this.recCreateUser = recCreateUser;
		this.recUpdateUser = recUpdateUser;
		this.isAdmin = isAdmin;
	}



	@Id
	@Column(nullable = true, name = "USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(nullable = true, name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(nullable = true, name = "USER_PASSWORD")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(nullable = true, name = "REC_CREATE_DT")
	public String getRecCreateDt() {
		return recCreateDt;
	}

	public void setRecCreateDt(String recCreateDt) {
		this.recCreateDt = recCreateDt;
	}

	@Column(nullable = true, name = "REC_UPDATE_DT")
	public String getRecUpdateDt() {
		return recUpdateDt;
	}

	public void setRecUpdateDt(String recUpdateDt) {
		this.recUpdateDt = recUpdateDt;
	}

	@Column(nullable = true, name = "REC_CREATE_USER")
	public String getRecCreateUser() {
		return recCreateUser;
	}

	public void setRecCreateUser(String recCreateUser) {
		this.recCreateUser = recCreateUser;
	}

	@Column(nullable = true, name = "REC_UPDATE_USER")
	public String getRecUpdateUser() {
		return recUpdateUser;
	}

	public void setRecUpdateUser(String recUpdateUser) {
		this.recUpdateUser = recUpdateUser;
	}

	@Column(nullable = true, name = "ISADMIN")
	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", recCreateDt="
				+ recCreateDt + ", recUpdateDt=" + recUpdateDt + ", recCreateUser=" + recCreateUser + ", recUpdateUser="
				+ recUpdateUser + ", isAdmin=" + isAdmin + "]";
	}

	
	
	
}
