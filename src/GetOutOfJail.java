import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GetOutOfJail extends JDialog {
    private JPanel jPanel1;
    private JLabel message;
    private JButton passButton;
    private JButton payButton;
    private JButton rollDiceButton;
    private Player player;
    
	public GetOutOfJail(ControlPanel parent, boolean modal, Player player) {
        super(parent, modal);
        JDialog dialog = this;
        this.player = player;
        jPanel1 = new JPanel();
        message = new JLabel();
        payButton = new JButton();
        rollDiceButton = new JButton();
        passButton = new JButton();

        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        message.setText("You can get out of jail either by rolling the dice and get doubles or by paing 50€");
        payButton.setText("Pay");
        rollDiceButton.setText("Roll Dice");
        passButton.setText("Pass");
        
        passButton.setEnabled(false);
        
        payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Call the players pay method /////////////////////////////////////////////////AAAAAAAAAAAAAAAAAA
				player.getOutOfJail(false);
				player.setTimeInJail(0);
				dialog.dispose();
			}
        	
        });
        
        rollDiceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int moveFor = parent.rollDiceAction();
				if(parent.isPlayAgain()) {
					player.getOutOfJail(false);
					player.setTimeInJail(0);
					parent.updateBoard(moveFor);
					parent.setPlayAgain(false);
					dialog.dispose();
				}
				else if(player.getTimeInJail()<2)
				{
					player.setTimeInJail(player.getTimeInJail()+1);
					passButton.setEnabled(true);
					rollDiceButton.setEnabled(false);
				}
				else
				{
					rollDiceButton.setEnabled(false);
				}
			}
        	
        });

        passButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.endRoundAction();
				dialog.dispose();
			}
        	
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(rollDiceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payButton)
                    .addComponent(rollDiceButton)
                    .addComponent(passButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
