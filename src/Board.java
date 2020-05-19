import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		//GridLayout ll = new GridLayout(1,11);
		//ll.setVgap(0);
		topPanel = new JPanel(new GridBagLayout());//is placed in the first slot of the bottom side Panel and the first block of the right side is placed in the
		rightPanel = new JPanel(new GridLayout(9,1));//last slot of the top side panel
		bottomPanel = new JPanel(new GridBagLayout());
		
		//Creation of the left side of the board
		startBlock = new BoardBlock("Icons/start.jpg");//START
		leftBlock1 = new BoardBlock("Icons/small.png");
		leftBlock2 = new BoardBlock("Icons/chanceSide.jpg");
		leftBlock3 = new BoardBlock("Icons/small.png");
		leftBlock4 = new BoardBlock("Icons/small.png");
		leftBlock5 = new BoardBlock("Icons/small.png");
		leftBockl6 = new BoardBlock("Icons/small.png");
		leftBlock7 = new BoardBlock("Icons/orderSide.jpg");
		leftBlock8 = new BoardBlock("Icons/small.png");
		leftBlock9 = new BoardBlock("Icons/small.png");
		
		//Creation of the top side of the board
		jailBlock = new BoardBlock("Icons/jail.jpg");//JAIL
		topBlock1 = new BoardBlock("Icons/smallVert.png");
		topBlock2 = new BoardBlock("Icons/smallVert.png");
		topBlock3 = new BoardBlock("Icons/smallVert.png");
		topBlock4 = new BoardBlock("Icons/smallVert.png");
		topBlock5 = new BoardBlock("Icons/smallVert.png");
		topBlock6 = new BoardBlock("Icons/smallVert.png");
		topBlock7 = new BoardBlock("Icons/chanceVertical.jpg");
		topBlock8 = new BoardBlock("Icons/smallVert.png");
		topBlock9 = new BoardBlock("Icons/smallVert.png");
		
		//Creation of the right side of the board
		stopBlock   = new BoardBlock("Icons/stop.jpg");//STOP
		rightBlock1 = new BoardBlock("Icons/small.png");
		rightBlock2 = new BoardBlock("Icons/orderSide.jpg");
		rightBlock3 = new BoardBlock("Icons/small.png");
		rightBlock4 = new BoardBlock("Icons/small.png");
		rightBlock5 = new BoardBlock("Icons/small.png");
		rightBlock6 = new BoardBlock("Icons/small.png");
		rightBlock7 = new BoardBlock("Icons/small.png");
		rightBlock8 = new BoardBlock("Icons/small.png");
		rightBlock9 = new BoardBlock("Icons/small.png");	
		
		//Creation of the bottom side of the board
		goToJailBlock = new BoardBlock("Icons/goToJail.jpg");//GO TO JAIL
		bottomBlock1  = new BoardBlock("Icons/smallVert.png");
		bottomBlock2  = new BoardBlock("Icons/smallVert.png");
		bottomBlock3  = new BoardBlock("Icons/chanceVetrical.jpg");
		bottomBlock4  = new BoardBlock("Icons/smallVert.png");
		bottomBlock5  = new BoardBlock("Icons/smallVert.png");
		bottomBlock6  = new BoardBlock("Icons/orderVertical.jpg");
		bottomBlock7  = new BoardBlock("Icons/smallVert.png");
		bottomBlock8  = new BoardBlock("Icons/smallVert.png");
		bottomBlock9  = new BoardBlock("Icons/smallVert.png");
		
		
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
		/*topPanel.add(jailBlock.getPicture());//JAIL goes here
		topPanel.add(topBlock1.getPicture());
		topPanel.add(topBlock2.getPicture());
		topPanel.add(topBlock3.getPicture());
		topPanel.add(topBlock4.getPicture());
		topPanel.add(topBlock5.getPicture());
		topPanel.add(topBlock6.getPicture());
		topPanel.add(topBlock7.getPicture());
		topPanel.add(topBlock8.getPicture());
		topPanel.add(topBlock9.getPicture());
		topPanel.add(stopBlock.getPicture());//STOP goes here*/
		addObjects(jailBlock.getPicture(), topPanel, 0, 0, 1, 1);
		addObjects(topBlock1.getPicture(), topPanel, 1, 0, 1, 1);
		addObjects(topBlock2.getPicture(), topPanel, 2, 0, 1, 1);
		addObjects(topBlock3.getPicture(), topPanel, 3, 0, 1, 1);
		addObjects(topBlock4.getPicture(), topPanel, 4, 0, 1, 1);
		addObjects(topBlock5.getPicture(), topPanel, 5, 0, 1, 1);
		addObjects(topBlock6.getPicture(), topPanel, 6, 0, 1, 1);
		addObjects(topBlock7.getPicture(), topPanel, 7, 0, 1, 1);
		addObjects(topBlock8.getPicture(), topPanel, 8, 0, 1, 1);
		addObjects(topBlock9.getPicture(), topPanel, 9, 0, 1, 1);
		addObjects(stopBlock.getPicture(), topPanel, 10, 0, 1, 1);
		
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
		/*bottomPanel.add(startBlock.getPicture());//START goes here
		bottomPanel.add(bottomBlock9.getPicture());
		bottomPanel.add(bottomBlock8.getPicture());
		bottomPanel.add(bottomBlock7.getPicture());
		bottomPanel.add(bottomBlock6.getPicture());
		bottomPanel.add(bottomBlock5.getPicture());
		bottomPanel.add(bottomBlock4.getPicture());
		bottomPanel.add(bottomBlock3.getPicture());
		bottomPanel.add(bottomBlock2.getPicture());
		bottomPanel.add(bottomBlock1.getPicture());
		bottomPanel.add(goToJailBlock.getPicture());//GO TO JAIL goes here*/
		addObjects(startBlock.getPicture(), bottomPanel, 0, 0, 1, 1);
		addObjects(bottomBlock1.getPicture(), bottomPanel, 1, 0, 1, 1);
		addObjects(bottomBlock2.getPicture(), bottomPanel, 2, 0, 1, 1);
		addObjects(bottomBlock3.getPicture(), bottomPanel, 3, 0, 1, 1);
		addObjects(bottomBlock4.getPicture(), bottomPanel, 4, 0, 1, 1);
		addObjects(bottomBlock5.getPicture(), bottomPanel, 5, 0, 1, 1);
		addObjects(bottomBlock6.getPicture(), bottomPanel, 6, 0, 1, 1);
		addObjects(bottomBlock7.getPicture(), bottomPanel, 7, 0, 1, 1);
		addObjects(bottomBlock8.getPicture(), bottomPanel, 8, 0, 1, 1);
		addObjects(bottomBlock9.getPicture(), bottomPanel, 9, 0, 1, 1);
		addObjects(goToJailBlock.getPicture(), bottomPanel, 10, 0, 1, 1);
		
		//Add all the sides to the board
		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		
		this.setTitle("Board");
		this.setContentPane(panel);
		this.setVisible(true);
		this.pack();
		//this.setSize(100, 100);
		//this.setResizable(false);
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
		player.movePlayer(moveFor);
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
				return null;
		}
	}
	
	public BoardBlock getStartBlock() {
		return startBlock;
	}
	
	public void addObjects(JLabel block, JPanel panel, int gridx, int gridy, int gridwidth, int gridheigth){

		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;

        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheigth;

        panel.add(block, gbc);
    }
}







