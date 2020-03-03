package com.seoyeon.rental.member.service.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seoyeon.rental.member.dao.MemberDao;
import com.seoyeon.rental.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao md;

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertMember(Map<String, Object> map) {
		return md.insertMember(sqlSession, map);
	}

}
