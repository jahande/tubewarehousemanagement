package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import controller.Navigator;

import ui.model.Table;
import utils.TimestampUtil;

import model.Price;
import model.PriceCatalog;

public class SearchTubeFrame extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1281126743248318911L;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private String tubeSize;
	private JPanel result;
	private final JTextField fromTfl = new JTextField();
	private final JTextField toTfl = new JTextField();
	private final JLabel label = new JLabel();
	private final JLabel label_1 = new JLabel();
	private final JPanel panel = new JPanel();
	private final JLabel messageLbl = new JLabel();
	private final JLabel msgLbl2 = new JLabel();
	private final JButton button = new JButton();

	private final JButton button_1 = new JButton();
	private JScrollPane containerPnl = null;
	private final JPanel panel_1 = new JPanel();
	private final JRadioButton todayRob = new JRadioButton();
	private final JRadioButton weekRob = new JRadioButton();
	private final JRadioButton mounthRob = new JRadioButton();
	private final JRadioButton yearRob = new JRadioButton();
	private final JRadioButton customRob = new JRadioButton();

	private final JPanel panel_2 = new JPanel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JLabel label_8 = new JLabel();
	private final JLabel label_9 = new JLabel();
	private final JLabel label_3 = new JLabel();
	/**
	 * Create the frame
	 */
	public SearchTubeFrame(String size) {
		super();
		this.tubeSize = size;
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.msgLbl2.setText(size);
		this.setSize(1000, 650);
		this.todayRob_mouseReleased(null);
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("جستجو لاستیک بر اساس تاریخ و سایز");

		getContentPane().add(fromTfl);
		fromTfl.setText("1390/8/18");
		fromTfl.setBounds(66, 117, 71, 32);

		getContentPane().add(toTfl);
		toTfl.setText("1391/8/18");
		toTfl.setBounds(152, 117, 71, 32);

		getContentPane().add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setText("از");
		label.setBounds(67, 87, 70, 24);

		getContentPane().add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setText("تا");
		label_1.setBounds(152, 87, 71, 24);

		getContentPane().add(panel);
		panel.setBackground(Color.GREEN);
		panel.setBounds(45, 23, 192, 32);

		panel.add(msgLbl2);
		msgLbl2.setText("...");

		panel.add(messageLbl);
		messageLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		messageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		messageLbl.setText("نمایش اطلاعات برای  سایز");

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("نمایش");
		button.setBounds(75, 337, 126, 26);

		getContentPane().add(button_1);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setText("بازگشت");
		button_1.setBounds(83, 369, 106, 26);

		getContentPane().add(panel_1);
		panel_1.setBackground(new Color(153, 255, 102));
		panel_1
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						new ColumnSpec("80px") }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC, new RowSpec("24px"),
						FormFactory.RELATED_GAP_ROWSPEC, new RowSpec("24px"),
						FormFactory.RELATED_GAP_ROWSPEC, new RowSpec("24px"),
						FormFactory.RELATED_GAP_ROWSPEC, new RowSpec("24px"),
						FormFactory.RELATED_GAP_ROWSPEC, new RowSpec("24px") }));
		panel_1.setBounds(77, 169, 99, 154);

		panel_1.add(todayRob, new CellConstraints("2, 2, 1, 1, left, center"));
		todayRob.setBackground(new Color(153, 255, 102));
		todayRob.addMouseListener(new TodayRobMouseListener());
		todayRob.setSelected(true);
		buttonGroup.add(todayRob);
		todayRob.setText("امروز");

		panel_1.add(weekRob, new CellConstraints("2, 4, 1, 1, left, fill"));
		weekRob.setBackground(new Color(153, 255, 102));
		weekRob.addMouseListener(new WeekRobMouseListener());
		buttonGroup.add(weekRob);
		weekRob.setText("یک هفته پیش");

		panel_1.add(mounthRob, new CellConstraints("2, 6, 1, 1, left, fill"));
		mounthRob.setBackground(new Color(153, 255, 102));
		mounthRob.addMouseListener(new MounthRobMouseListener());
		buttonGroup.add(mounthRob);
		mounthRob.setText("یک ماه پیش");

		panel_1.add(yearRob, new CellConstraints("2, 8, 1, 1, left, fill"));
		yearRob.setBackground(new Color(153, 255, 102));
		yearRob.addMouseListener(new YearRobMouseListener());
		buttonGroup.add(yearRob);
		yearRob.setText("یک سال پیش");

		panel_1.add(customRob, new CellConstraints("2, 10, 1, 1, left, fill"));
		customRob.setBackground(new Color(153, 255, 102));
		customRob.addMouseListener(new CustomRobMouseListener());

		buttonGroup.add(customRob);
		customRob.setText("بازه انتخابی");
		
		getContentPane().add(panel_2);
		panel_2.setBounds(267, 23, 702, 32);
		
		panel_2.add(label_2);
		label_2.setPreferredSize(new Dimension(80, 20));
		label_2.setText("ردیف");
		
		panel_2.add(label_4);
		label_4.setPreferredSize(new Dimension(80, 20));
		label_4.setText("گل");
		
		panel_2.add(label_5);
		label_5.setPreferredSize(new Dimension(80, 20));
		label_5.setText("مارک");
		
		panel_2.add(label_6);
		label_6.setMinimumSize(new Dimension(0, 0));
		label_6.setPreferredSize(new Dimension(80, 20));
		label_6.setText("کشور");
		
		panel_2.add(label_7);
		label_7.setPreferredSize(new Dimension(80, 20));
		label_7.setText("قیمت");
		
		panel_2.add(label_8);
		label_8.setPreferredSize(new Dimension(80, 20));
		label_8.setText("موجودی");
		
		panel_2.add(label_9);
		label_9.setPreferredSize(new Dimension(80, 20));
		label_9.setText("تاریخ");
		
		panel_2.add(label_3);
		label_3.setPreferredSize(new Dimension(80, 20));
		label_3.setText("مالک");

		// getContentPane().add(containerPnl);
		// containerPnl.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// containerPnl.setDoubleBuffered(true);
		// containerPnl.setBounds(276, 23, 692, 74);

	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_1_actionPerformed(e);
		}
	}

	private class TodayRobMouseListener extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			todayRob_mouseReleased(e);
		}
	}

	private class WeekRobMouseListener extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			weekRob_mouseReleased(e);
		}
	}

	private class MounthRobMouseListener extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			mounthRob_mouseReleased(e);
		}
	}

	private class YearRobMouseListener extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			yearRob_mouseReleased(e);
		}
	}

	private class CustomRobMouseListener extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			customRob_mouseReleased(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		if (false && this.result != null) {
			this.containerPnl.remove(this.result);
		}
		Timestamp before = TimestampUtil
				.ShamsiToTimestamp(this.toTfl.getText());
		Timestamp after = TimestampUtil.ShamsiToTimestamp(this.fromTfl
				.getText());
		ArrayList<Price> prices = null;

		try {
			prices = PriceCatalog.getInstance().getByTubeSizeAndDate(
					this.tubeSize, before, after);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this,
					"اشکال در باز خوانی از پایگاه داده");
			e1.printStackTrace();
			return;
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "اشکال در تبدیل");
			e1.printStackTrace();
			return;
		}
		if (prices.size() > 0) {
			if (this.containerPnl != null) {
				this.remove(this.containerPnl);
			}
			Table table = new Table(getStrings(prices));
			JPanel panel = table.getJPanel();
			JPanel test = new JPanel(null);
			JLabel tlbl = new JLabel("sadsadaas");
			tlbl.setPreferredSize(new Dimension(900, 200));
			test.add(tlbl);
			test.setPreferredSize(new Dimension(1000, 300));
			// JPanel panel2 = new JPanel();
			// panel2.add(panel);
			// this.containerPnl.setViewportView(panel);
			// this.containerPnl.setLayout(null);
			// this.containerPnl.add(panel2);
			this.containerPnl = new JScrollPane(panel);
			this.containerPnl
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			containerPnl.setBounds(276, 80, 692, 500);
			getContentPane().add(containerPnl);
			this.repaint();
			this.containerPnl.getViewport().revalidate();
			this.repaint();
			// this.containerPnl.getViewport().revalidate();
		} else {
			JOptionPane.showMessageDialog(this,
					"هیچ قیمتی در این بازه‌ی زمانی وجود ندارد!");
		}
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
			tableColums[i][6] = TimestampUtil.timestampToShamsi(prices.get(i)
					.getDate());

			tableColums[i][7] = prices.get(i).getShop().getOwnnerName();
		}
		return tableColums;
	}

	protected void button_1_actionPerformed(ActionEvent e) {
		Navigator.getInstance().action("return");
	}

	protected void refreshLabelEditing(int days) {
		
		boolean b = this.customRob.isSelected();
		this.fromTfl.setEditable(b);
		this.toTfl.setEditable(b);
		this.fromTfl.setText(TimestampUtil.shamsiOffset(-days));
		this.toTfl.setText(TimestampUtil.shamsiOffset(1));
		
	}

	protected void todayRob_mouseReleased(MouseEvent e) {
		this.refreshLabelEditing(0);
	}

	protected void weekRob_mouseReleased(MouseEvent e) {
		this.refreshLabelEditing(6);
	}

	protected void mounthRob_mouseReleased(MouseEvent e) {
		this.refreshLabelEditing(30);
	}

	protected void yearRob_mouseReleased(MouseEvent e) {

		this.refreshLabelEditing(365);
	}

	protected void customRob_mouseReleased(MouseEvent e) {
		this.refreshLabelEditing(0);
	}

	// protected void panel_1_mouseReleased(MouseEvent e) {
	// boolean b = this.customRob.isSelected();
	// this.fromTfl.setEditable(b);
	// this.toTfl.setEditable(b);
	// }

}
