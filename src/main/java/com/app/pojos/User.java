package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_dtls")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 20)
	private String name;

	@Column(length = 30)
	private String email;

	private String password;

	@Column(length = 10)
	private String mobileNo;

	private String role;

	private int marks;

	@Column(name = "time_taken")
	private int timeTaken;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Result result;

	public User() {
		System.out.println("in def ctor");
	}

	public User(String name, String email, String password, String mobileNo, int marks, int timeTaken) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.marks = marks;
		this.timeTaken = timeTaken;
	}

	public User(String name, String email, String password, String mobileNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public void addResult(Result r) {
		this.result = r;
		r.setUser(this);
	}
	
	public void removeResult(Result r) {
		r.setUser(null);
		this.result = null;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobileNo="
				+ mobileNo + ", marks=" + marks + ", timeTaken=" + timeTaken + "]";
	}

}
