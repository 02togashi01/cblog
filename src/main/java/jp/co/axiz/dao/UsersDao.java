package jp.co.axiz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.entity.Header;
import jp.co.axiz.entity.Users;


@Repository
public class UsersDao  {

	@Autowired
	private JdbcTemplate jT;
	@Autowired
	private NamedParameterJdbcTemplate nPJT;


	@Transactional	//ユーザ情報を登録するメソッド(一般ユーザとして登録)
	public boolean register(String user_id,String password,String name) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("name",name).addValue("user_id", user_id).addValue("password",password);
		try {
			nPJT.update("INSERT INTO users (user_id,password,name,role) VALUES(:user_id,:password,:name,2)",param);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Transactional
	public Users findUser(String user_id,String password) {

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", user_id).addValue("pass",password);

		try {
			return nPJT.queryForObject(
					"SELECT user_id,password,name,role FROM users WHERE user_id = :id AND password = :pass",
					param,
					new BeanPropertyRowMapper<Users>(Users.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//deleteUserで使用
	@Transactional
	public List<Users> findAll () { // 一般ユーザを全件取得
		return jT.query("SELECT*FROM users WHERE role = 2",
				new BeanPropertyRowMapper<Users>(Users.class));
	}



	@Transactional
	public Users findUser(String id) {

		SqlParameterSource param =new MapSqlParameterSource().addValue("id",id);

		try {
			return nPJT.queryForObject(
					"SELECT* FROM users WHERE user_id = :id",
					param,
					new BeanPropertyRowMapper<Users>(Users.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Transactional
	public void delete(String id) {

		SqlParameterSource param =new MapSqlParameterSource().addValue("id",id);

		try {
			nPJT.update(
					"DELETE FROM users WHERE user_id = :id",
					param);
		}catch(EmptyResultDataAccessException e) {
		}
	}

	//へっだー見つけるメソッド
	@Transactional
	public List<Header> findHeader() {
		try {
			return jT.query(
					"SELECT* FROM header WHERE user_id ='master'",
					new BeanPropertyRowMapper<Header>(Header.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}


	//ヘッダー文字変更するメソッド
	@Transactional
	public void headerUpdate(String header,String subHeader) {
		SqlParameterSource param =new MapSqlParameterSource().addValue("header",header).addValue("sub", subHeader);
		try {
			nPJT.update(
					"UPDATE header SET header_text = :header,sub_header_text= :sub WHERE user_id = 'master'",
					param);
		}catch(EmptyResultDataAccessException e) {
		}
	}



}

