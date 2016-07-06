package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import utils.TimestampUtil;

import db.DB;

public class PriceCatalog extends BaseCatalog {

	private static PriceCatalog instance = new PriceCatalog();

	public static PriceCatalog getInstance() {
		return PriceCatalog.instance;
	}

	private PriceCatalog() {

	}

	@Override
	protected Object[] getAllResultSet() throws SQLException,
			ClassNotFoundException {
		DB db = new DB();
		String d = db.getDataBaseName();
		String t = new Tube().getCatalog().getTableName();
		String s = new Shop().getCatalog().getTableName();
		return new Object[] {
				db,
				db.simpleGetSelect("select * from " + d + "."
						+ this.getTableName() + " , " + d + "." + t + " , " + d
						+ "." + s + " where " + t + ".id=tube_id and " + s
						+ ".id=shop_id") };
	}

	/**
	 * query generated: SELECT * FROM `price` LIMIT {{from}} , {{number}}
	 * orderedBy `price`.`{{orderedBy}}` {{type|'ASC','DSC'}}
	 * 
	 * @param from
	 * @param number
	 * @param orderedBy
	 * @param type = DESC or ASC
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	protected Object[] getLimitedResultSet(int from,int number, String orderedBy, String type) throws SQLException,
			ClassNotFoundException {
		DB db = new DB();
		String d = db.getDataBaseName();
		String t = new Tube().getCatalog().getTableName();
		String s = new Shop().getCatalog().getTableName();
		return new Object[] {
				db,
				db.simpleGetSelect("select * from " + d + "."
						+ this.getTableName() + " , " + d + "." + t + " , " + d
						+ "." + s + " where " + t + ".id=tube_id and " + s
						+ ".id=shop_id " +
						"ORDER BY `"+ this.getTableName()+"`.`"+orderedBy+"`" + type+
						" LIMIT " + from + " , " + number

				) };
	}

	/**
	 * query generated: SELECT * FROM `price` LIMIT {{from}} , {{number}}
	 * orderedBy `price`.`{{orderedBy}}` {{ DESC if {{orderedby}} starts by '-'
	 * else ASC}}
	 * 
	 * @param from
	 * @param number
	 * @param orderedBy
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Price> getLimited(int from, int number, String orderedBy)
			throws SQLException, ClassNotFoundException {

		String type=null;
		if(orderedBy.charAt(0)=='-'){
			type = "DESC";
			orderedBy = orderedBy.substring(1);
		}else{
			type = "ASC";
		}
		Object[] objs = this.getLimitedResultSet(from, number, orderedBy, type);
		ResultSet resultSet = (ResultSet) objs[1];
		ArrayList<Price> prices = new ArrayList<Price>();
		while (resultSet.next()) {
			Price p = new Price();
			p.setId(resultSet.getLong("id"));
			p.setNumber(resultSet.getLong("number"));
			p.setAmount(resultSet.getLong("amount"));
			p.setDate(resultSet.getTimestamp("date"));

			Shop s = new Shop();
			s.setId(resultSet.getLong(s.getCatalog().getTableName() + ".id"));
			s.setName(resultSet.getString("name"));
			s.setOwnnerName(resultSet.getString("ownnerName"));
			s.setTel(resultSet.getString("tel"));
			s.setMobile(resultSet.getString("mobile"));
			s.setAddress(resultSet.getString("address"));

			p.setShop(s);

			Tube t = new Tube();
			t.setId(resultSet.getLong(t.getCatalog().getTableName() + ".id"));
			t.setBrand(resultSet.getString("brand"));
			t.setCountry(resultSet.getString("country"));
			t.setGol(resultSet.getString("gol"));
			t.setSize(resultSet.getString("size"));

			p.setTube(t);
			// p.setTel(resultSet.getString("tel"));
			// p.setMobile(resultSet.getString("mobile"));
			// p.setAddress(resultSet.getString("address"));

			prices.add(p);

		}
		((DB) (objs[0])).close();
		return prices;
	}

	private String tableName = "price";

	public ArrayList<Price> getAll() throws SQLException,
			ClassNotFoundException {
		Object[] objs = this.getAllResultSet();
		ResultSet resultSet = (ResultSet) objs[1];
		ArrayList<Price> prices = new ArrayList<Price>();
		while (resultSet.next()) {
			Price p = new Price();
			p.setId(resultSet.getLong("id"));
			p.setNumber(resultSet.getLong("number"));
			p.setAmount(resultSet.getLong("amount"));
			p.setDate(resultSet.getTimestamp("date"));

			Shop s = new Shop();
			s.setId(resultSet.getLong(s.getCatalog().getTableName() + ".id"));
			s.setName(resultSet.getString("name"));
			s.setOwnnerName(resultSet.getString("ownnerName"));
			s.setTel(resultSet.getString("tel"));
			s.setMobile(resultSet.getString("mobile"));
			s.setAddress(resultSet.getString("address"));

			p.setShop(s);

			Tube t = new Tube();
			t.setId(resultSet.getLong(t.getCatalog().getTableName() + ".id"));
			t.setBrand(resultSet.getString("brand"));
			t.setCountry(resultSet.getString("country"));
			t.setGol(resultSet.getString("gol"));
			t.setSize(resultSet.getString("size"));

			p.setTube(t);
			// p.setTel(resultSet.getString("tel"));
			// p.setMobile(resultSet.getString("mobile"));
			// p.setAddress(resultSet.getString("address"));

			prices.add(p);

		}
		((DB) (objs[0])).close();
		return prices;
	}

	public ArrayList<Price> getByTubeSizeAndDate(String size, Timestamp before,
			Timestamp after) throws SQLException, ClassNotFoundException {

		DB db = new DB();
		String d = db.getDataBaseName();
		String t = new Tube().getCatalog().getTableName();
		String s = new Shop().getCatalog().getTableName();
		String pn = this.getTableName();
		String bf = TimestampUtil.toSimpleString(before), af = TimestampUtil
				.toSimpleString(after);
		String tempQuery = "select * from " + d + "." + pn + " , " + d + "."
				+ t + " , " + d + "." + s + " where " + t + ".id=tube_id and "
				+ s + ".id=shop_id and " + t + ".size='" + size + "' and " + pn
				+ ".date >= '" + af + "' and " + pn + ".date < '" + bf + "'";

		/*
		 * String tempQuery = "select * from " + d + "." + pn + " , " + d + "." +
		 * t + " , " + d + "." + s + " where " + t + ".size='" + size + "' and " +
		 * pn + ".date >= '" + bf + "' and " + pn + ".date < '" + af+"'";
		 */
		System.out.println(tempQuery);
		ResultSet resultSet = db.simpleGetSelect(tempQuery);

