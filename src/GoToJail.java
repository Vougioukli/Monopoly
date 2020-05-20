
public class GoToJail extends BoardBlock{
	
	public GoToJail(int position,String picturePath) {
		super(picturePath);
		// TODO Auto-generated constructor stub
	}

	public void GoToJailBlockAction(Player player) {
		player.movePlayerToBlock(10);
	}

}
