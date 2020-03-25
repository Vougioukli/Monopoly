import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
	private String name;
	private int money;
	private ArrayList<String> cards = new ArrayList<>();
	private int position;
	private JLabel pawn;
	private boolean inJail;
	private int timeInJail;
	//private ImageIcon pion;
	//private String pion;
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
		cards.add("brwon 1");
		cards.add("blue 1");
		cards.add(name);
		position = 0;
		timeInJail = 0;
		inJail = false;
		this.pawn  = new JLabel(new ImageIcon("Icons/pion.png"));
		//this.pion = new ImageIcon("pion.png");
		//this.pion = "pion.png";
	}

	public String getName() {
		return name;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public int getTimeInJail() {
		return timeInJail;
	}

	public void setTimeInJail(int timeInJail) {
		this.timeInJail = timeInJail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<String> getCards() {
		return cards;
	}

	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}
	
	public void setPosition(int plus) {
		position = (position + plus) % BoardBlock.getTotalBlocks();
	}

	public int getPosition() {
		return position;
	}

	public JLabel getPawn() {
		return pawn;
	}

	
	
	
}
