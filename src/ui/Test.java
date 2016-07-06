package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Price;

import utils.TimestampUtil;

public class Test extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8891034950256150217L;
	JScrollPane containerPnl;
	private final JButton button = new JButton();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Test frame = new Test();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
//		
	}

	/**
	 * Create the frame
	 */
	public Test() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
		
		this.setSize(1000, 600);
		
		
	}
	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		
		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("New JButton");
		button.setBounds(24, 76, 106, 26);
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
		JPanel test = new JPanel(null);
		JLabel tlbl = new JLabel("sadsadaas");
		tlbl.setPreferredSize(new Dimension(900,200));
		test.add(tlbl);
		test.setPreferredSize(new Dimension(1000,300));
		//JPanel panel2 = new JPanel();
		//panel2.add(panel);
		//this.containerPnl.setViewportView(panel);
		//this.containerPnl.setLayout(null);
		//this.containerPnl.add(panel2);
		containerPnl=new JScrollPane(test);
		
		containerPnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		containerPnl.setBounds(276, 23, 692, 74);
		getContentPane().add(containerPnl);
		this.repaint();
	}
	private String[][] getStrings(ArrayList<Price> prices) {
		// price->3 shop->1 tube->3 rowNum->1
		String[][] tableColums = new String[prices.size()][3 + 1 + 3 + 1];
		for (int i = 0; i < prices.size(); i++) {
			tableColums[i][0] = new Integer(i).toString();

			tableColums[i][1] = prices.get(i).getTube().getGol();
			tableColums[i][2] = prices.get(i).getTube().getBrand();
			tableColums[i][3] = prices.get(i).getTube().getCountry();

			tableColums[i][4] = new Long(prices.get(i).getAmount()).toString();
			tableColums[i][5] = new Long(prices.get(i).getNumber()).toString();
			tableColums[i][6] = TimestampUtil.timestampToShamsi(prices.get(i).getDate());

			tableColums[i][7] = prices.get(i).getShop().getOwnnerName();
		}
		return tableColums;
	}
}
