package ui.model;


import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Navigator;

import model.Price;

/**
 * 
 * @author rj
 * @usecase 42
 */

public class CRUDPanel extends JPanel implements

		 ListMouseListenner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JList list = new JList();
	private final JLabel label = new JLabel();
	private JPanel deletePanel;// s= new JPanel();
	private JPanel editPanel;
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	protected ArrayListGenerator<Price> arrayListGenerator;
	protected boolean removeRequest = false;

	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	/**
	 * Create the frame
	 */
	public CRUDPanel() {
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		this.setLayout(null);
		setBackground(new Color(153, 204, 204));

		resetPanels();
		
		add(panel);
		panel.setBackground(new Color(153, 255, 102));
		panel.setBounds(111, 24, 227, 39);

		panel.add(label);
		label.setBackground(new Color(153, 255, 102));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("۱۰ قیمت آخر ثبت شده");
		
		add(panel_1);
		panel_1.setBounds(193, 96, 250, 26);
		
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setPreferredSize(new Dimension(50, 20));
		label_1.setText("قیمت");
		
		panel_1.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setPreferredSize(new Dimension(50, 20));
		label_2.setText("فروشنده");
		
		panel_1.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setPreferredSize(new Dimension(50, 20));
		label_3.setText("گل");
		
		panel_1.add(label_4);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setPreferredSize(new Dimension(50, 20));
		label_4.setText("تاریخ");
	}

	

	public void listMouseListennerActionPerform(MouseEvent e, Object obj,
			String type) {
		if (type.equals("delete")) {
			this.deleteActionPerform(e,(Price)obj);
		} else if (type.equals("edit")) {
			this.editActionPerform(e,(Price)obj);
		}
		// JOptionPane.showMessageDialog(this, ((AbstractUser)obj).getId());
	}

	public void refreshData() throws Exception{
		// TODO Auto-generated method stub
		resetPanels();

		// this.panel = new JPanel();
		for (Object obj : this.arrayListGenerator.getArrayList()) {
				ParameterLabel<Price> rejectLbl = new ParameterLabel<Price>();

				rejectLbl.setParameter((Price)obj);
				rejectLbl.setPreferredSize(new Dimension(40, 13));
				rejectLbl.setHorizontalTextPosition(SwingConstants.CENTER);
				rejectLbl.setHorizontalAlignment(SwingConstants.CENTER);
				rejectLbl.setForeground(Color.RED);
				rejectLbl.addMouseListener(new ListMouseAdapter<Price>(
						(Price)obj, this, "delete"));
				rejectLbl.setText("حذف");

				ParameterLabel<Price> acceptLbl = new ParameterLabel<Price>();
				acceptLbl.setParameter((Price)obj);
				acceptLbl.setPreferredSize(new Dimension(40, 13));
				acceptLbl.setHorizontalTextPosition(SwingConstants.CENTER);
				acceptLbl.setHorizontalAlignment(SwingConstants.CENTER);
				acceptLbl.setForeground(Color.GREEN);
				acceptLbl.addMouseListener(new ListMouseAdapter<Price>(
						(Price)obj, this, "edit"));
				acceptLbl.setText("ویرایش");

				this.editPanel.add(acceptLbl);
				this.deletePanel.add(rejectLbl);
			

		}
		// /////////////////////////
		try {
			this.remove(list);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۲");
			return;
		}
		ArrayList<String> names = new ArrayList<String>();
		for (Object obj : this.arrayListGenerator.getArrayList()) {
			Price price = (Price) obj;
				names.add(price.toString());

		}
		list = new JList();
		this.add(list);
		list.setModel(new SimpleListModel(names));
		list.setBounds(193, 140, 250, 244);

	}

	private JPanel[] resetPanels() {
		try {
			this.remove(this.deletePanel);
			this.remove(this.editPanel);

		} catch (Exception e) {
			// TODO: handle exception
		}

		JPanel p = new JPanel();
		this.add(p);
		p.setBounds(99, 140, 70, 244);
		this.deletePanel = p;

		JPanel p2 = new JPanel();
		this.add(p2);
		p2.setBounds(10, 140, 64, 244);
		this.editPanel = p2;

		// /////////////////////////////////////

		return new JPanel[] { p, p2 };
	}


	protected void editActionPerform(MouseEvent e,Price price) {

		//JLabel mes = new JLabel("آیا شما به تایید درخواست مطمئن هستید؟ !");
		//int n = JOptionPane.showOptionDialog(this, mes, price.toString(),
			//	JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				//null, null, null);
		// pane.set
		if (true){// || n == JOptionPane.YES_OPTION) {
			try {
				this.refreshData();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException();
			}
			Navigator.getInstance().action("edit", price);
		}
	}


	protected void deleteActionPerform(MouseEvent e,Price price) {
		JLabel mes = new JLabel(
				"آیا شما به حذف قیمت مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			
			try {
				price.delete();
				this.refreshData();
				JOptionPane.showMessageDialog(this, "عملیات با موفقیت انجام شد");
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(this, "عملیات انجام نشد");
				throw new RuntimeException();
			}
		}
	}

	public ArrayListGenerator<Price> getArrayListGenerator() {
		return arrayListGenerator;
	}

	public void setArrayListGenerator(ArrayListGenerator<Price> arrayListGenerator) {
		this.arrayListGenerator = arrayListGenerator;
	}


	

}
