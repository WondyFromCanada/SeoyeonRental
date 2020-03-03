package com.seoyeon.rental.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Map<String, Object> map);

}
