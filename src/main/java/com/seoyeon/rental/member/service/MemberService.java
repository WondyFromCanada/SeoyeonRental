package com.seoyeon.rental.member.service;

import java.util.Map;

public interface MemberService {

	int insertMember(Map<String, Object> map);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	 * @throws Exception 
	**/
	Map<String, Object> login(Map<String, Object> map) throws Exception;

}
