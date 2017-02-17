package com.scmaster.web5.dao;

import com.scmaster.web5.vo.Member;

public interface MemberMapper {
	public int insert(Member member);
	public Member searchId(String id);
	public Member login(String id);
	public int update(Member member);
}
