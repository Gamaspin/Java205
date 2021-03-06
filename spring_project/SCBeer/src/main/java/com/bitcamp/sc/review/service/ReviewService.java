package com.bitcamp.sc.review.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bitcamp.sc.review.model.ReviewVO;

public interface ReviewService {

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
    // 06. 게시글 조회
    public void increaseViewcnt(int ridx, HttpSession session) throws Exception;
}

