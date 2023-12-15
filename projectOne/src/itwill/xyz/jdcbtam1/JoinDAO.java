package itwill.xyz.jdcbtam1;

public interface JoinDAO {

	int insertClient(JoinDTO client);

	JoinDTO selectClientByNo(String id);
}
