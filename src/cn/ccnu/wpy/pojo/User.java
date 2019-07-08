package cn.ccnu.wpy.pojo;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private String passwordhash;
	private String question;
	private String answer;
	private boolean sex;
	private Date birth;
	private String phone;
	private String mail;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String passwordhash, String question, String answer, boolean sex, Date birth,
			String phone, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.passwordhash = passwordhash;
		this.question = question;
		this.answer = answer;
		this.sex = sex;
		this.birth = birth;
		this.phone = phone;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
