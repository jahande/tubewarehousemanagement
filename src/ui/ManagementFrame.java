package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.Navigator;

public class ManagementFrame extends BaseFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1554330134947944154L;
	private final JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JPanel panel_2 = new JPanel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JLabel label_8 = new JLabel();
	private final JButton button = new JButton();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenuItem newItemMenuItem = new JMenuItem();
	private final JMenuItem newItemMenuItem_1 = new JMenuItem();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ManagementFrame frame = new ManagementFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ManagementFrame() {
		super();
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				int i = e.getKeyCode();
				i-=48;
				if(i==1){
					Navigator.getInstance().action(Integer.toString(i));
				}else if(i==2){
					Navigator.getInstance().action(Integer.toString(i));
				}
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		//
		setBounds(0, 0, 500, 425);

		this.setVisible(true);
		
	}
	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("سامانه‌ی موجودی انبارهای خارجی");
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().add(panel);
		panel.setBounds(330, 82, 126, 194);
		
		panel.add(label_1);
		label_1.setPreferredSize(new Dimension(80, 20));
		label_1.setText("لاستیک");
		
		panel.add(label_2);
		label_2.setPreferredSize(new Dimension(80, 20));
		
		panel.add(label_3);
		label_3.setPreferredSize(new Dimension(80, 20));
		
		panel.add(label_4);
		label_4.setPreferredSize(new Dimension(80, 20));
		
		getContentPane().add(panel_2);
		panel_2.setBounds(198, 82, 126, 194);
		
		panel_2.add(label_5);
		label_5.setPreferredSize(new Dimension(100, 20));
		label_5.setText("ثبت قیمت لاستیک");
		
		panel_2.add(label_6);
		label_6.setPreferredSize(new Dimension(100, 20));
		label_6.setText("مشاهده‌ی قیمت لاستیک");
		
		panel_2.add(label_7);
		label_7.setPreferredSize(new Dimension(80, 20));
		
		panel_2.add(label_8);
		label_8.setPreferredSize(new Dimension(80, 20));
		
		getContentPane().add(button);
		button.setFocusable(false);
		button.addActionListener(new ButtonActionListener());
		button.setText("خروج");
		button.setBounds(10, 305, 106, 26);
		
		setJMenuBar(menuBar);
		
		menuBar.add(newItemMenuItem_1);
		
		menuBar.add(newItemMenuItem);
		newItemMenuItem.addActionListener(new NewItemMenuItemActionListener());
		newItemMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		newItemMenuItem.setText("درباره‌ی نرم افزار");
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}
	private class NewItemMenuItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newItemMenuItem_actionPerformed(e);
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
		Navigator.getInstance().action("exit");
	}
	protected void newItemMenuItem_actionPerformed(ActionEvent e) {
		JTextArea textArea = new JTextArea(
		"به نام خدا"+
		"\n\n\n"+
		"نرم‌افزار سامانه موجودی انبارهای خارجی در آبان سال ۱۳۹۱ توسط روح‌الله جهنده و به سفارش آقای محمد قنادزاده طراحی و پیاده‌سازی شده است. "
		+"\n\n"
		+"نسخه‌ی ۱.۰"+
		"\n\n"
		+"تمامی حقوق طراحی و پیاده سازی برای روح‌الله جهنده محفوظ است. "
		+"\n\n"
		+":ارتباط با طراح از طریق:"+
		"\n"+
		"۰۹۱۵۵۱۹۲۰۶۶"+
		"\n"+
		"jahande@ce.sharif.edu"
		
		
		);
		textArea.setEditable(false);
		JOptionPane.showMessageDialog(this, textArea);
	}

}
