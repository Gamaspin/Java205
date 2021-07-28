package guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageListView;
import guest.jdbc.ConnectionProvider;

public class MessageListService {
	
	// messageCountPerPage;	한 페이지당 표현할 메시지의 갯수 구하기
	private final int messageCountPerPage = 3;
	
	
	// 싱글톤 패턴 적용
	private MessageListService() {}
	private static MessageListService service = new MessageListService();
	public static MessageListService getInstance() {
		return service;
	}
	
	
	
	
	public MessageListView getMessageList(int pageNumber) {
		// 페이지 넘버를 받을거임
		
		MessageListView listView = null;
		
		Connection conn = null;
		MessageDao dao = null;
		
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			// 전체 게시물의 갯수
			int totalMessageCount = dao.selectAllCount(conn);
			System.out.println("totalCount : " + totalMessageCount);
			
			// 페이지에 표현할 메시지 객체들 List<Message>
			List<Message> messageList = null;
			
			// 데이터베이스 시작 행의 위치값 limit, index
			int firstRow = (pageNumber - 1) * messageCountPerPage;
			
			messageList = dao.selectMessageList(conn, firstRow, messageCountPerPage);
			System.out.println("message List : " + messageList);
		
			listView = new MessageListView(
					messageList, totalMessageCount, 
					pageNumber, messageCountPerPage, 
					firstRow, 0
					);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listView;
		
		
	}
	
	
}
