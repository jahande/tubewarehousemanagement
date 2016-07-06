package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Shop extends BaseModel {

	private ShopCatalog shopCatalog = ShopCatalog.getInstance();

	private String name;
	private String ownnerName;
	private String tel;
	private String mobile;
	private String address;

	public Shop(String name, String ownnerName,
			String tel, String mobile, String address) {
		super();
		this.name = name;
		this.ownnerName = ownnerName;
		this.tel = tel;
		this.mobile = mobile;
		this.address = address;
	}


	@Override
	public String toString() {
		return this.getOwnnerName();
	}

	public Shop() {
		super();
	}

	

	@Override
	public void save() throws SQLException, ClassNotFoundException {
		DB db = new DB();
		PreparedStatement ps = db.simpleGetPreparedStatement("insert into  "
				+ db.getDataBaseName() + "." + this.getCatalog().getTableName()
				+ " values ( default, ?, ?, ?, ?, ? )");
		// ps.setLong(1, this.getId());
		ps.setString(1, this.getName());
		ps.setString(2, this.getOwnnerName());
		ps.setString(3, this.getTel());
		ps.setString(4, this.getMobile());
		ps.setString(5, this.getAddress());

		db.simpleExecutePreparedStatement(ps);
	}

	@Override
	public void update() {
		throw new RuntimeException("not implemented!");
	}

	@Override
	public BaseCatalog getCatalog() {

		return this.getShopCatalog();
	}

	@Override
	public void setCatalog(BaseCatalog catalog) {
		this.setShopCatalog((ShopCatalog) catalog);
	}








	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getOwnnerName() {
		return ownnerName;
	}



	public void setOwnnerName(String ownnerName) {
		this.ownnerName = ownnerName;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public ShopCatalog getShopCatalog() {
		return shopCatalog;
	}



	public void setShopCatalog(ShopCatalog shopCatalog) {
		this.shopCatalog = shopCatalog;
	}

	

	@Override
	public boolean equals(Object obj) {
		return ((Shop)obj).getOwnnerName().equals(this.getOwnnerName());
	}
}
