package model;

import java.util.ArrayList;
import java.sql.SQLException;

import db.DB;

public abstract class BaseCatalog {
	
	public abstract String getTableName() ;
	public abstract void setTableName(String tableName) ;
	protected Object[]  getAllResultSet() throws SQLException, ClassNotFoundException{
		DB db  = new DB();
		return new Object[]{db,db.simpleGetSelect("select * from "+db.getDataBaseName()+"."+this.getTableName())};
	}
	public abstract ArrayList<? extends BaseModel> getAll() throws SQLException,
	ClassNotFoundException;
}
