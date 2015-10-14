package kom.slavko.tutorials.spring.springMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;

	public UsersDao() {

	}

	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean create(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				user);

		jdbc.update(
				"insert into users(username,password,email,enabled) values (:username,:password,:email,:enabled)",
				params);
		return jdbc
				.update("insert into authorities(username,authority) values (:username,:authority)",
						params) == 1;
	}

	public boolean exists(String username) {
		return (jdbc.queryForObject(
				"select count(*) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0);

	}

}
