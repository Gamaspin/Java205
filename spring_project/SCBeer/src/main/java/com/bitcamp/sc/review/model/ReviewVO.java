package com.bitcamp.sc.review.model;

import java.util.Date;

public class ReviewVO {
    private int ridx;			// 게시글 번호
    private String rtitle;		// 게시글 제목
    private String rtext;		// 게시글 내용
    private String rphoto;		// 게시글 사진
    private int rrate;			// 게시글 평점
    private Date rdate;			// 게시글 작성일자 util.Date
    private String rcategory;	// 리뷰 카테고리 (상품구매 or 투어)
    private int rlikes;			// 게시글 좋아요
    private String pidx;		// 게시글 작성자

    private int viewcnt;		// 게시글 조회수

    
    
//  // toString()
//  @Override
//  public String toString() {
//bno, title, content, writer,
//             regdate, viewcnt
//  }
    
    
	public int getRidx() {
		return ridx;
	}

	public void setRidx(int ridx) {
		this.ridx = ridx;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
	}

	public String getRphoto() {
		return rphoto;
	}

	public void setRphoto(String rphoto) {
		this.rphoto = rphoto;
	}

	public int getRrate() {
		return rrate;
	}

	public void setRrate(int rrate) {
		this.rrate = rrate;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getRcategory() {
		return rcategory;
	}

	public void setRcategory(String rcategory) {
		this.rcategory = rcategory;
	}

	public int getRlikes() {
		return rlikes;
	}

	public void setRlikes(int rlikes) {
		this.rlikes = rlikes;
	}

	public String getPidx() {
		return pidx;
	}

	public void setPidx(String pidx) {
		this.pidx = pidx;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	
	
	
	@Override
	public String toString() {
		return "ReviewVO [ridx=" + ridx + ", rtitle=" + rtitle + ", rtext=" + rtext + ", rphoto=" + rphoto + ", rrate="
				+ rrate + ", rdate=" + rdate + ", rcategory=" + rcategory + ", rlikes=" + rlikes + ", pidx=" + pidx
				+ ", viewcnt=" + viewcnt + "]";
	}
    
    

    
}