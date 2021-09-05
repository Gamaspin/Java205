package com.bitcamp.sc.review.dao;

import java.util.List;

import com.bitcamp.sc.review.model.ReviewVO;

public interface ReviewDao {
	// 01. 게시글 작성
    public void create(ReviewVO vo) throws Exception;
    // 02. 게시글 상세보기
    public ReviewVO read(int ridx) throws Exception;
    // 03. 게시글 수정
    public void update(ReviewVO vo) throws Exception;
    // 04. 게시글 삭제
    public void delete(int ridx) throws Exception;
    // 05. 게시글 전체 목록
    public List<ReviewVO> listAll() throws Exception;
    // 06. 게시글 조회 증가
    public void increaseViewcnt(int ridx) throws Exception;
}
