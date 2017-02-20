package com.scmaster.web5.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.web5.vo.Member;

@Repository // dao는 Repository 어노테이션, 없어도 상관없지만, 쓰자!!
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	//검색기능
	public Member searchId(String id) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		Member member = mapper.searchId(id);
		
		return member;
	}
	// 회원가입 기능
	public int insert(Member member) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		int result = 0;
		try {
			result = mapper.insert(member);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	// 로그인 기능
	public Member login(String id) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		Member member = mapper.login(id);
		return member;
	}
	
	public int update(Member member) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		int result = mapper.update(member);
		return result;
	}
	
	public int totalCount() {
		int result = 0;
		
		return result;
	}
}
