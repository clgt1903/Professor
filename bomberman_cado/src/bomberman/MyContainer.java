package bomberman;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import sound.GameSound;

public class MyContainer extends JPanel {
	private static final String TAG_MENU = "tag_menu";
	private static final String TAG_PLAYGAME = "tag_playgame";
	private static final String TAG_OPTION = "tag_option";

	private CardLayout mCardLayout;
	private GUI gui;
	private Menu mMenu;
	private PlayGame mPlayGame;
	private Option mOption;

	public MyContainer(GUI mGui) {
		this.gui = mGui;
		setBackground(Color.WHITE);
		mCardLayout = new CardLayout();
		setLayout(mCardLayout);
		mMenu = new Menu(this);
		add(mMenu, TAG_MENU);
		mPlayGame = new PlayGame(this);
		add(mPlayGame, TAG_PLAYGAME);
		mOption = new Option(this);
		add(mOption, TAG_OPTION);

		setShowMenu();

	}

	public GUI getGui() {
		return gui;
	}

	public void setShowMenu() {
		mCardLayout.show(MyContainer.this, TAG_MENU);
		mMenu.requestFocus();
		GameSound.getIstance().stop();
		GameSound.getIstance().getAudio(GameSound.BGMMENU).loop();
	}

	public void setShowPlay() {
		mCardLayout.show(MyContainer.this, TAG_PLAYGAME);
		mPlayGame.requestFocus();
		GameSound.getIstance().getAudio(GameSound.BGMMENU).stop();
		GameSound.getIstance().getAudio(GameSound.BGMIG).loop();
	}

	public void setShowOption() {
		mCardLayout.show(MyContainer.this, TAG_OPTION);
		mOption.requestFocus();
	}
}