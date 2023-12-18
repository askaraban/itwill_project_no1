package itwill.xyz.jdcbtam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JoinDAOImpl extends ProjectDbcpFactory implements JoinDAO {

	private static JoinDAOImpl _dao;
	
	public JoinDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	static {
		_dao=new JoinDAOImpl();
	}
	
	public static JoinDAOImpl getDAO() {
		return _dao;
	}
	
	@Override
	public int insertClient(JoinDTO client) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;//SQL 명령의 실행결과를 저장하기 위한 변수 - 메소드의 반환값
		try {
			con=getConnection();
			
			String sql="insert into client values(?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, client.getID());
			pstmt.setString(2, client.getPw());
			pstmt.setString(3, client.getName());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertClient() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//아이디를 전달받아 Client 테이블에 저장된 고객정보를 검색하여 반환하는 메소드
	@Override
	public JoinDTO selectClientByNo(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		JoinDTO client=null;
		try {
			con=getConnection();
			
			String sql="select id,pw,name,cal from client where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
	
				client=new JoinDTO();
			
				client.setID(rs.getString("id"));
				client.setPw(rs.getString("pw"));
				client.setName(rs.getString("name"));
				client.setCal(rs.getString("cal"));
				
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudentByNo() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return client;
	}
	
	
	
	//내정보 계좌항목에 계좌번호 보이는 기능
		@Override
		public List<JoinDTO> InForMationClient(String id) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			List<JoinDTO> clientList = new ArrayList<>();
			
			try {
				con=getConnection();
				
				String sql="SELECT AC_NUM FROM ACCOUNT where ac_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
				JoinDTO client= new JoinDTO();

					client.setAc_num(rs.getString("ac_num"));
					
					clientList.add(client);
				}
				
			} catch (SQLException e) {
				System.out.println("[에러]InForMationClient() 메소드의 SQL 오류 = "+e.getMessage());
			} finally {
				close(con, pstmt, rs);
			}
			return clientList;
		}
	
}










