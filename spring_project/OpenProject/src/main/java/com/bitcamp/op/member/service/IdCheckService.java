package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.MybatisMemberDao;

@Service
public class IdCheckService {
	
//	@Autowired
//	MemberDao dao;
	
	
//	@Autowired
//	private JdbcTemplateMemberDao dao;

	@Autowired
	private MybatisMemberDao dao;
	
	
	
	public String idCheck(String id) {
		
		String result = "Y";
		//Connection conn = null;
		
		try {
			//conn = ConnectionProvider.getConnection();
			//if(dao.selectById(conn, id)>0) {
			if(dao.selectById(id)>0) {
				result="N";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}