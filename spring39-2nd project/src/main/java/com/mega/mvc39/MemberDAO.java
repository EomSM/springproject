package com.mega.mvc39;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class MemberDAO {

	@Autowired
	SqlSessionTemplate my;

	public void create(MemberVO memberVO) throws Exception { 
		my.insert("member2.insert", memberVO);
	}	//회원 가입. 
	
	public void delete(MemberVO memberVO) throws Exception {
		System.out.println("dao test===========" + memberVO);
		my.delete("member2.delete", memberVO);
	}

	public MemberVO login(MemberVO memberVO) {
		return my.selectOne("member2.login", memberVO);
	}

	public void logout(HttpServletResponse response) {
		my.selectOne("member2.logout", response);
	}

	//입력값: 개인id, 처리: 개인id에 해당하는 row를 가지고 온다., 반환값: row를 넣은 vo
	public MemberVO select(MemberVO memberVO) {
		MemberVO vo = my.selectOne("member2.select", memberVO);
		return vo;
	}

	public void update(MemberVO memberVO) throws Exception {
		my.update("member2.update", memberVO);
	}

}