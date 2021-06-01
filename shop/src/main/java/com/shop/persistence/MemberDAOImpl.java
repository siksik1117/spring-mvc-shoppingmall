package com.shop.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shop.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespase = "com.shop.mappers.memberMapper";

	//회원가입	
	@Override
	public void signup(MemberVO vo) throws Exception {
		sql.insert(namespase + ".signup", vo);
		
	}

	//로그인
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespase + ".signin", vo);
	}

}
