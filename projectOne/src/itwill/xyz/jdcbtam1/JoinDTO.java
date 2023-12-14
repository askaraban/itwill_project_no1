package itwill.xyz.jdcbtam1;

import java.sql.Date;

/*
 이름      널?       유형           
------- -------- ------------ 
ID      NOT NULL VARCHAR2(10) 
PW      NOT NULL VARCHAR2(20) 
NAME    NOT NULL VARCHAR2(10) 
CAL     NOT NULL DATE         
BALANCE          NUMBER 
 
 */

public class JoinDTO {
	private String ID;
	private String pw;
	private String name;
	private Date cal;
	private int balance;
	
	
	public JoinDTO() {
		// TODO Auto-generated constructor stub
	}


	public JoinDTO(String iD, String pw, String name, Date cal, int balance) {
		super();
		ID = iD;
		this.pw = pw;
		this.name = name;
		this.cal = cal;
		this.balance = balance;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getCal() {
		return cal;
	}


	public void setCal(Date cal) {
		this.cal = cal;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}