package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import utils.TimestampUtil;

import db.DB;

public class Price extends BaseModel {

	private PriceCatalog priceCatalog = PriceCatalog.getInstance();

	private Shop shop;
	private Tube tube;
	// number of tube
	private long number;
	// price or value
	private long amount;
	private Timestamp date;

	public Price() {
		super();
	}

	@Override
	/**
	 * این تابع کاری به ارجاعات خارجیش ندارد٬ فقط مقدار کلید را ذخیره می کند
	 */
	public void save() throws SQLException, ClassNotFoundException {
		DB db = new DB();
		PreparedStatement ps = db.simpleGetPreparedStatement("insert into  "
				+ db.getDataBaseName() + "." + this.getCatalog().getTableName()
				+ " values ( default, ?, ?, ?, ?, ? )");
		// ps.setLong(1, this.getId());
		ps.setLong(1, this.getShop_id());
		ps.setLong(2, this.getTube_id());
		ps.setLong(3, this.getNumber());
		ps.setLong(4, this.getAmount());
		ps.setTimestamp(5, this.getDate());

		db.simpleExecutePreparedStatement(ps);
	}

	public PriceCatalog getPriceCatalog() {
		return priceCatalog;
	}

	public void setPriceCatalog(PriceCatalog priceCatalog) {
		this.priceCatalog = priceCatalog;
	}

	// UPDATE `tube`.`price` SET `shop_id` = '4',
	// `number` = '123',
	// `amount` = '111',
	// `date` = '2012-11-14 20:29:18' WHERE `price`.`id` =5 LIMIT 1 ;

	@Override
	public void update() throws SQLException, ClassNotFoundException {
		DB db = new DB();
		String tn = PriceCatalog.getInstance().getTableName();
		PreparedStatement ps = db.simpleGetPreparedStatement("UPDATE `"
				+ db.getDataBaseName() + "`.`" + tn + "` SET `shop_id` = '"
				+ this.getShop_id() + "'," + "`number` = '" + this.getNumber()
				+ "'," + "`amount` = '" + this.getAmount() + "',"
				+ "`date` = '" + this.getDate().toString() + "' WHERE `" + tn
				+ "`.`id` =" + this.getId() + " LIMIT 1 ;");
		// ps.setLong(1, this.getId());
		db.simpleExecutePreparedStatement(ps);
		// throw new RuntimeException("not implemented!");

	}

	@Override
	public BaseCatalog getCatalog() {

		return this.getPriceCatalog();
	}

	@Override
	public void setCatalog(BaseCatalog catalog) {
		this.setPriceCatalog((PriceCatalog) catalog);
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Tube getTube() {
		return tube;
	}

	public void setTube(Tube tube) {
		this.tube = tube;
	}

	public long getShop_id() {

		return this.getShop().getId();
	}

	public void setShop_id(long shop_id) {
		if (this.getShop() == null) {
			this.setShop(new Shop());
		}
		this.getShop().setId(shop_id);
	}

	public long getTube_id() {
		return this.getTube().getId();
	}

	@Override
	public String toString() {
		return getAmount() + "         " + getShop().getName() + "         "
				+ getTube().getGol() + "         " + TimestampUtil.timestampToShamsi(getDate());
	}

	public void setTube_id(long tube_id) {
		if (this.getTube() == null) {
			this.setTube(new Tube());
		}
		this.getTube().setId(tube_id);
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	// public String toString(){
	// return this.getDate().toString();
	// }

}
