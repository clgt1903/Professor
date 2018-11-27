package bomberman;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Option extends JPanel implements ActionListener {
	private MyContainer mContainer;
	private JLabel lbbackground;
	private ImageIcon backgroundIcon;
	private JLabel lb_ok;
	private JButton ok;

	public Option(MyContainer mContainer) {
		this.mContainer = mContainer;
		setBackground(Color.YELLOW);
		setLayout(null);
		initCompts();
	}
	public void initCompts() {
		lbbackground = new JLabel();
		lbbackground.setBounds(95, -40, GUI.WIDTHJF, GUI.HEIGHTJF);
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_option.png"));
		lbbackground.setIcon(backgroundIcon);
		add(lbbackground);
		lb_ok = new JLabel();
		lb_ok.setIcon(new ImageIcon(getClass().getResource("/Images/Play1.png")));
		lb_ok.setBounds(400, 550, 210, 50);
		//lb_ok.addMouseListener(this);
		ok = new JButton();
		ok.setBounds(400, 560, 176, 30);
		ok.setIcon(new ImageIcon(getClass().getResource("/Images/Backtomenu.png")));
		ok.addActionListener(this);
		add(ok);
		//add(lb_ok);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			mContainer.setShowMenu();
		}
	}

}