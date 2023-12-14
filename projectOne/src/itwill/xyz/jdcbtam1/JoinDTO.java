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

/*
SNO      NOT NULL NUMBER        
CID               VARCHAR2(50)  
DEPOSIT           NUMBER        
WITHDRAW          NUMBER        
MEMO              VARCHAR2(100) 
IOCAL    NOT NULL DATE  
*/

public class JoinDTO {
	private String ID;
	private String pw;
	private String name;
	private Date cal;
	private int balance;
	private int deposit;
	private int withdraw;
	private String memo;
	private String cid;
	private Date local;
	private String Iotype;

	public JoinDTO(int balance, int deposit, int withdraw, String memo, String cid, Date local, String Iotype) {
		super();
		this.balance = balance;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.memo = memo;
		this.cid = cid;
		this.local = local;
		this.Iotype = Iotype;
	}

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

	public Date getLocal() {
		return local;
	}

	public void setLocal(Date local) {
		this.local = local;
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

	public String getIotype() {
		return Iotype;
	}

	public void setIotype(String iotype) {
		Iotype = iotype;
	}

}