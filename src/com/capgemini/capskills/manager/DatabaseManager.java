package com.capgemini.capskills.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.capskills.dao.SkillDAO;
import com.capgemini.capskills.dao.SkillTypeDAO;
//import com.capgemini.capskills.dao.ProjectDAO;
import com.capgemini.capskills.dao.UserDAO;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;

/**
 * Manage the database.
 *
 * Access to operation done on database (not about specific table).
 */
public class DatabaseManager {
	/** URL to create/drop database. */
	private static final String SGBD_URL = "jdbc:mysql://localhost:3306";
	/** Name of used database. */

	public static final String DATABASE_NAME = "capskills";

	/** Connection URL to database to use (need it's created). */
	private static final String DATABASE_URL = SGBD_URL + "/" + DATABASE_NAME;

	/** User use for the database connection (should be in separated file). */
	private static final String USER = "root";
	/**
	 * User password use for the database connection (should be in separated
	 * file).
	 */
	private static final String PASSWORD = "";

	/** The SQL request to drop the database. */
	private static final String SQL_DROP_DB = "DROP DATABASE IF EXISTS "
			+ DATABASE_NAME;
	/** The SQL request to create the database. */
	private static final String SQL_CREATE_DB = "CREATE DATABASE "
			+ DATABASE_NAME;

	public static final String[] CREATE_TABLE = {
			"CREATE TABLE " + DATABASE_NAME + ".", " (", ")ENGINE=innoDB" };

	/** The unique instance of class -- DP singleton. */
	private static volatile DatabaseManager instance;
	/** The connection instance keeps for program run. */
	private Connection connection;

	/**
	 * Private constructor -- DP singleton.
	 */
	private DatabaseManager() {
	}

	/**
	 * Destroy then rebuild database.
	 *
	 * @param
	 */
	public void prepareDb(boolean production) {
		if (!production) {
			try (Connection sgbd = this.createConnectionSGBD();
					PreparedStatement drop = sgbd.prepareStatement(SQL_DROP_DB);
					PreparedStatement create = sgbd
							.prepareStatement(SQL_CREATE_DB);
					PreparedStatement userTable =
							sgbd.prepareStatement((new UserDAO()).getCreateTable());
//					PreparedStatement projectTable =
//							sgbd.prepareStatement((new ProjectDAO()).getCreateTable());

					PreparedStatement skillTable = 
							sgbd.prepareStatement((new SkillDAO()).getCreateTable());

					PreparedStatement skillTypeTable = 
							sgbd.prepareStatement((new SkillTypeDAO()).getCreateTable());

			) {
				drop.executeUpdate();
				create.executeUpdate();
				userTable.executeUpdate();
				skillTable.executeUpdate();
				skillTypeTable.executeUpdate();

//				projectTable.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(42);
			}
		}

		this.connection = this.createConnectionDb();
	}

	/**
	 * The way to get the only one instance -- DP singleton.
	 *
	 * @return The only one instance.
	 */
	public static DatabaseManager getInstance() {
		if (DatabaseManager.instance == null) {
			DatabaseManager.instance = new DatabaseManager();
		}

		return DatabaseManager.instance;
	}

	public static Connection conn() throws DatabaseNotReadyException {
		return DatabaseManager.getInstance().getConnection();
	}

	public Connection getConnection() throws DatabaseNotReadyException {
		if (this.connection == null) {
			throw new DatabaseNotReadyException();
		}

		return this.connection;
	}

	/**
	 * Creates connection to SGBD without be connected to a database.
	 *
	 * @return
	 */
	private Connection createConnectionSGBD() {
		return this.createConnection(SGBD_URL);
	}

	/**
	 * Creates connection to the used database.
	 *
	 * @return
	 */
	private Connection createConnectionDb() {
		return this.createConnection(DATABASE_URL);
	}

	/**
	 * Creates the connection.
	 *
	 * Need initialization of database.
	 *
	 * @see DatabaseManager::prepareDb
	 * @return
	 */
	private Connection createConnection(String url) {
		Connection result = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			result = DriverManager.getConnection(url, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.exit(42);
		}

		return result;
	}
}
