package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Navigator;

import utils.TimestampUtil;

import model.Price;
import model.Shop;
import model.ShopCatalog;

public class EditPrice extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6583683904302865293L;
	private final JPanel panel = new JPanel();
	private final JTextField amountTxf = new JTextField();
	private final JTextField numberTxf = new JTextField();
	private final JTextField dateTxf = new JTextField();
	private final JLabel label = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JComboBox comboBox = new JComboBox();
	private final JButton okBtn = new JButton();
	private final JButton cancelBtn = new JButton();
	
	Price price;
	
	/**
	 * Create the frame
	 */
	public EditPrice(Price price) {
		super();
		this.price = price;
		setBounds(100, 100, 253, 175);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			jbInit();
			this.comboBox.setModel(new DefaultComboBoxModel(ShopCatalog.getInstance().getAll().toArray()));
			this.comboBox.setSelectedItem(price.getShop());
			this.amountTxf.setText(new Long(price.getAmount()).toString());
			this.numberTxf.setText(new Long(price.getNumber()).toString());
			this.dateTxf.setText(TimestampUtil.timestampToShamsi(price.getDate()));
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}
	private void jbInit() throws Exception {
		System.currentTimeMillis();
		setTitle("ویرایش قیمت");
		getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.add(amountTxf);
		amountTxf.setPreferredSize(new Dimension(100, 20));
		
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(100, 20));
		label.setText("قیمت");
		
		panel.add(numberTxf);
		numberTxf.setPreferredSize(new Dimension(100, 20));
		
		panel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setPreferredSize(new Dimension(100, 20));
		label_2.setText("تعداد");
		
		panel.add(dateTxf);
		dateTxf.setPreferredSize(new Dimension(100, 20));
		
		panel.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setPreferredSize(new Dimension(100, 20));
		label_3.setText("تاریخ");
		
		panel.add(comboBox);
		comboBox.setPreferredSize(new Dimension(100, 20));
		
		panel.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setPreferredSize(new Dimension(100, 20));
		label_4.setText("فروشنده");
		
		panel.add(okBtn);
		okBtn.addActionListener(new OkBtnActionListener());
		okBtn.setText("ثبت");
		
		panel.add(cancelBtn);
		cancelBtn.addActionListener(new CancelBtnActionListener());
		cancelBtn.setText("لغو");
	}

	/**
	 * WindowBuilder generated method.<br>
	 * Please don't remove this method or its invocations.<br>
	 * It used by WindowBuilder to associate the {@link javax.swing.JPopupMenu} with parent.
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
	private class OkBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			okBtn_actionPerformed(e);
		}
	}
	private class CancelBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cancelBtn_actionPerformed(e);
		}
	}
	protected void okBtn_actionPerformed(ActionEvent e) {
		this.price.setAmount(new Long(this.amountTxf.getText()).longValue());
		this.price.setNumber(new Long(this.numberTxf.getText()).longValue());
		this.price.setDate(TimestampUtil.ShamsiToTimestamp(this.dateTxf.getText()));
		this.price.setShop((Shop)this.comboBox.getSelectedItem());
		this.price.setShop_id(((Shop)this.comboBox.getSelectedItem()).getId());
		try {
			this.price.update();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Navigator.getInstance().action("done");
		
	}
	protected void cancelBtn_actionPerformed(ActionEvent e) {
		Navigator.getInstance().action("done");
	}
}
