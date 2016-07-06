package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ui.model.ArrayListGenerator;
import ui.model.CRUDPanel;
import utils.TimestampUtil;

import controller.Navigator;

import model.Price;
import model.PriceCatalog;
import model.Shop;
import model.ShopCatalog;
import model.Tube;

public class AddRecordFrame extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2687310346783407330L;
	Tube tube = null;
	private final JLabel addbrandLabel = new JLabel();
	private final JLabel addCountryLabel = new JLabel();
	private final JTextField addPrice = new JTextField();
	private final JTextField addDate = new JTextField();
	private final JTextField addCount = new JTextField();
	private final JLabel label = new JLabel();
	private final JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JButton button = new JButton();

	private final JComboBox shopsCbx = new JComboBox();

	private final JButton cancelBtn = new JButton();
	private final JPanel crudContainerPanel = new JPanel();
	private CRUDPanel crudPnl;

	private final JLabel label_5 = new JLabel();
	/**
	 * Create the frame
	 */
	public AddRecordFrame(Tube tube) {
		super();
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.setTube(tube);
		ArrayList<Shop> shops = null;
		try {
			shops = ShopCatalog.getInstance().getAll();
			//
			this.crudPnl = new CRUDPanel();
			crudPnl.setBounds(0, 0, 600, 400);
			ArrayList a = PriceCatalog.getInstance().getLimited(0, 10, "-date");
			for (Object object : a) {
				System.out.println(object);
			}
			crudPnl.setArrayListGenerator(new ArrayListGenerator<Price>() {

				public ArrayList<Price> getArrayList() throws Exception {
					return (PriceCatalog.getInstance().getLimited(0, 10,
							"-date"));
				}

			});// (PriceCatalog.getInstance().getLimited(0, 10, "-date"));
			crudPnl.refreshData();
			// crudPnl.setSize(200, 200);
			this.crudContainerPanel.add(crudPnl);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.shopsCbx.setModel(new DefaultComboBoxModel(shops
				.toArray(new Shop[shops.size()])));
		//this.setEnabled(false);
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("ثبت اطلاعات انبار");
		this.setSize( 1200, 695);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(76, 50, 868, 143);

		panel.add(addDate);
		addDate.setBounds(52, 60, 161, 20);

		label.setBounds(52, 23, 161, 31);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		label.setText("زمان");

		addbrandLabel.setBounds(235, 55, 95, 31);
		addbrandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(addbrandLabel);
		addbrandLabel.setText("addBrand");

		addCountryLabel.setBounds(348, 55, 87, 31);
		addCountryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(addCountryLabel);
		addCountryLabel.setText("addcountry");

		addPrice.setBounds(458, 60, 87, 20);
		panel.add(addPrice);

		addCount.setBounds(568, 60, 87, 20);
		panel.add(addCount);

		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText("مارک");
		label_1.setBounds(235, 30, 95, 16);

		panel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setText("کشور");
		label_2.setBounds(348, 30, 87, 16);

		panel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setText("قیمت");
		label_3.setBounds(460, 30, 87, 16);

		panel.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setText("موجودی");
		label_4.setBounds(568, 30, 87, 16);

		panel.add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("ثبت");
		button.setBounds(317, 107, 106, 26);

		panel.add(shopsCbx);
		shopsCbx.setBounds(697, 55, 131, 25);

		panel.add(cancelBtn);
		cancelBtn.addActionListener(new CancelBtnActionListener());
		cancelBtn.setText("لغو");
		cancelBtn.setBounds(472, 107, 106, 26);
		
		panel.add(label_5);
		label_5.setText("مالک انبار");
		label_5.setBounds(713, 30, 58, 16);

		getContentPane().add(crudContainerPanel);
		crudContainerPanel.setLayout(null);
		crudContainerPanel.setBounds(75, 226, 869, 398);
	}

	public Tube getTube() {
		return tube;
	}

	public void setTube(Tube tube) {
		this.tube = tube;
		this.addbrandLabel.setText(tube.getBrand());
		this.addCountryLabel.setText(tube.getCountry());
		this.addDate.setText(TimestampUtil.timestampToShamsi(new Timestamp(
				System.currentTimeMillis())));
		// this.addDate.setText(new Timestamp(System.currentTimeMillis())
		// .toString());
	}

	/**
	 * WindowBuilder generated method.<br>
	 * Please don't remove this method or its invocations.<br>
	 * It used by WindowBuilder to associate the {@link javax.swing.JPopupMenu}
	 * with parent.
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	private class CancelBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cancelBtn_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		Shop shop = (Shop) this.shopsCbx.getSelectedItem();
		Price price = new Price();
		price.setShop(shop);
		price.setTube(this.getTube());
		price.setAmount(new Long(this.addPrice.getText()).longValue());
		price.setNumber(new Long(this.addCount.getText()));
		// TimestampUtil.ShamsiToTimestamp(this.addDate.getText());
		// price.setDate(Timestamp.valueOf(this.addDate.getText()));
		price.setDate(TimestampUtil.ShamsiToTimestamp(this.addDate.getText()));
		try {
			price.save();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, "اشکال در پایگاه داده!"
					+ this.toString());
			e1.printStackTrace();
			return;
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "اشکال در سسیتم!"
					+ this.toString());
			e1.printStackTrace();
			return;
		}

		Navigator.getInstance().action("select-size", shop);
	}

	public void setShop(Shop shop) {
		this.shopsCbx.setSelectedItem(shop);
	}

	protected void cancelBtn_actionPerformed(ActionEvent e) {
		Navigator.getInstance().action("cancel");
	}

	public JPanel getCrudContainerPanel() {
		return crudContainerPanel;
	}

	public CRUDPanel getCrudPnl() {
		return crudPnl;
	}

	public void setCrudPnl(CRUDPanel crudPnl) {
		this.crudPnl = crudPnl;
	}
}
