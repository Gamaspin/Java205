package com.bitcamp.sc.review.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Service;
 
import com.bitcamp.sc.review.dao.ReviewDao;
import com.bitcamp.sc.review.model.ReviewVO;
 
@Service
public class ReviewServiceImpl implements ReviewService {
    
    @Inject
    ReviewDao reviewDao;
    
    // 01. 게시글쓰기
    @Override
    public void create(com.bitcamp.sc.review.model.ReviewVO vo) throws Exception {
        String rtitle = vo.getRtitle();
        String rtext = vo.getRtext();
        String pidx = vo.getPidx();
        // *태그문자 처리 (< ==> &lt; > ==> &gt;)
        // replace(A, B) A를 B로 변경
        rtitle = rtitle.replace("<", "&lt;");
        rtitle = rtitle.replace("<", "&gt;");
        pidx = pidx.replace("<", "&lt;");
        pidx = pidx.replace("<", "&gt;");
        // *공백문자 처리
        rtitle = rtitle.replace("  ",    "&nbsp;&nbsp;");
        pidx = pidx.replace("  ",    "&nbsp;&nbsp;");
        // *줄바꿈 문자처리
        rtext = rtext.replace("\n", "<br>");
        vo.setRtitle(rtitle);
        vo.setRtext(rtext);
        vo.setPidx(pidx); 
        reviewDao.create(vo);
    }
    // 02. 게시글 상세보기
    @Override
    public ReviewVO read(int ridx) throws Exception {
        return reviewDao.read(ridx);
    }
    // 03. 게시글 수정
    @Override
    public void update(ReviewVO vo) throws Exception {
    	reviewDao.update(vo);
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int ridx) throws Exception {
    	reviewDao.delete(ridx);
    }
    // 05. 게시글 전체 목록
    @Override
    public List<ReviewVO> listAll() throws Exception {
        return reviewDao.listAll();
    }
    
    // 06. 게시글 조회수 증가
    @Override
    public void increaseViewcnt(int ridx, HttpSession session) throws Exception {
        long update_time = 0;
        // 세션에 저장된 조회시간 검색
        // 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행X
        if(session.getAttribute("update_time_"+ridx) != null){
                                // 세션에서 읽어오기
            update_time = (long)session.getAttribute("update_time_"+ridx);
        }
        // 시스템의 현재시간을 current_time에 저장
        long current_time = System.currentTimeMillis();
        // 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간)
        // 시스템현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
        if(current_time - update_time > 5*1000){
        	reviewDao.increaseViewcnt(ridx);
            // 세션에 시간을 저장 : "update_time_"+bno는 다른변수와 중복되지 않게 명명한 것
            session.setAttribute("update_time_"+ridx, current_time);
            
        }
    }
 
}
