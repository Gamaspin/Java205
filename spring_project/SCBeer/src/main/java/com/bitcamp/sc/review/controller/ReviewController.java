package com.bitcamp.sc.review.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.sc.review.model.ReviewVO;
import com.bitcamp.sc.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	
	 // 의존관계 주입 => BoardServiceImpl 생성
    // IoC 의존관계 역전
    @Inject
    ReviewService reviewService;

    
	// 01. 게시글 목록
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception{
		List<ReviewVO> list = reviewService.listAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/list"); // 뷰를 list.jsp로 설정
		mav.addObject("list", list); // 데이터를 저장
		return mav; // list.jsp로 List가 전달된다.
	}
    
    // 02_01. 게시글 작성화면
    // @RequestMapping("board/write.do")
    // value="", method="전송방식"
    @RequestMapping(value="write.do", method=RequestMethod.GET)
    public String write(){
        return "review/write"; // write.jsp로 이동
    }
    
    // 02_02. 게시글 작성처리
    @RequestMapping(value="insert.do", method=RequestMethod.POST)
    public String insert(@ModelAttribute ReviewVO vo) throws Exception{
    	reviewService.create(vo);
        return "redirect:list.do";
    }
    
    // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    @RequestMapping(value="view.do", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int ridx, HttpSession session) throws Exception{
        // 조회수 증가 처리
    	reviewService.increaseViewcnt(ridx, session);
        // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
        ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("review/view");
        // 뷰에 전달할 데이터
        mav.addObject("dto", reviewService.read(ridx));
        return mav;
    }
    
    // 04. 게시글 수정
    // 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute ReviewVO vo) throws Exception{
    	reviewService.update(vo);
        return "redirect:list.do";
    }
    
    // 05. 게시글 삭제
    @RequestMapping("delete.do")
    public String delete(@RequestParam int ridx) throws Exception{
    	reviewService.delete(ridx);
        return "redirect:list.do";
    }
    
}

