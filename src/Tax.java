
public class Tax extends BoardBlock{
	private int tax;

	public Tax(int position,String picturePath) {
		super(picturePath);
		// TODO Auto-generated constructor stub
	}
	
	
	public void TaxBoardAction(Player player) {
		int money=player.getMoney();
		if (player.getPosition()==5) 
			tax=200;
		else if (player.getPosition()==38)
			tax=100;
		PayOrder.payFine(tax);
	}

}
