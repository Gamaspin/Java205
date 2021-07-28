package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.exception.InvalidPasswordException;
import guest.exception.MessageNotFoundException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class DeleteMessageService {

	// 싱글톤 패턴 적용
	private DeleteMessageService() {}
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	public int deleteMessage(int mid, String pw) /*throws Exception*/
			throws SQLException, MessageNotFoundException, InvalidPasswordException {
		
		int resultCnt = 0;
		
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			
			// 사용자로부터 전달받은 mid로 게시물을 검색
			Message message = dao.selectByMid(conn, mid);
			
			if(message == null) {
				/* throw new Exception("게시물이 존재하지 않습니다."); */
				throw new MessageNotFoundException(mid);
			} else {
				if(message.getPassword().equals(pw)) {
					// 사용자가 작성한pw와 동일한것이 참이면 삭제 진행
					resultCnt = dao.deleteMessage(conn, mid);
					
					// dao가 들어왔다면 문제가 없는것이기 때문에 커밋 진행, 트랜잭션 성공
					conn.commit();
				} else {
					// 예외처리 해줘야함 (guest.exception 패키지에서 가져와서 예외 발생시킴)
					throw new InvalidPasswordException();
				}
			}
			
			
		//throws SQLException, MessageNotFoundException, InvalidPasswordException
		// catch 블럭 하나로 묶어도 되지만, 오류 유형별로 알고싶어서 일부러 나누었음
		} catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;	// <- 다시 던지는 이유 : jsp 쪽에서 오류를 알고싶어서
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
			
		} finally {
			JdbcUtil.close(conn);
		}
		return resultCnt;
	}
}
