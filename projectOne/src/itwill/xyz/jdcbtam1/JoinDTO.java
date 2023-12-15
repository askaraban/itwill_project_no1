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


/*
AC_ID   NOT NULL VARCHAR2(30) 
AC_NUM  NOT NULL VARCHAR2(30) 
AC_PW   NOT NULL NUMBER(4)    
AC_KIND NOT NULL VARCHAR2(40)
*/


public class JoinDTO {
//	********** 회원정보 필드 **********
	private String ID;
	private String pw;
	private String name;
	private String cal;
	private int balance;
//	********** 입출금 필드 ************
	private int deposit;
	private int withdraw;
	private String memo;
	private String cid;
	private Timestamp iocal;
	private String Iotype;
	private int hbalance;
// *********** 계좌 정보 필드 *********
	private String ac_num;
	private int ac_pw;
	private String ac_kind;
	
	
	
	
	public String getAc_num() {
		return ac_num;
	}

	public void setAc_num(String ac_num) {
		this.ac_num = ac_num;
	}

	public int getAc_pw() {
		return ac_pw;
	}

	public void setAc_pw(int ac_pw) {
		this.ac_pw = ac_pw;
	}

	public String getAc_kind() {
		return ac_kind;
	}

	public void setAc_kind(String ac_kind) {
		this.ac_kind = ac_kind;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public Timestamp getIocal() {
		return iocal;
	}

	public void setIocal(Timestamp iocal) {
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