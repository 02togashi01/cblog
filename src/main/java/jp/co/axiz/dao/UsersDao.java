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
    public Users findUser(String id,String pass) {

            SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("pass",pass);

            try {
                return nPJT.queryForObject(
                        "SELECT id,pass,name,role FROM users WHERE id = :id AND pass = :pass",
                        param,
                        new BeanPropertyRowMapper<Users>(Users.class));
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
    }

//deleteUserで使用
	@Transactional
    public List<Users> findAll () {		//一般ユーザを全件取得
		return jT.query("SELECT*FROM users WHERE role = 2",
				new BeanPropertyRowMapper<Users>(Users.class));
	}


	@Transactional
	public void update(String id,String pass,String name,String oldId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("pass",pass).addValue("name", name).addValue("old", oldId);
		try {
			nPJT.update(
					"UPDATE users SET id= :id ,pass= :pass,name= :name WHERE id=:old", param);
		}catch(Exception e) {

		}
	}


	@Transactional
	public void delete(String id) {

		SqlParameterSource param =new MapSqlParameterSource().addValue("id",id);

		try {
			nPJT.update(
					"DELETE FROM users WHERE id = :id",
					param);
		}catch(EmptyResultDataAccessException e) {
		}
	}


//	public List<UserInfo> search (String id, String name, String tel) {
//		String SQL_SELECT_INFO = "SELECT user_id, user_name, telephone FROM user_info";
//
//		boolean flg = (!(id.equals("")) || !(name.equals("")) || !(tel.equals("")));
//		boolean exId = !(id.equals(""));
//		boolean exName = !(name.equals(""));
//		boolean exTel = !(tel.equals(""));
//
//		if (flg) {
//			SQL_SELECT_INFO += " WHERE";
//
//			if (!(id.equals(""))) {
//				SQL_SELECT_INFO += " user_id = ?";
//			} else {
//				SQL_SELECT_INFO += "'1' = ?";
//			}
//			if (!(name.equals(""))) {
//				SQL_SELECT_INFO += " AND user_name = ?";
//			} else {
//				SQL_SELECT_INFO += " AND user_name LIKE ?";
//			}
//			if (!(tel.equals(""))) {
//				SQL_SELECT_INFO += " AND telephone = ?";
//			} else {
//				SQL_SELECT_INFO += " AND telephone LIKE ?";		//入力ないときはLIKE％％で全検索状況になるように調整
//			}
//		}
//
//		SQL_SELECT_INFO += " ORDER BY user_id";
//
//			if (flg) {
//
//				if (exId && exName && exTel) {
//					//id○name○tel○
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), Integer.parseInt(id), name, tel);
//
//				} else if (!exId && exName && exTel) {
//					//id×name○tel○
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), 1, name, tel);
//
//				} else if (exId && !exName && exTel) {
//					//id○name×tel○
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), Integer.parseInt(id), "%%", tel);
//
//				} else if (exId && exName && !exTel) {
//					//id○name○tel×
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), Integer.parseInt(id), name, "%%");
//
//				} else if (exId && !exName && !exTel) {
//					//id○name×tel×
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), Integer.parseInt(id), "%%", "%%");
//
//				} else if (!exId && exName && !exTel) {
//					//id×name○tel×
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), 1, name, "%%");
//
//				} else if (!exId && !exName && exTel) {
//					//id×name×tel○
//					return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), 1, "%%", tel);
//
//				}
//			} else {
//				//検索条件がない場合
//				return jT.query(SQL_SELECT_INFO, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
//			}
//		return null;
//	}

	//最新IDの取得

//	public Integer latestId () {
//		return jT.queryForObject(SQL_SEARCH_ID, Integer.class);
//	}
//
	//IDを元に検索
//	public UserInfo findById (int id) {
//		return (UserInfo) jT.query(SQL_SEARCH_WHERE_ID, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
//	}
//
//
//	@Transactional
//	public List<UserInfo> findMax() {
//		SqlParameterSource param = new MapSqlParameterSource();
//		try {
//			return  nPJT.query("SELECT * FROM user_info WHERE user_id = (SELECT MAX(user_id) AS max FROM user_info)",param,new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
//		}catch(EmptyResultDataAccessException e) {
//		}
//		return null;
//	}
//
//	@Transactional
//    public int updateName(UserInfo user){
//
//    	Integer id = user.getUserId();
//    	String name = user.getUserName();
//
//    	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("name", name);
//
//    	return nPJT.update("UPDATE user_info SET user_name = :name WHERE user_id= :id", param);
//
//    }
//	@Transactional
//	public int updateTel(UserInfo user) {
//
//		Integer id = user.getUserId();
//    	String tel = user.getTelephone();
//
//    	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("tel", tel);
//
//    	return nPJT.update("UPDATE user_info SET telephone = :tel WHERE user_id= :id", param);
//
//	}
//	@Transactional
//	public int updatePass(UserInfo user) {
//
//		Integer id = user.getUserId();
//    	String pass = user.getPassword();
//
//    	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("pass", pass);
//
//    	return nPJT.update("UPDATE user_info SET password = :pass WHERE user_id= :id", param);
//
//	}
//

}
