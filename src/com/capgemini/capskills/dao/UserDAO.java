package com.capgemini.capskills.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.capgemini.capskills.dao.base.BaseDAO;
import com.capgemini.capskills.entities.User;
import com.capgemini.capskills.entities.base.BaseEntity;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;

public class UserDAO extends BaseDAO<User> implements IUserDAO {

	@Override
	public User select(User item) {
		
		return null;
	}

	@Override
	public String getCreateTable() {
		String result = DatabaseManager.CREATE_TABLE[0] + this.tableName
				+ DatabaseManager.CREATE_TABLE[1]
				+ "user_id				INT (11) AUTO_INCREMENT NOT NULL ,"
				+ "user_firstname  		VARCHAR (255)," 
				+ "user_lastname 		VARCHAR (255),"
				+ "email     			VARCHAR (255)," 
				+ "user_password  		VARCHAR	(100),"
				+ "user_id_1		   	INT," 
				+ "PRIMARY KEY (user_id)"
				+ DatabaseManager.CREATE_TABLE[2];
		return result;
	}

	@Override
	protected void setPreparedStatement(PreparedStatement st, User item) {
//		short i = 1;
		try {
//			if (item.getId() != null)  {
			st.setString(1, null);
//			}
			st.setString(2, item.getFirstname());
			st.setString(3, item.getLastname());
			st.setString(4, item.getEmail());
			st.setString(5, item.getPassword());
			st.setString(6, null);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected User retrieveDatas(ResultSet rs) {

		User result = new User();

		try {
			result.setId(rs.getDouble(1));
			result.setFirstname(rs.getString(2));
			result.setLastname(rs.getString(3));
			result.setEmail(rs.getString(4));
			result.setPassword(rs.getString(5));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Add the name of the related class
	 * Add the number of attributes needed for the table
	 * int the database
	 */
	
	public UserDAO() {
		this.tableName = "user";
		this.questionMarks = "?,?,?,?,?,?";
		this.id = "user_id";
	}

	
	protected String updateString() {
		return "user_firstname = ?,"
				+ "user_lastname = ?,"
				+ "email = ?,"
				+ "user_password = ?,"
				+ "user_id_1 = ?";
	}


	@Override
	protected void setPreparedStatementUpdate(PreparedStatement st, User item) {

		try {
			st.setString(1, item.getFirstname());
			st.setString(2, item.getLastname());
			st.setString(3, item.getEmail());
			st.setString(4, item.getPassword());
			st.setString(5, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
