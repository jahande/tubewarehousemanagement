package ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import config.ApplicationConfiguration;

public class TubeTableFrame extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7015668761677588080L;

	private final JPanel panel = new JPanel();

	private final JLabel label = new JLabel();
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			TubeTableFrame frame = new TubeTableFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public TubeTableFrame() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);

		getContentPane().add(panel);
		panel.setBackground(Color.YELLOW);
		panel.setLayout(null);
		panel.setBounds(348, 282, 134, 37);
		
		panel.add(label);
		label.setDoubleBuffered(true);
		label.setForeground(Color.GREEN);
		label.setBackground(Color.GREEN);
		label.setText("New JLabel");
		label.setBounds(39, 10, 66, 16);
		
		JPanel p = TubeTable.getTestInstance().getJPanel();
		getContentPane().add(p);
		
		
	}

}

class TubeTable {
	public static TubeTable getTestInstance(){
		String[][] s = new String[][]{{"(1,1)","(1,2)","(1,3)"},
			{"(2,1)","(2,2)","(2,3)"},
			{"(3,1)","(3,2)","(3,3)"}};
			TubeTable t = new TubeTable(s);
			return t;
	}
	private String[][] stringss;
	private int labelWidth = 80;
	private int labelHeight = 20;
	private int verticalGap = 30;
	private int horizontalGap = 40;

	public int getVerticalGap() {
		return verticalGap;
	}

	public void setVerticalGap(int verticalGap) {
		this.verticalGap = verticalGap;
	}

	public int getHorizontalGap() {
		return horizontalGap;
	}

	public void setHorizontalGap(int horizontalGap) {
		this.horizontalGap = horizontalGap;
	}

	/*
	 * (1,1)(1,2)(1,3) (2,1)(2,2)(2,3) (3,1)
	 */
	public JPanel getJPanel() {
		JPanel panel = new JPanel(ApplicationConfiguration.getInstance()
				.getJPanelDoubleBuffered());
		panel.setLayout(null);
		int panelWidth = this.getStringss()[0].length
				* (this.getHorizontalGap() + this.getLabelWidth()) + 2
				* this.getHorizontalGap();
		int panelHeight = this.getStringss().length
				* (this.getVerticalGap() + this.getLabelHeight()) + 2
				* this.getVerticalGap();
		panel.setSize(panelWidth, panelHeight);
		panel.setLocation(0, 0);
		panel.setBackground(Color.GREEN);
		// for (String[] strings :this.getStringss() ) {
		// for (String string : strings) {
		// JLabel l = new JLabel(string);
		// l.setSize(this.getLabelWidth() , this.getLabelHeight());
		// l.set
		//				
		// }
		// }
		for (int i = 0; i < this.getStringss().length; i++) {
			for (int j = 0; j < this.getStringss()[i].length; j++) {

				JLabel l = new JLabel(this.getStringss()[i][j]);
				
				l.setSize(this.getLabelWidth(), this.getLabelHeight());
				
				JPanel pl = new JPanel();
				pl.setLayout(null);
				pl.setSize(this.getLabelWidth(), this.getLabelHeight());
				pl.setLocation(this.getHorizontalGap() + j
						* (this.getLabelWidth()+this.getHorizontalGap()), this.getVerticalGap() + i
						* (this.getLabelHeight()+this.getVerticalGap()));
				pl.setBackground(Color.BLUE);
				l.setLocation(0, 0);
				//l.setBackground(Color.BLUE);
				pl.add(l);
				panel.add(pl);
				
			}
		}
		return panel;
	}
	

	public TubeTable(String[][] stringss) {
		super();
		this.stringss = stringss;
	}

	public String[][] getStringss() {
		return stringss;
	}

	public void setStringss(String[][] stringss) {
		this.stringss = stringss;
	}

	public int getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}

	public int getLabelHeight() {
		return labelHeight;
	}

	public void setLableHeith(int lableHeith) {
		this.labelHeight = lableHeith;
	}
}
