package com.seoyeon.rental.member.service.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoyeon.rental.member.dao.MemberDao;
import com.seoyeon.rental.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao md;

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public int insertMember(Map<String, Object> map) {
		return md.insertMember(sqlSession, map);
	}

	@Transactional
	@Override
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		String userId = map.get("userId") + "";
		//userId를 가지고 암호화된 비밀번호 조회
		String encPassword = md.selectEncPassword(sqlSession, userId);
		
		//입력한 암호와 디비에 있는 암호가 일치하는지 체크
		if(!passwordEncoder.matches(map.get("userPwd") + "", encPassword)) {
			throw new Exception();
		} else {
			//암호가 일치하면 해당 유저정보 가져옴
			
			Map<String, Object> loginUserInf = md.selectLoginUser(sqlSession, userId);
			
			//AfterAdvice에서 로그인 정보를 확인하기 위한 loginFlag
			loginUserInf.put("loginFlag", "true");
			return loginUserInf;
		}
	}

}
