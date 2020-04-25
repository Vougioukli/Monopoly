import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Player {
	private String name;
	private int money;
	private ArrayList<String> cards; 
	private int position;
	private JLabel pawn;
	private boolean inJail;
	private int timeInJail;

	
	public Player(String name, int money) {
		this.name = name;
		this.money = 1500;
		cards = new ArrayList<>();
		position = 0;
		timeInJail = 0;
		inJail = false;
		this.pawn  = new JLabel(new ImageIcon("Icons/pion.png"));
		
	}
	
	public String getName() {
		return name;
	}


	public boolean isInJail() {
		return inJail;
	}

	public void goToJail() {
		this.inJail = true;
		movePlayerToBlock(10);
		
	}

	public int getTimeInJail() {
		return timeInJail;
	}

	public void setTimeInJail(int timeInJail) {
		this.timeInJail = timeInJail;
	}

	
	public int getMoney() {
		return money;
	}

	public void getPaid(int money) {
		this.money += money;
	}
	
	public void payPlayer(Player player, int money) {
		if(this.money>=money) {
			this.money -= money; 
			player.getPaid(money);
		}else {
			JOptionPane.showMessageDialog(null, "You don't have enough money to pay the rent");
		}
		
	}
	
	public void buyCard(String card) {
		
	}
	
	public void buildHouse(String card, int quantity) {
		
	}

	public ArrayList<String> getCards() {
		return cards;
	}

	
	public void movePlayer(int dice) {
		int posbefore = position;
		position = (position + dice) % BoardBlock.getTotalBlocks();
		if(posbefore > position) {   //auto shmainei oti perase apo thn afaithria
			this.getPaid(200);
		}
	}

	public int getPosition() {
		return position;
	}

	public JLabel getPawn() {
		return pawn;
	}

	
	public void getOutOfJail(boolean inJail) {
		this.inJail = inJail;
	}

	public void movePlayerToBlock(int position) {
		this.position = position;
	}
	
	
}
