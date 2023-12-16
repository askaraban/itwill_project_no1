package itwill.xyz.jdcbtam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO extends ProjectDbcpFactory {
	private static ResultDAO _dao;

	public ResultDAO() {
	}

	static {
		_dao = new ResultDAO();

	}

	public static ResultDAO getDao() {
		return _dao;
	}

	// 이전날짜와 이후 날짜를 사이의 모든 검색결과를 호출
	public List<JoinDTO> bothSearch(String firstDate, String endDate, String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		try {
			con = getConnection();

			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on id=cid "
					+ " where id=? and iocash.iocal between ? and ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, firstDate);
			pstmt.setString(3, endDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]bothSearch() 메소드의 SQL 오류 = " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

	public List<JoinDTO> oneSearch(String cid,String endDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		// 지금보니깐 아이디가 누구껀지 내가 지정을 안했네 그래서 오류나는거 같은데

		try {
			con = getConnection();
			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on id=cid"
					+ " where cid=? and iocal<=? order by iocal desc";
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]oneSearch() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

	// 아무것도 입력하지 않을 상태로 조회 했을 경우 모든 날짜의 날짜,입/출금, 입/출금액, 잔액, 메모를 출력하도록
	public List<JoinDTO> nowSearch(String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		// 지금보니깐 아이디가 누구껀지 내가 지정을 안했네 그래서 오류나는거 같은데

		try {
			con = getConnection();
			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on cid=id where cid=?"
					+ " order by iocal desc";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]nowSearch() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}
	
//	**************************************입금  입금*************************************************************************
	public List<JoinDTO> depositSearch(String firstDate, String endDate, String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		try {
			con = getConnection();

			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on id=cid "
					+ " where id=? and iotype='입금' and iocash.iocal between ? and ?";
			

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, firstDate);
			pstmt.setString(3, endDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]depositSearch() 메소드의 SQL 오류 = " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

	public List<JoinDTO> depositOneSearch(String endDate, String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;
		
		// 지금보니깐 아이디가 누구껀지 내가 지정을 안했네 그래서 오류나는거 같은데

		try {
			con = getConnection();
			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on id=cid"
					+ " where cid=? and iotype='입금' and iocal<=to_date(?,'YY-MM-DD') order by iocal desc";
			
			
			
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]depositOneSearch() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

	// 아무것도 입력하지 않을 상태로 조회 했을 경우 모든 날짜의 날짜,입금, 입금액, 잔액, 메모를 출력하도록
	public List<JoinDTO> depositNowSearch(String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		// 지금보니깐 아이디가 누구껀지 내가 지정을 안했네 그래서 오류나는거 같은데

		try {
			con = getConnection();
			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on cid=id"
					+ " where id=? and iotype='입금' order by iocal desc";
			
			
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]depositNowSearch() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}
	
//	**************************************출금  출금*************************************************************************
	public List<JoinDTO> withSearch(String firstDate, String endDate, String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		try {
			con = getConnection();

			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on id=cid "
					+ " where id=? and iotype='출금' and iocash.iocal between ? and ?";


			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, firstDate);
			pstmt.setString(3, endDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]withSearch() 메소드의 SQL 오류 = " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

	public List<JoinDTO> withOneSearch(String endDate, String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		// 지금보니깐 아이디가 누구껀지 내가 지정을 안했네 그래서 오류나는거 같은데

		try {
			con = getConnection();
			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on cid=id"
					+ " where cid=? and iocal<=? and iotype='출금' order by iocal desc";
			 
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]withOneSearch() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

	// 아무것도 입력하지 않을 상태로 조회 했을 경우 모든 날짜의 날짜,입/출금, 입/출금액, 잔액, 메모를 출력하도록
	public List<JoinDTO> withNowSearch(String cid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> resultList = new ArrayList<JoinDTO>();
		JoinDTO client = null;

		// 지금보니깐 아이디가 누구껀지 내가 지정을 안했네 그래서 오류나는거 같은데

		try {
			con = getConnection();
			String sql = "select iocal,cid,withdraw,deposit,memo, hbalance,iotype from iocash join client on cid=id"
					+ " where id=? and iotype='출금' order by iocal desc";
	
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				client = new JoinDTO();
				client.setIocal(rs.getTimestamp("iocal"));
				client.setCid(rs.getString("cid"));
				client.setWithdraw(rs.getInt("withdraw"));
				client.setDeposit(rs.getInt("deposit"));
				client.setMemo(rs.getString("memo"));
				client.setHbalance(rs.getInt("hbalance"));
				client.setIotype(rs.getString("iotype"));
				// 정보결과 리스트에 클라이언트 정보 추가
				resultList.add(client);
			}

		} catch (SQLException e) {
			System.out.println("[에러]withNowSearch() 메소드의 SQL 오류 = " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return resultList;

	}

}
