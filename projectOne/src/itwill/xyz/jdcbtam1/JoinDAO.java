package itwill.xyz.jdcbtam1;

import java.util.List;

public interface JoinDAO {

	int insertClient(JoinDTO client);

	JoinDTO selectClientByNo(String id);
	
	List<JoinDTO> InForMationClient(String id);
	
	JoinDTO selectClientAccountNo(String accoutSelectNumber);
	
	JoinDTO FristInForMationClient(String id);

	// 2
}
