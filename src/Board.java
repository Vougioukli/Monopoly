import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Board extends JFrame{
	private JPanel panel;
	private JPanel leftPanel;
	private JPanel topPanel;
	private JPanel rightPanel;
	private JPanel bottomPanel;
	private Player currentPlayer;
	
	private BoardBlock startBlock, leftBlock1, leftBlock2, leftBlock3, leftBlock4, leftBlock5, leftBockl6, leftBlock7, leftBlock8, leftBlock9,
						jailBlock, topBlock1, topBlock2, topBlock3, topBlock4, topBlock5, topBlock6, topBlock7, topBlock8, topBlock9,
						stopBlock, rightBlock1, rightBlock2, rightBlock3, rightBlock4, rightBlock5, rightBlock6, rightBlock7, rightBlock8, rightBlock9,
						goToJailBlock, bottomBlock1, bottomBlock2, bottomBlock3, bottomBlock4, bottomBlock5, bottomBlock6, bottomBlock7, bottomBlock8, bottomBlock9;
	
	public Board() {
		panel = new JPanel(new BorderLayout());
		leftPanel = new JPanel(new GridLayout(9,1));//Due to the way that NORTH/SOUTH border overlap with WEST/EAST border the first block of the left side
		topPanel = new JPanel(new GridLayout(1,11));//is placed in the first slot of the bottom side Panel and the first block of the right side is placed in the
		rightPanel = new JPanel(new GridLayout(9,1));//last slot of the top side panel
		bottomPanel = new JPanel(new GridLayout(1,11));
		
		//Creation of the left side of the board
		startBlock = new BoardBlock("Icons/icon0.png");//START
		leftBlock1 = new BoardBlock("Icons/icon1.png");
		leftBlock2 = new BoardBlock("Icons/icon2.png");
		leftBlock3 = new BoardBlock("Icons/icon3.png");
		leftBlock4 = new BoardBlock("Icons/icon4.png");
		leftBlock5 = new BoardBlock("Icons/icon5.png");
		leftBockl6 = new BoardBlock("Icons/icon6.png");
		leftBlock7 = new BoardBlock("Icons/icon7.png");
		leftBlock8 = new BoardBlock("Icons/icon8.png");
		leftBlock9 = new BoardBlock("Icons/icon9.png");
		
		//Creation of the top side of the board
		jailBlock = new BoardBlock("Icons/icon0.png");//JAIL
		topBlock1 = new BoardBlock("Icons/icon1.png");
		topBlock2 = new BoardBlock("Icons/icon2.png");
		topBlock3 = new BoardBlock("Icons/icon3.png");
		topBlock4 = new BoardBlock("Icons/icon4.png");
		topBlock5 = new BoardBlock("Icons/icon5.png");
		topBlock6 = new BoardBlock("Icons/icon6.png");
		topBlock7 = new BoardBlock("Icons/icon7.png");
		topBlock8 = new BoardBlock("Icons/icon8.png");
		topBlock9 = new BoardBlock("Icons/icon9.png");
		
		//Creation of the right side of the board
		stopBlock   = new BoardBlock("Icons/icon0.png");//STOP
		rightBlock1 = new BoardBlock("Icons/icon1.png");
		rightBlock2 = new BoardBlock("Icons/icon2.png");
		rightBlock3 = new BoardBlock("Icons/icon3.png");
		rightBlock4 = new BoardBlock("Icons/icon4.png");
		rightBlock5 = new BoardBlock("Icons/icon5.png");
		rightBlock6 = new BoardBlock("Icons/icon6.png");
		rightBlock7 = new BoardBlock("Icons/icon7.png");
		rightBlock8 = new BoardBlock("Icons/icon8.png");
		rightBlock9 = new BoardBlock("Icons/icon9.png");	
		
		//Creation of the bottom side of the board
		goToJailBlock = new BoardBlock("Icons/icon0.png");//GO TO JAIL
		bottomBlock1  = new BoardBlock("Icons/icon1.png");
		bottomBlock2  = new BoardBlock("Icons/icon2.png");
		bottomBlock3  = new BoardBlock("Icons/icon3.png");
		bottomBlock4  = new BoardBlock("Icons/icon4.png");
		bottomBlock5  = new BoardBlock("Icons/icon5.png");
		bottomBlock6  = new BoardBlock("Icons/icon6.png");
		bottomBlock7  = new BoardBlock("Icons/icon7.png");
		bottomBlock8  = new BoardBlock("Icons/icon8.png");
		bottomBlock9  = new BoardBlock("Icons/icon9.png");
		
		
		//Add items to left panel
		leftPanel.add(leftBlock9.getPicture());
		leftPanel.add(leftBlock8.getPicture());
		leftPanel.add(leftBlock7.getPicture());
		leftPanel.add(leftBockl6.getPicture());
		leftPanel.add(leftBlock5.getPicture());	
		leftPanel.add(leftBlock4.getPicture());
		leftPanel.add(leftBlock3.getPicture());
		leftPanel.add(leftBlock2.getPicture());
		leftPanel.add(leftBlock1.getPicture());
		
		//Add items to top panel
		topPanel.add(jailBlock.getPicture());//JAIL goes here
		topPanel.add(topBlock1.getPicture());
		topPanel.add(topBlock2.getPicture());
		topPanel.add(topBlock3.getPicture());
		topPanel.add(topBlock4.getPicture());
		topPanel.add(topBlock5.getPicture());
		topPanel.add(topBlock6.getPicture());
		topPanel.add(topBlock7.getPicture());
		topPanel.add(topBlock8.getPicture());
		topPanel.add(topBlock9.getPicture());
		topPanel.add(stopBlock.getPicture());//STOP goes here
		
		//Add items to right panel
		rightPanel.add(rightBlock1.getPicture());
		rightPanel.add(rightBlock2.getPicture());
		rightPanel.add(rightBlock3.getPicture());
		rightPanel.add(rightBlock4.getPicture());
		rightPanel.add(rightBlock5.getPicture());
		rightPanel.add(rightBlock6.getPicture());
		rightPanel.add(rightBlock7.getPicture());
		rightPanel.add(rightBlock8.getPicture());
		rightPanel.add(rightBlock9.getPicture());
		
		//Add items to bottom panel
		bottomPanel.add(startBlock.getPicture());//START goes here
		bottomPanel.add(bottomBlock9.getPicture());
		bottomPanel.add(bottomBlock8.getPicture());
		bottomPanel.add(bottomBlock7.getPicture());
		bottomPanel.add(bottomBlock6.getPicture());
		bottomPanel.add(bottomBlock5.getPicture());
		bottomPanel.add(bottomBlock4.getPicture());
		bottomPanel.add(bottomBlock3.getPicture());
		bottomPanel.add(bottomBlock2.getPicture());
		bottomPanel.add(bottomBlock1.getPicture());
		bottomPanel.add(goToJailBlock.getPicture());//GO TO JAIL goes here
		
		//updateBoard(currentPlayer, 0);
		//Add all the sides to the board
		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		
		this.setTitle("Board");
		this.setContentPane(panel);
		this.setVisible(true);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
	

	public void initializeBoard(Player player) {
		currentPlayer = player;
		startBlock.addPawn(currentPlayer.getPawn());
	}
	
	public BoardBlock updateBoard(Player player, int moveFor) {
		currentPlayer = player;
		BoardBlock block = getPlayerPositionOnBoard();
		block.removePawn(currentPlayer.getPawn());
		player.setPosition(moveFor);
		block = getPlayerPositionOnBoard();
		block.addPawn(currentPlayer.getPawn());
		return block;
	}
	
	public BoardBlock getPlayerPositionOnBoard() {
		switch(currentPlayer.getPosition()) {
			case 0:
				return startBlock;
			case 1:
				return leftBlock1;
			case 2:
				return leftBlock2;
			case 3:
				return leftBlock3;
			case 4:
				return leftBlock4;
			case 5:
				return leftBlock5;
			case 6:
				return leftBockl6;
			case 7:
				return leftBlock7;
			case 8:
				return leftBlock8;
			case 9:
				return leftBlock9;
			case 10:
				return jailBlock;
			case 11:
				return topBlock1;
			case 12:
				return topBlock2;
			case 13:
				return topBlock3;
			case 14:
				return topBlock4;
			case 15:
				return topBlock5;
			case 16:
				return topBlock6;
			case 17:
				return topBlock7;
			case 18:
				return topBlock8;
			case 19:
				return topBlock9;
			case 20:
				return stopBlock;
			case 21:
				return rightBlock1;
			case 22:
				return rightBlock2;
			case 23:
				return rightBlock3;
			case 24:
				return rightBlock4;
			case 25:
				return rightBlock5;
			case 26:
				return rightBlock6;
			case 27:
				return rightBlock7;
			case 28:
				return rightBlock8;
			case 29:
				return rightBlock9;
			case 30:
				return goToJailBlock;
			case 31:
				return bottomBlock1;
			case 32:
				return bottomBlock2;
			case 33:
				return bottomBlock3;
			case 34:
				return bottomBlock4;
			case 35:
				return bottomBlock5;
			case 36:
				return bottomBlock6;
			case 37:
				return bottomBlock7;
			case 38:
				return bottomBlock8;
			case 39:
				return bottomBlock9;
			default:
				return new BoardBlock("");
		}
	}
	
	public BoardBlock getStartBlock() {
		return startBlock;
	}
}







