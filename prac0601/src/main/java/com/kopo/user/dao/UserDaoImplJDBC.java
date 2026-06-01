package com.kopo.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kopo.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplJDBC implements UserDAO {

	// DB 작업을 쉽게 도와주는 객체 (JDBC 추상화)
	private JdbcTemplate jdbcTemplate;

	// DataSource(DB 연결 정보)를 주입받아서 JdbcTemplate 생성
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// DB 조회 결과(ResultSet)를 UserVO 객체로 변환하는 클래스 spring
	class UserMapper implements RowMapper<UserVO> {

		// 한 행(row)을 UserVO 객체로 매핑
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {

			// 빈 UserVO 객체 생성
			UserVO user = new UserVO();

			// DB 컬럼 값을 꺼내서 객체에 세팅
			user.setUserId(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));

			// 완성된 객체 반환
			return user;
		}
	}

	@Override
	public void insert(UserVO user) {
		String sql = "insert into users (userid, name, gender, city) values (?,?,?,?)";

		jdbcTemplate.update(sql, 
				user.getUserId(), 
				user.getName(), 
				user.getGender(), 
				user.getCity()
			);
		
		System.out.println("Userid = "+user.getUserId()+" userName = " + user.getName());

	}

	@Override
	public UserVO read(String id) {
		String sql = "select * from users where 1=1 and userid = ?";
		
		UserVO user =  jdbcTemplate.queryForObject(sql,(rs, rowNum)-> {
			UserVO vo = new UserVO();
			
	        vo.setUserId(rs.getString("userid"));
	        vo.setName(rs.getString("name"));
	        vo.setCity(rs.getString("city"));
	        vo.setGender(rs.getString("gender"));
	        return vo;
	        
		}, id);
		
		return user;
	}

	@Override
	public List<UserVO> readAll() {
		return null;
	}

	@Override
	public void update(UserVO user) {
	}

	@Override
	public void delete(String id) {
	}
}