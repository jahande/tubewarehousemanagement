package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;

public class ShopCatalog extends BaseCatalog {

	private static ShopCatalog instance = new ShopCatalog();
	public static ShopCatalog getInstance() {
		return ShopCatalog.instance;
	}
	private ShopCatalog(){
		
	}
	private String tableName="shop";
	public ArrayList<Shop> getAll() throws SQLException, ClassNotFoundException {
		Object[] objs = this.getAllResultSet();
		ResultSet resultSet = (ResultSet)objs[1];
		ArrayList<Shop> shops = new ArrayList<Shop>();
		while (resultSet.next()) {
			Shop s  = new Shop();
			s.setId(resultSet.getLong("id"));
			s.setName(resultSet.getString("name"));
			s.setOwnnerName(resultSet.getString("ownnerName"));
			s.setTel(resultSet.getString("tel"));
			s.setMobile(resultSet.getString("mobile"));
			s.setAddress(resultSet.getString("address"));
			
			shops.add(s);
			
		}
		((DB)(objs[0])).close();
		return shops;
	}
	@Override
	public String getTableName() {
		return tableName;
	}
	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