		ArrayList<Price> prices = new ArrayList<Price>();
		while (resultSet.next()) {
			Price p = new Price();
			p.setId(resultSet.getLong("id"));
			p.setNumber(resultSet.getLong("number"));
			p.setAmount(resultSet.getLong("amount"));
			p.setDate(resultSet.getTimestamp("date"));

			Shop shop = new Shop();
			shop.setId(resultSet.getLong(shop.getCatalog().getTableName()
					+ ".id"));
			shop.setName(resultSet.getString("name"));
			shop.setOwnnerName(resultSet.getString("ownnerName"));
			shop.setTel(resultSet.getString("tel"));
			shop.setMobile(resultSet.getString("mobile"));
			shop.setAddress(resultSet.getString("address"));

			p.setShop(shop);

			Tube tube = new Tube();
			tube.setId(resultSet.getLong(tube.getCatalog().getTableName()
					+ ".id"));
			tube.setBrand(resultSet.getString("brand"));
			tube.setCountry(resultSet.getString("country"));
			tube.setGol(resultSet.getString("gol"));
			tube.setSize(resultSet.getString("size"));

			p.setTube(tube);
			// p.setTel(resultSet.getString("tel"));
			// p.setMobile(resultSet.getString("mobile"));
			// p.setAddress(resultSet.getString("address"));

			prices.add(p);

		}
		db.close();
		return prices;
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
