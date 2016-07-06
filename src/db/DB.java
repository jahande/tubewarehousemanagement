package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author rj
 *
 * caution that can't be singleton cause of concurrency
 */
public class DB {
	//private static DB instance = new DB();

	private String dataBaseName = "tube";
	private Connection connect = null;

//	private DB() {
//
//	}

//	public static DB getInstance() {
//		return DB.instance;
//	}

	public void initial() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost/"+this.getDataBaseName();
		this.setConnect(DriverManager.getConnection(url, "root", ""));

	}

	public void close() {
		try {

			if (this.getConnect() != null) {
				this.getConnect().close();
			}
		} catch (Exception e) {

		}

	}

	public ResultSet getSelect(String query) throws SQLException {
		return connect.createStatement().executeQuery(query);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		this.close();
	}
	public void doCUD(String query) throws SQLException {
		this.getConnect().prepareStatement(query).executeUpdate();
	}

	/**
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 *  must close after finish use of it
	 */
	public ResultSet simpleGetSelect(String query) throws SQLException,
			ClassNotFoundException {
		this.initial();
		ResultSet res = this.getSelect(query);
		//this.close();
		return res;
	}

	public void simpleDoCUD(String query) throws ClassNotFoundException,
			SQLException {
		this.initial();
		this.doCUD(query);
		this.close();
	}

	protected Connection getConnect() {
		return connect;
	}

	protected void setConnect(Connection connect) {
		this.connect = connect;
	}

	public PreparedStatement getPreparedStatement(String query)
			throws SQLException {
		return this.getConnect().prepareStatement(query);
	}

	public PreparedStatement simpleGetPreparedStatement(String query)
			throws SQLException, ClassNotFoundException {

		this.initial();
		return this.getPreparedStatement(query);
	}
	public void  executePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.executeUpdate();
	}
	public void  simpleExecutePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.executeUpdate();
		this.close();
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
}
