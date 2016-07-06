package controller;

import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Price;
import model.PriceCatalog;
import model.Shop;
import model.Tube;
import model.TubeCatalog;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//System.out.println("salam");
		//testRegistrer();
//		testTimeStamp();
		//testFilter();
		
		Navigator.getInstance();
		//testSizes();
		//Price p  =new Price();
		//p.setDate(new java.util.Date(System.currentTimeMillis()));
		//System.out.println(p.getDate().toString());
		//TestShop();
	
	}
	static void testRegistrer(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String t = timestamp.toString();
		t = t.substring(0,4);
		System.out.println(t);
		String name = "ghanadzade";
		System.out.println(Integer.getInteger(t));
		
		//FileReader fileReader = new FileReader(new File("c:\\bdabsdhwhq"));
	}
	static void testTimeStamp(){
		System.out.println(new Timestamp(System.currentTimeMillis()).toString().substring(0, 19));
	}
	static void testFilter(){
		try {
			for (Tube t : TubeCatalog.getInstance().filterBySize("s1")) {
				System.out.println(t.getGol());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void testSizes(){
		try {
			for (String s : TubeCatalog.getInstance().getDistinctBySize()) {
				System.out.println(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void pricetest(){
		try {
			for (Price p : PriceCatalog.getInstance().getAll()) {
				System.out.println(p.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void TestShop(){
		System.out.println("SSS");
		Shop s = new Shop("name1","ow3","tel3","mob3","addr3");
		Shop s2 = new Shop("name","ow4","tel4","mob4","addr4");
		Shop s3 = new Shop("name","ow5","tel5","mob5","addr5");
		
		//t.setId(1);
		try {
			s.save();
			s2.save();
			s3.save();
			
//			for (Shop tube : ShopCatalog.getInstance().getAll()) {
//				System.out.println(tube.getName());
//				tube.delete();
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block1
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block1
			e.printStackTrace();
		}
	}
	void TestTube(){
		
		System.out.println("SSS");
		Tube t = new Tube("gol1","b1","c1","s1");
		Tube t2 = new Tube("gol2","b2","c2","s2");
		//t.setId(1)
		;
		try {
			t.save();
			t2.save();
			
			for (Tube tube : TubeCatalog.getInstance().getAll()) {
				System.out.println(tube.getGol());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
