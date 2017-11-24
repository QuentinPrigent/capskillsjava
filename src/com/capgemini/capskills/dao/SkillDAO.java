package com.capgemini.capskills.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.capskills.dao.base.BaseDAO;
import com.capgemini.capskills.entities.Skill;
import com.capgemini.capskills.entities.base.BaseEntity;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;

public class SkillDAO extends BaseDAO<Skill> implements ISkillDAO {

	@Override
	public Skill select(Skill item) {

		return null;
	}
	
	/**
        skill_id            int (11) Auto_increment  NOT NULL ,
        skill_name     		Varchar (255) ,
        PRIMARY KEY (skill_id ) ,

	 */
	
	@Override
	public String getCreateTable() {
		String result = DatabaseManager.CREATE_TABLE[0] + this.tableName
				+ DatabaseManager.CREATE_TABLE[1]
				+ "skill_id			INT (11) PRIMARY KEY AUTO_INCREMENT NOT NULL ,"
				+ "skill_name  		VARCHAR (255),"
				+ "skill_type_id	INT"
				+ DatabaseManager.CREATE_TABLE[2];
		return result;
	}

	//CREATE TABLE Skill
	//skill_id int(11) AUTO_INCREMENT NOT NULL,
	//skill_name VARCHAR (255),


	@Override
	protected void setPreparedStatement(PreparedStatement st, Skill item) {
		try {
			st.setString(1, null);
			st.setString(2, item.getName());
			st.setString(3, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Skill retrieveDatas(ResultSet rs) {
		Skill result = new Skill();

		try {
			result.setId(rs.getDouble(1));
			result.setName(rs.getString(2));

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

	public SkillDAO() {
		this.tableName = "skill";
		this.questionMarks = "?,?,?";
		this.id = "skill_id";
	}


	@Override
	protected String updateString() {
		return "skill_name = ?,"
				+ "skill_type_id = ?";
	}

	@Override
	protected void setPreparedStatementUpdate(PreparedStatement st, Skill item) {
		try {
			st.setString(1, item.getName());
			st.setString(2, null);

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

}
