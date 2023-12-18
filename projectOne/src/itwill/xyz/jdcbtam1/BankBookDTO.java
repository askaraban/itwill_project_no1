package itwill.xyz.jdcbtam1;

public class BankBookDTO {
	private String ID;
	private int InOutType;
	private long InputMoney;
	private long OutputMoney;
	private String Date;
	private String Memo;
	private long LastMoney;
	
	
	public BankBookDTO() {
		// TODO Auto-generated constructor stub2
	}


	public BankBookDTO(String iD, int inOutType, long inputMoney, long outputMoney, String date, String memo,
			long lastMoney) {
		super();
		ID = iD;
		InOutType = inOutType;
		InputMoney = inputMoney;
		OutputMoney = outputMoney;
		Date = date;
		Memo = memo;
		LastMoney = lastMoney;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public int getInOutType() {
		return InOutType;
	}


	public void setInOutType(int inOutType) {
		InOutType = inOutType;
	}


	public long getInputMoney() {
		return InputMoney;
	}


	public void setInputMoney(long inputMoney) {
		InputMoney = inputMoney;
	}


	public long getOutputMoney() {
		return OutputMoney;
	}


	public void setOutputMoney(long outputMoney) {
		OutputMoney = outputMoney;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getMemo() {
		return Memo;
	}


	public void setMemo(String memo) {
		Memo = memo;
	}


	public long getLastMoney() {
		return LastMoney;
	}


	public void setLastMoney(long lastMoney) {
		LastMoney = lastMoney;
	}


	
	
	
	
}
