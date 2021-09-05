package com.bitcamp.sc.review.dao;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitcamp.sc.review.model.ReviewVO;
 
 
@Repository    // 현재 클래스를 dao bean으로 등록
public class ReviewDaoImpl implements ReviewDao {
    @Inject
    SqlSession SqlSession;
    // 01. 게시글 작성
    @Override
    public void create(ReviewVO vo) throws Exception {
        SqlSession.insert("review.insert", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public ReviewVO read(int ridx) throws Exception {
        return SqlSession.selectOne("review.view", ridx);
    }
    // 03. 게시글 수정
    @Override
    public void update(ReviewVO vo) throws Exception {
        SqlSession.update("review.updateArticle", vo);
 
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int ridx) throws Exception {
        SqlSession.delete("review.deleteArticle",ridx);
 
    }
    // 05. 게시글 전체 목록
    @Override
    public List<ReviewVO> listAll() throws Exception {
        return SqlSession.selectList("review.listAll");
    }
    // 게시글 조회수 증가
    @Override
    public void increaseViewcnt(int bno) throws Exception {
        SqlSession.update("review.increaseViewcnt", bno);
    }
 
}
