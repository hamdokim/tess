package com.cos.blogapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blogapp.web.dto.JoinReqDto;

//save() 인서트, 업데이트
//findbyId(1) 한건 셀렉트
//findAll() 전체 셀렉트
//deleteByld(1)한건삭제
//DAO
//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "insert into user (username, password, email) values (:username, :password, :email)", nativeQuery = true)
	void join(String username, String password, String email);

	void save(JoinReqDto dto);
	
	@Query(value = "select * from user where username = :username and password = :password",  nativeQuery = true)
	User mLogin(String username, String password);
	
	
	
}
