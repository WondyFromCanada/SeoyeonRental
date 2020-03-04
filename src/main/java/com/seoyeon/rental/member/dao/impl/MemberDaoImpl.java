package com.seoyeon.rental.member.dao.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.member.dao.MemberDao;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Map<String, Object> map) {
		return sqlSession.insert("insertMember", map);
	}

	@Override
	public String selectEncPassword(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("selectPwd", userId);
	}

	@Override
	public Map<String, Object> selectLoginUser(SqlSessionTemplate sqlSession, String userId) {
		return sqlSession.selectOne("selectLoginUser", userId);
	}

	
	
}
