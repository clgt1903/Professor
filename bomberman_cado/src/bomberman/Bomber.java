package bomberman;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Bomber extends Actor {
	public static int ALLOW_RUN = 0;
	public static int DISALLOW_RUN = 1;
	protected int sizeBomb, quantityBomb, status, heart;
	// protected boolean death;
	protected int run = 0;
	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public Bomber(int x, int y, int type, int orient, int speed, int sizebomb, int quantityBomb) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.runBomb = DISALLOW_RUN;
		this.orient = orient;
		this.speed = speed;
		this.sizeBomb = sizebomb;
		this.quantityBomb = quantityBomb;
		this.heart = 1;
		this.status = Actor.ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/bomber_down01.png")).getImage();
		width = img.getWidth(null);
		height = img.getHeight(null) - 14;
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	public void setNew(int x, int y) {
		this.x = x;
		this.y = y;
		this.status = ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/bomber_down01.png")).getImage();
	}
	// public int getScore() {
	// return score;
	// }

	// public void setScore(int score) {
	// this.score = score;
	// }

	public void setImg(Image img) {
		this.img = img;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getQuantityBomb() {
		return quantityBomb;
	}

	public void setQuantityBomb(int quantityBomb) {
		if (quantityBomb > 5) {
			return;
		}
		this.quantityBomb = quantityBomb;
	}

	public void setSizeBomb(int sizeBomb) {
		if (sizeBomb > 3) {
			return;
		}
		this.sizeBomb = sizeBomb;
	}

	public int getSizeBomb() {
		return sizeBomb;
	}

	public int getType() {
		return type;
	}

	@Override
	public boolean move(int count, ArrayList<Bomb> arrBomb, ArrayList<Box> arrBox) {
		if (status == DEAD) {
			return false;
		}
		return super.move(count, arrBomb, arrBox);
	}

	@Override
	public void changeOrient(int orient) {
		if (this.status == DEAD) {
			return;
		}
		super.changeOrient(orient);
		//System.out.println(run);
		switch (orient) {
		case LEFT:			
			img = new ImageIcon(getClass().getResource("/Images/bomb_left33.gif")).getImage();	
			
			break;
		case RIGHT:
			img = new ImageIcon(getClass().getResource("/Images/bomb_right33.gif")).getImage();
			break;
		case UP:
			img = new ImageIcon(getClass().getResource("/Images/bomb_up33.gif")).getImage();
			break;
		case DOWN:
			img = new ImageIcon(getClass().getResource("/Images/bomb_down33.gif")).getImage();
			break;
		case LEFT1:			
			img = new ImageIcon(getClass().getResource("/Images/bomber_left01.png")).getImage();	
			
			break;
		case RIGHT1:
			img = new ImageIcon(getClass().getResource("/Images/bomb_right01.png")).getImage();
			break;
		case UP1:
			img = new ImageIcon(getClass().getResource("/Images/bomber_up01.png")).getImage();
			break;
		case DOWN1:
			img = new ImageIcon(getClass().getResource("/Images/bomber_down01.png")).getImage();
			break;	
		default:
			
			break;
		}
	}
	
	public boolean isImpactBomberVsActor(Actor actor) {
		if (status == DEAD) {
			return false;
		}
		Rectangle rec1 = new Rectangle(x, y, width, height);
		Rectangle rec2 = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
		return rec1.intersects(rec2);
	}

}
