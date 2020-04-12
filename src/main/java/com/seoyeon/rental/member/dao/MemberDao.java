package com.seoyeon.rental.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Map<String, Object> map);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	**/
	String selectEncPassword(SqlSessionTemplate sqlSession, String userId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	**/
	Map<String, Object> selectLoginUser(SqlSessionTemplate sqlSession, String userId);

}
