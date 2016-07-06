package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import db.DB;

public abstract class BaseModel {
	protected long id;

	public abstract void save() throws SQLException, ClassNotFoundException;

	public abstract void update() throws SQLException, ClassNotFoundException;

	public void delete() throws SQLException, ClassNotFoundException {
		DB db = new DB();
		PreparedStatement ps =  db.simpleGetPreparedStatement(
				 "delete from " + db.getDataBaseName() + "." + this.getCatalog().getTableName()+" where id= ? ;" );
		
		ps.setLong(1, this.getId());
		db.simpleExecutePreparedStatement(ps);
		
	}


	public abstract BaseCatalog getCatalog() ;
	public abstract void setCatalog(BaseCatalog catalog);
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
