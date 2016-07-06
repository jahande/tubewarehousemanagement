package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JOptionPane;

import controller.Navigator;

import model.TubeCatalog;

import ui.model.Table;

public class SizesFrame extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489358245223844252L;
	int command = 0;
	int columns = 8;
	ArrayList<String> sizesStrings = null;
	private Table sizesTable;

	private final JButton returnBtn = new JButton();
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SizesFrame frame = new SizesFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SizesFrame() {
		super();
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.getContentPane().setLayout(null);
		
		try {
			sizesStrings = TubeCatalog.getInstance().getDistinctBySize();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "اشکال در پایگاه داده");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			//JOptionPane.showMessageDialog(this, "اشکال در سیستم");
			JOptionPane.showMessageDialog(this, e.getMessage());
			
			e.printStackTrace();
			return;
		}
		int raws = sizesStrings.size() / this.getColumns() + 1;
		String[][] strss = new String[raws][this.getColumns()];
		int m = 0;
		boolean flag = false;
		for (int i = 0; i < strss.length; i++) {
			for (int j = 0; i < strss[i].length; j++) {
				if (m < sizesStrings.size()) {
					strss[i][j] = (1+m)+"-"+sizesStrings.get(m);
				} else {
					flag = true;
					break;
				}
				m++;
			}
			if (flag) {
				break;
			}
		}
		this.sizesTable = new Table(strss);

		this.getContentPane().add(this.sizesTable.getJPanel());
		//
		this.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				//System.out.println("ss");
			}

			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == 10) {
					int temp = command;
					SizesFrame.this.command = 0;

					if (temp > SizesFrame.this.sizesStrings.size()) {
						JOptionPane
								.showMessageDialog(
										SizesFrame.this,
										"عددی که وارد کردیده اید بیشتر از تعداد سایزها است. لطفا دوباره عدد را وارد کنید.");

					} else if (temp < 1) {
						JOptionPane
						.showMessageDialog(
								SizesFrame.this,
								"عددی که وارد کردیده اید کوچکتر از ۱ است یا هنوز عددی وارد نکرده اید. لطفا دوباره عدد را وارد کنید.");

			
					} else {

						//SizesFrame.this.setVisible(false);
						Navigator.getInstance().action(
								SizesFrame.this.sizesStrings.get(temp - 1),"select");

					}
				} else if (e.getKeyCode() < 58 && e.getKeyCode() > 47) {
					SizesFrame.this.command *= 10;
					SizesFrame.this.command += (e.getKeyCode() - 48);

				}
				//System.out.println(">>cod" + Integer.toString(e.getKeyCode()));
			}

			public void keyTyped(KeyEvent e) {
				//System.out.println("ss2");
				// TODO Auto-generated method stub

			}

		});
		

	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	private void jbInit() throws Exception {
		setTitle("سایزها");
		
		getContentPane().add(returnBtn);
		returnBtn.setFocusable(false);
		returnBtn.addActionListener(new ReturnBtnActionListener());
		returnBtn.setText("بازگشت");
		returnBtn.setBounds(26, 305, 106, 26);
	}
	private class ReturnBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			returnBtn_actionPerformed(e);
		}
	}
	protected void returnBtn_actionPerformed(ActionEvent e) {
		Navigator.getInstance().action("return");
	}

}
