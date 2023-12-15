package itwill.xyz.jdcbtam1;

import java.sql.Date;
import java.sql.Timestamp;

/*
이름      널?       유형           
------- -------- ------------ 
ID      NOT NULL VARCHAR2(10) 
PW      NOT NULL VARCHAR2(20) 
NAME    NOT NULL VARCHAR2(10) 
CAL     NOT NULL DATE         
BALANCE          NUMBER 
 
*/

/*
이름      널?       유형           
------- -------- ------------ 
ID      NOT NULL VARCHAR2(10) 
PW      NOT NULL VARCHAR2(20) 
NAME    NOT NULL VARCHAR2(20) 
CAL     NOT NULL DATE         
BALANCE          NUMBER     
*/

public class JoinDTO {
//	********** 회원정보 필드 **********
	private String ID;
	private String pw;
	private String name;
	private Date cal;
	private int balance;
//	********** 입출금 필드 ************
	private int deposit;
	private int withdraw;
	private String memo;
	private String cid;
	private Date iocal;
	private String Iotype;
	private int hbalance;
// *********** 계좌 정보 필드 *********
	
	
	
	
	
	
	
	
	
	public Date getCal() {
		return cal;
	}

	public void setCal(Date cal) {
		this.cal = cal;
	}

	public Date getIocal() {
		return iocal;
	}

	public void setIocal(Date iocal) {
		this.iocal = iocal;
	}

	public int getHbalance() {
		return hbalance;
	}

	public void setHbalance(int hbalance) {
		this.hbalance = hbalance;
	}


	

	
	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}



	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
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


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getIotype() {
		return Iotype;
	}

	public void setIotype(String iotype) {
		Iotype = iotype;
	}

}