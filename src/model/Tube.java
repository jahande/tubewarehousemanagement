package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Tube extends BaseModel {

	private TubeCatalog tubeCatalog = TubeCatalog.getInstance();

	private String gol;
	private String brand;
	private String country;
	private String size;

	public Tube() {
		super();
	}

	public Tube(String gol, String brand, String country, String size) {
		super();
		this.gol = gol;
		this.brand = brand;
		this.country = country;
		this.size = size;
	}

	@Override
	public void save() throws SQLException, ClassNotFoundException {
		DB db = new DB();
		PreparedStatement ps = db.simpleGetPreparedStatement("insert into  "
				+ db.getDataBaseName() + "." + this.getCatalog().getTableName()
				+ " values ( default, ?, ?, ?, ? )");
		// ps.setLong(1, this.getId());
		ps.setString(1, this.getGol());
		ps.setString(2, this.getBrand());
		ps.setString(3, this.getCountry());
		ps.setString(4, this.getSize());

		db.simpleExecutePreparedStatement(ps);

		// preparedStatement = connect
		// .prepareStatement("insert into tube.COMMENTS values (default, ?, ?,
		// ?, ? , ?, ?)");
		// // "myuser, webpage, datum, summery, COMMENTS from
		// FEEDBACK.COMMENTS");
		// // Parameters start with 1
		// preparedStatement.setString(1, "Test");
		// preparedStatement.setString(2, "TestEmail");
		// preparedStatement.setString(3, "TestWebpage");
		// preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		// preparedStatement.setString(5, "TestSummary");
		// preparedStatement.setString(6, "TestComment");
		// preparedStatement.executeUpdate();
	}

	@Override
	public void update() {
		throw new RuntimeException("not implemented!");
	}

	@Override
	public BaseCatalog getCatalog() {

		return this.getTubeCatalog();
	}

	@Override
	public void setCatalog(BaseCatalog catalog) {
		this.setTubeCatalog((TubeCatalog) catalog);
	}

	public String getGol() {
		return gol;
	}

	public void setGol(String gol) {
		this.gol = gol;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public TubeCatalog getTubeCatalog() {
		return tubeCatalog;
	}

	public void setTubeCatalog(TubeCatalog tubeCatalog) {
		this.tubeCatalog = tubeCatalog;
	}

	

}
