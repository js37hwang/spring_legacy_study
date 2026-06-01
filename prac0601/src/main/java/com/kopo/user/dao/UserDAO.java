package com.kopo.user.dao;

import java.util.List;

import com.kopo.user.vo.UserVO;

public interface UserDAO {
	public void insert(UserVO user); // create
	public List<UserVO> readAll(); // read- 전체 조회
	public void update(UserVO user); // update
	public void delete(String id); // del
	public UserVO read(String id); // read- 단건
}
