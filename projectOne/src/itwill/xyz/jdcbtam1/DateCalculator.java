package itwill.xyz.jdcbtam1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculator extends ProjectDbcpFactory{
	String calDate = null;
	Integer d1;
	Integer d2;
	Integer d3;
	Date firstDate = null;
	Date endDate = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	// 검색하고자 하는 전 날짜를 구하기 위한 메소드
	public String getFirstDate(String firstDate) {

		d1 = Integer.parseInt(firstDate.substring(0, 4));
		d2 = Integer.parseInt(firstDate.substring(4, 6));
		d3 = Integer.parseInt(firstDate.substring(6));
		
		Calendar cal = Calendar.getInstance();
		cal = Calendar.getInstance();
		cal.set(d1, d2+1, d3);
		calDate = dateFormat.format((cal.getTimeInMillis()));
		return calDate;
		
		
	}
	// 검색하고자 하는 뒷 날짜를 구하기 위한 메소드
	public String getEndDate(String endDate) {

		d1 = Integer.valueOf(endDate.substring(0,4));
		d2 = Integer.valueOf(endDate.substring(4,6));
		d3 = Integer.valueOf(endDate.substring(6));
			
		Calendar cal = Calendar.getInstance();
		cal.set(d1, d2 - 1, d3);
		calDate = dateFormat.format((cal.getTimeInMillis()));
		return calDate;
		
	}
	// 날짜를 검증하기 위한 메소드
	public boolean checkDate(String checkDate) {
		try {
			dateFormat.setLenient(false);
			dateFormat.parse(checkDate);
			return true;
		} catch (Exception e) {
			System.out.println("잘못된 날짜 입력!! - checkDate");
		}
		return false;

	}
	
	public String nowDate() {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String printDate = dateFormat.format(date);
		System.out.println(printDate);
		
		String[] dateList = printDate.split("-");
		return dateList[0]+dateList[1]+dateList[2];
		
		
	}
	public static void main(String[] args) {
		DateCalculator dc = new DateCalculator();
		
		System.out.println(dc.getFirstDate("20231216"));
	}

}