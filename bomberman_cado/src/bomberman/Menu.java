package bomberman;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sound.GameSound;

public class Menu extends JPanel {
	private int padding = 15;;
	private GUI mGui;
	private MyContainer mContainer;
	private JLabel lbbackground;
	private JLabel lbPlayGame;
	private JLabel lbOption;
	private JLabel lbExit;
	private ImageIcon backgroundIcon;

	public Menu(MyContainer mContainer) {
		this.mContainer = mContainer;
		this.mGui = mContainer.getGui();
		setBackground(Color.YELLOW);
		setLayout(null);
		initComps(mGui);
		initbackground();
	}

	public void initComps(GUI mGui) {
		lbPlayGame = setLabel((mGui.getWidth() - 100) / 2 - 30, (mGui.getHeight() - 30) / 2 - 100, "/Images/Play1.png");
		lbOption = setLabel(lbPlayGame.getX(), lbPlayGame.getY() + lbPlayGame.getHeight() + padding, "/Images/Howtoplay.png");
		lbExit = setLabel(lbOption.getX(), lbOption.getY() + lbOption.getHeight() + padding, "/Images/Exit1.png");

		lbPlayGame.addMouseListener(mMouseAdapter);
		lbOption.addMouseListener(mMouseAdapter);
		lbExit.addMouseListener(mMouseAdapter);

		add(lbPlayGame);
		add(lbOption);
		add(lbExit);

	}

	public void initbackground() {
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -10, mGui.getWidth(), mGui.getHeight());
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu.png"));
		lbbackground.setIcon(backgroundIcon);
		add(lbbackground);
	}

	public JLabel setLabel(int x, int y, String ImageIcon) {
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		return label;
	}

	private MouseAdapter mMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == lbPlayGame) {
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/Images/Play2.png"));
				lbPlayGame.setIcon(playIcon);
			}
			if (e.getSource() == lbOption) {
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/Images/Howtoplay2.png"));
				lbOption.setIcon(optionIcon);
			}

			if (e.getSource() == lbExit) {
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/Images/Exit2.png"));
				lbExit.setIcon(exitIcon);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == lbPlayGame) {
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/Images/Play1.png"));
				lbPlayGame.setIcon(playIcon);
			}
			if (e.getSource() == lbOption) {
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/Images/Howtoplay.png"));
				lbOption.setIcon(optionIcon);
			}

			if (e.getSource() == lbExit) {
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/Images/Exit1.png"));
				lbExit.setIcon(exitIcon);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == lbExit) {
				GameSound.getIstance().getAudio(GameSound.BGMMENU).stop();
				mGui.dispose();
				PlayGame.IS_RUNNING = false;
			}
			if (e.getSource() == lbPlayGame) {
				mContainer.setShowPlay();
			}
			if (e.getSource() == lbOption) {
				mContainer.setShowOption();
			}

		}
	};

}