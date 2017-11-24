package com.capgemini.capskills.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;

import com.capgemini.capskills.dao.base.BaseDAO;
import com.capgemini.capskills.entities.SkillType;
import com.capgemini.capskills.entities.User;
import com.capgemini.capskills.manager.DatabaseManager;

public class SkillTypeDAO extends BaseDAO<SkillType> implements ISkillTypeDAO {

	public SkillTypeDAO() {
		this.tableName = "skill_type";
		this.questionMarks = "?,?";
	}

	@Override
	public SkillType select(SkillType item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateTable() {
		String result = DatabaseManager.CREATE_TABLE[0] + this.tableName + DatabaseManager.CREATE_TABLE[1]
				+ "skill_type_id				INT (11) AUTO_INCREMENT NOT NULL ," + "name  		VARCHAR (255),"
				+ "PRIMARY KEY (skill_type_id)" + DatabaseManager.CREATE_TABLE[2];
		return result;
	}

	@Override
	protected SkillType retrieveDatas(ResultSet rs) {
		SkillType result = new SkillType();

		try {
			result.setId(rs.getDouble(1));
			result.setName(rs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	
	
	public String updateString() {
		return   "name = ?";
				
			
			
	}
	
	
	
	@Override
	protected void setPreparedStatement(PreparedStatement st, SkillType item) {
		try {
			st.setObject(1, item.getId());
			st.setString(2, item.getName());

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	

	
	protected void setPreparedStatementUpdate(PreparedStatement st, SkillType item) {
		try {
			
			st.setString(1, item.getName());

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
}
