package entity;

import java.util.Date;

public class User {
	//用户信息实体类
	private String userName;
	private String passWord;
	private String email;
	private String gender;
	private Date birthday;
	private String[] favorites;
	private String interduce;
	private boolean flg;
	
	public User(){
		
	}

	public boolean isFlg() {
		return flg;
	}

	public void setFlg(boolean flg) {
		this.flg = flg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String[] getFavorites() {
		return favorites;
	}

	public void setFavorites(String[] favorites) {
		this.favorites = favorites;
	}

	public String getInterduce() {
		return interduce;
	}

	public void setInterduce(String interduce) {
		this.interduce = interduce;
	}

	

	

	
	

	

	

	
	
	
	

}
