package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class WriteMessageService {
	
	// 싱글톤 패턴 사용
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}
	

	// 메시지를 DB에 쓰고 처리된 결과 생성. 실제 핵심 처리를 담당 (jsp는 전달만 해줌)
	public int writeMessage(MessageRequest requestMessage) {
		
		int resultCnt = 0;
		
		// 트랜잭션 처리를 위해서 생성
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance(); //new MessageDao();
			
			/* setAutoCommit의 기본값은 true -> 자동 커밋 
			 * 프로그래머가 Java JDBC에서 트랜잭션을 컨트롤하기위해 false로 해줌
			 * 		= 내가 커밋하려고	 */
			conn.setAutoCommit(false);
			
			
			// 데이터 전처리가 필요한 부분은 처리해줌 (사용자로부터 받은 메시지데이터임)
			Message message = requestMessage.toMessage();
			
			
			resultCnt = dao.writeMessage(conn, message);
			
			
			// 트랜잭션 완료
			conn.commit();
			
			
		} catch (SQLException e) {
			// 트랜잭션 rollback
			JdbcUtil.rollback(conn);
			
			
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	
	
	
}
