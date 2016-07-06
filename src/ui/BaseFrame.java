package ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Navigator;

public class BaseFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3646472634056386817L;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			BaseFrame frame = new BaseFrame();
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public BaseFrame() {
		super();
		setBounds(0, 0, 500, 375);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
		//

		this.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowClosed(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				JLabel mes = new JLabel(
						"آیا مطمئن به خروج از برنامه هستید؟ با این کار اطلاعات ذخیره نشده از بین می‌روند!");
				int n = JOptionPane.showOptionDialog(BaseFrame.this, mes,
						"اخطار", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null, null, null);
				// pane.set
				if (n == JOptionPane.YES_OPTION) {
					Navigator.getInstance().action("exit");
				} else {
					throw new RuntimeException();
				}
			}

			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

}
