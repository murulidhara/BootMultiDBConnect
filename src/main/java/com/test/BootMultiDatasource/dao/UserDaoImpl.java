package com.test.BootMultiDatasource.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.BootMultiDatasource.model.User;

//@Transactional
@Repository
public class UserDaoImpl {

	@Autowired	
	@Qualifier("jdbcTemplate1")
	private NamedParameterJdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("jdbcTemplate2")
	private NamedParameterJdbcTemplate jdbcTemplate2;

	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));

			return user;
		}
	}

	public List<User> getAllUser() {
		String sql1 = "select username,email from user1";
		//get users list from db1
		//		SqlParameterSource parameter = new MapSqlParameterSource()
		//				.addValue("username", username);
		List<User> list1 = jdbcTemplate1.query(sql1, new UserRowMapper());

		String sql2 = "select username,email from user2";
		//get users list from db2
		List<User> list2 = jdbcTemplate2.query(sql2, new UserRowMapper());

		List<User> listAll = (List) Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		return listAll;
	}
}
