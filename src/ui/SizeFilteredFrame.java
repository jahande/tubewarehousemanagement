package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Tube;
import model.TubeCatalog;

import controller.Navigator;

import ui.model.Table;

public class SizeFilteredFrame extends BaseFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6307805621288894685L;
	int command = 0;
	Table table;
	int column = 3;
	ArrayList<Tube> tubes;

	private JScrollPane scrollPane1 = null;

	private final JPanel headerPanel = new JPanel();

	/**
	 * Create the frame
	 */
	public SizeFilteredFrame(String size) {
		super();
		try {
			this.tubes = TubeCatalog.getInstance().filterBySize(size);
			this.table = new Table(this.getTableStrings(size));
			this.table.setHeaders(new String[]{
					"ردیف",
					"مارک",
					"کشور"
					
			});
			this.getContentPane().setLayout(null);

			this.scrollPane1 = new JScrollPane(this.table.getJPanel());
			this.scrollPane1
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			this.scrollPane1.setBounds(97, 73, 277, 215);
			;
			getContentPane().add(this.scrollPane1);
			this.repaint();
			this.scrollPane1.getViewport().revalidate();
			this.repaint();
			
			this.headerPanel.add(this.table.getHeader());
			
			this.setTitle(size+
					" لیست لاستیک‌های با سایز "
					);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "pppokid1");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "pppokid2");

			e.printStackTrace();
		}

		this.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					int temp = command;
					SizeFilteredFrame.this.command = 0;

					if (temp > SizeFilteredFrame.this.tubes.size()) {
						JOptionPane
								.showMessageDialog(
										SizeFilteredFrame.this,
										"عددی که وارد کردیده اید بیشتر از تعداد سطرها است. لطفا دوباره عدد را وارد کنید.");

					} else if (temp < 1) {
						JOptionPane
								.showMessageDialog(
										SizeFilteredFrame.this,
										"عددی که وارد کردیده اید کوچکتر از ۱ است یا هنوز عددی وارد نکرده اید. لطفا دوباره عدد را وارد کنید.");

					} else {

						// SizesFrame.this.setVisible(false);
						Navigator.getInstance().action("",
								SizeFilteredFrame.this.tubes.get(temp - 1));

					}
				} else if (e.getKeyCode() < 58 && e.getKeyCode() > 47) {
					SizeFilteredFrame.this.command *= 10;
					SizeFilteredFrame.this.command += (e.getKeyCode() - 48);

				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		//
	}

	String[][] getTableStrings(String size) throws SQLException,
			ClassNotFoundException {
		String[][] stringss = new String[tubes.size()][this.column];
		for (int i = 0; i < stringss.length; i++) {
			stringss[i][0] = Integer.toString(i + 1);
			stringss[i][1] = tubes.get(i).getBrand();
			stringss[i][2] = tubes.get(i).getCountry();

		}

		return stringss;
	}

	private void jbInit() throws Exception {

		System.currentTimeMillis();

		getContentPane().add(headerPanel);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setBounds(97, 28, 249, 28);
	}

}
