import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class ControlPanel extends JFrame{
    private JButton currCardOptions;
    private JLabel currentPlayer;
    private JLabel die1;
    private JLabel die2;
    private JButton endGame;
    private JButton endRound;
    private JButton forfeit;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton manageCards;
    private JList<String> playerCards;
    private DefaultListModel<String> listModel;
    private JLabel playerMoney;
    private JButton rollDice;
    private int currentPlayerIndex;
    private boolean playAgain = false;
    private ArrayList<Player> players;
    private Board board;
    private ControlPanel frame;
    
    
    public ControlPanel(ArrayList<Player> players) {
    	this.players = players;
    	currentPlayerIndex = 0;
    	frame = this;
    	board = new Board();
    	initializeBoard();
    	
    	
    	jPanel1 = new JPanel();
        currentPlayer = new JLabel();
        playerMoney = new JLabel();
        rollDice = new JButton();
        die1 = new JLabel();
        die2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        playerCards = new JList<>();
        currCardOptions = new JButton();
        manageCards = new JButton();
        forfeit = new JButton();
        endRound = new JButton();
        endGame = new JButton();
        listModel = new DefaultListModel<>();
        
        
        currentPlayer.setText("Player Name");
        playerMoney.setText("Money");
        rollDice.setText("Roll Dice");
        die1.setText("Die1");
        die2.setText("Die2");
        jScrollPane1.setViewportView(playerCards);
        currCardOptions.setText("Current Card Options");
        currCardOptions.setEnabled(false); //You can not manage the current card before playing
        manageCards.setText("Manage Cards");
        forfeit.setText("Forfeit");
        endRound.setText("End Round");
        endRound.setEnabled(false); //You have to play before finishing your round
        endGame.setText("End Game");
        //Set the Panel for the first Player
        updateControlPanel();
        
        //Event Handling
        endRound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Check if the next player is human/AI and if he is in Jail????? 
				endRoundAction();
				updateControlPanel();
			}
        	
        });
        
        rollDice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int moveFor = rollDiceAction();
				updateBoard(moveFor);
				if(!playAgain) {
					rollDice.setEnabled(false); //if playAgain==true you can roll again
					endRound.setEnabled(true); //if playAgain==false you can finish your round
				}
				else if(playAgain)
				{
					playAgain = false;
				}
			}
        	
        });
        
        forfeit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BoardBlock block = board.getPlayerPositionOnBoard();
				block.removePawn(players.get(currentPlayerIndex).getPawn());
				forfeitAction();
			}
        	
        });
        
        endGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Calls the get Winner Class
			}
        	
        });
        
        currCardOptions.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//Calls the CurrentCards class
        	}
        });
        
        manageCards.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//Calls the ManageCards class
        	}
        });
        
        //Set the layout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(forfeit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endRound, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(playerMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rollDice)
                                .addGap(41, 41, 41)
                                .addComponent(die1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(die2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currCardOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(manageCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(currCardOptions)
                        .addGap(18, 18, 18)
                        .addComponent(manageCards)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forfeit)
                    .addComponent(endRound)
                    .addComponent(endGame))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        this.pack();
        this.setTitle("Control Panel");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public void updateControlPanel() {
    	currentPlayer.setText(players.get(currentPlayerIndex).getName());//players[currentPlayerIndex].getName());
    	playerMoney.setText(Integer.toString(players.get(currentPlayerIndex).getMoney())+ "E");   	
    	listModel.clear();
    	for(String card: players.get(currentPlayerIndex).getCards())
    	{
    		//System.out.print(card);
    		listModel.addElement(card);
    	}
    	playerCards.setModel(listModel);
    	if(players.get(currentPlayerIndex).isInJail())
    	{

        	new GetOutOfJail(frame, true, players.get(currentPlayerIndex));
    	}
    }
    
    public void endRoundAction() {
    	currentPlayerIndex = (currentPlayerIndex+1) % players.size();
    	endRound.setEnabled(false); 
    	rollDice.setEnabled(true); //when the round finishes re enable the rollDice for the next Player 
    }
    
    public int rollDiceAction() {
    	int firstDie = 1;//ThreadLocalRandom.current().nextInt(1, 7);     	
    	die1.setText(Integer.toString(firstDie));
    	int secondDie = 2;//ThreadLocalRandom.current().nextInt(1,7);
    	die2.setText(Integer.toString(secondDie));
    	if(firstDie == secondDie)
    		playAgain = true;
    	return firstDie+secondDie;
    }
    
    public void forfeitAction() {
    	/*for(Card c: players.get(currentPlayerIndex).getCards())
    	{
    		c.setOwner = null;
    	}*/ 		
    	players.remove(currentPlayerIndex);
    	if(currentPlayerIndex == players.size())
    		currentPlayerIndex = 0;
    	updateControlPanel();
    	/*if(players.size() == 1)
    	{
    		get Winner
    	}*/
    }
    
    public void updateBoard(int moveFor) { //This method is created for the GetOutOfJail class can use it
    	BoardBlock block = board.updateBoard(players.get(currentPlayerIndex), moveFor);
		executeBlockAction(block);
    }
    
    public void executeBlockAction(BoardBlock block) {
    	currCardOptions.setEnabled(true);
    }
    
    public void initializeBoard() {
    	for(Player p: players)
    	{
    		board.initializeBoard(p);
    	}
    }
    
    public boolean isPlayAgain() {
		return playAgain;
	}

	public void setPlayAgain(boolean playAgain) {
		this.playAgain = playAgain;
	}

	public static void main(ArrayList<Player> players) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlPanel(players).setVisible(true);
            }
        });
    }
}















