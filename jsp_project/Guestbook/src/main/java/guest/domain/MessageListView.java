package guest.domain;

import java.util.List;

public class MessageListView {
	
	private List<Message> messageList;	// 게시물 : Message 객체 3개 필요
	private int messageTotalCount;	// 전체 게시물의 갯수
	private int currentPageNumber;	// 현재 페이지 번호
	private int pageTotalCount;		// 페이지의 갯수
	private int messageCountPerPage;	// 한 페이지당 표현할 메시지의 갯수
	private int firstRow;			// DB 게시물의 시작 위치
	private int endRow;				// DB 게시물의 마지막 위치
	
	
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calPageTotalCount();
	}


	private void calPageTotalCount() {
		if(this.messageTotalCount == 0) {
			this.pageTotalCount = 0;
		} else {
			this.pageTotalCount = this.messageTotalCount / this.messageCountPerPage;
			if (this.messageTotalCount % this.messageCountPerPage > 0) {
				this.pageTotalCount++;
			}
		}
	}


	public List<Message> getMessageList() {
		return messageList;
	}
	public int getMessageTotalCount() {
		return messageTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public int getEndRow() {
		return endRow;
	}
	
	@Override
	public String toString() {
		return "MessageListView [messageList=" + messageList + ", messageTotalCount=" + messageTotalCount
				+ ", currentPageNumber=" + currentPageNumber + ", pageTotalCount=" + pageTotalCount
				+ ", messageCountPerPage=" + messageCountPerPage + ", firstRow=" + firstRow + ", endRow=" + endRow
				+ "]";
	}

}
