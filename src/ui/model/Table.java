package ui.model;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import config.ApplicationConfiguration;

public class Table {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6664748504250123829L;
	private String[][] stringss;
	private int labelWidth = 80;
	private int labelHeight = 20;
	private int verticalGap = 2;
	private Color columnColor = Color.WHITE;
	private int horizontalGap = 2;
	private Color bgColor=Color.BLACK;
	
	private JPanel header;
	private String[] headers;
	
	
	public JPanel getHeader() {
		JPanel panel = new JPanel(ApplicationConfiguration.getInstance()
				.getJPanelDoubleBuffered());
		panel.setLayout(null);
		int panelWidth = 0;
		if(this.getHeaders()==null ){
			panelWidth = 0
			* (this.getHorizontalGap() + this.getLabelWidth()) + 
			this.getHorizontalGap();
		}else{
		panelWidth = this.getHeaders().length
				* (this.getHorizontalGap() + this.getLabelWidth()) + 
				this.getHorizontalGap();
		}
		int panelHeight = 1
				* (this.getVerticalGap() + this.getLabelHeight()) + 
				 this.getVerticalGap();
		panel.setSize(panelWidth, panelHeight);
		panel.setPreferredSize(new Dimension(panelWidth,panelHeight));
		panel.setLocation(0, 0);
		panel.setBackground(this.getBgColor());
		// for (String[] strings :this.getStringss() ) {
		// for (String string : strings) {
		// JLabel l = new JLabel(string);
		// l.setSize(this.getLabelWidth() , this.getLabelHeight());
		// l.set
		//				
		// }
		// }
			for (int j = 0; j < this.getHeaders().length; j++) {

				JLabel l = new JLabel(this.getHeaders()[j]);
				
				l.setSize(this.getLabelWidth(), this.getLabelHeight());
				
				JPanel pl = new JPanel();
				pl.setLayout(null);
				pl.setSize(this.getLabelWidth(), this.getLabelHeight());
				pl.setLocation(this.getHorizontalGap() + j
						* (this.getLabelWidth()+this.getHorizontalGap()), this.getVerticalGap() + 0
						* (this.getLabelHeight()+this.getVerticalGap()));
				pl.setBackground(this.getColumnColor());
				l.setLocation(0, 0);
				//l.setBackground(Color.BLUE);
				pl.add(l);
				panel.add(pl);
				
			}
		return panel;
	}
	
	public static Table getTestInstance(){
		String[][] s = new String[][]{{"(1,1)","(1,2)","(1,3)"},
			{"(2,1)","(2,2)","(2,3)"},
			{"(3,1)","(3,2)","(3,3)"}};
			Table t = new Table(s);
			return t;
	}

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
		int panelWidth = 0;
		if(this.getStringss()==null || this.getStringss()[0]==null){
			panelWidth = 0
			* (this.getHorizontalGap() + this.getLabelWidth()) + 
			this.getHorizontalGap();
		}else{
		panelWidth = this.getStringss()[0].length
				* (this.getHorizontalGap() + this.getLabelWidth()) + 
				this.getHorizontalGap();
		}
		int panelHeight = this.getStringss().length
				* (this.getVerticalGap() + this.getLabelHeight()) + 
				 this.getVerticalGap();
		panel.setSize(panelWidth, panelHeight);
		panel.setPreferredSize(new Dimension(panelWidth,panelHeight));
		panel.setLocation(0, 0);
		panel.setBackground(this.getBgColor());
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
				pl.setBackground(this.getColumnColor());
				l.setLocation(0, 0);
				//l.setBackground(Color.BLUE);
				pl.add(l);
				panel.add(pl);
				
			}
		}
		return panel;
	}
	

	public Table(String[][] stringss) {
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

	public Color getColumnColor() {
		return columnColor;
	}

	public void setColumnColor(Color columnColor) {
		this.columnColor = columnColor;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public void setLabelHeight(int labelHeight) {
		this.labelHeight = labelHeight;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}
}
