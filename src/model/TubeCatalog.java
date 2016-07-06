package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;

public class TubeCatalog extends BaseCatalog {

	private static TubeCatalog instance = new TubeCatalog();
	public static TubeCatalog getInstance() {
		return TubeCatalog.instance;
	}
	private TubeCatalog(){
		
	}
	private String tableName="tube";
	public ArrayList<Tube> getAll() throws SQLException, ClassNotFoundException {
		Object[] objs = this.getAllResultSet();
		ResultSet resultSet = (ResultSet)objs[1];
		ArrayList<Tube> tubes = new ArrayList<Tube>();
		while (resultSet.next()) {
			Tube t  = new Tube();
			t.setId(resultSet.getLong("id"));
			t.setBrand(resultSet.getString("brand"));
			t.setCountry(resultSet.getString("country"));
			t.setGol(resultSet.getString("gol"));
			t.setSize(resultSet.getString("size"));
			
			tubes.add(t);
			
		}
		((DB)(objs[0])).close();
		return tubes;
	}
	@Override
	public String getTableName() {
		return tableName;
	}
	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public ArrayList<String> getDistinctBySize() throws SQLException, ClassNotFoundException {
		DB d = new DB();
		ResultSet rs =  d.simpleGetSelect("SELECT DISTINCT size FROM "+d.getDataBaseName()+"."+this.getTableName());
		ArrayList<String> sizes = new ArrayList<String>();
		while (rs.next()) {
			sizes.add(rs.getString("size"));
		}
		d.close();
		return sizes;
	}
	public ArrayList<Tube> filterBySize(String size) throws SQLException, ClassNotFoundException {
		DB d = new DB();
		ResultSet resultSet =  d.simpleGetSelect("SELECT * FROM "+d.getDataBaseName()+"."+this.getTableName()+" where `size`='"+size+"' order by country");
		ArrayList<Tube> tubes = new ArrayList<Tube>();
		while (resultSet.next()) {
			Tube t  = new Tube();
			t.setId(resultSet.getLong("id"));
			t.setBrand(resultSet.getString("brand"));
			t.setCountry(resultSet.getString("country"));
			t.setGol(resultSet.getString("gol"));
			t.setSize(resultSet.getString("size"));
			
			tubes.add(t);
			
		}
		d.close();
		return tubes;
	}
}
