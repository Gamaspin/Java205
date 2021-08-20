package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchIdPw;


@Repository
public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private final String NAME_SPACE = "com.bitcamp.op.member.dao.memberMapper";
	

	public int insertMember(Member member) throws SQLException {
	
	return template.update
			(NAME_SPACE + ".insertMember"
			, member);
	}
	
	
//	public int insertMember1(final Member member) throws SQLException {
//		int resultCnt = 0;
//		return resultCnt;
//	}
//	public List<Member> selectList(Connection conn) {
//		List<Member> list = null;
//		return list;
//	}
	
	
	
	public Member selectByIdPw(String id, String pw) {
		return template.selectOne
				(NAME_SPACE + ".selectByIdPw"
				, new SearchIdPw(id, pw));
	}
	
	

	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		return template.selectOne
				(NAME_SPACE+".selectById"
				, memberId);
	}


}