import javax.swing.JOptionPane;

public class introScreen extends JOptionPane{
	/*******************************************************
	 * This was for the opening screen to ask the user how
	 * many players 1 or 2. Would use an AI controlled 
	 * opponent in case of one player
	 *******************************************************/
	private int players;
	private int g;
	
	public introScreen(){
		this.players = 0;
		this.g = -1;	
	}
	
	public void start(){
	while(g < 0){
		String input = JOptionPane.showInputDialog("Enter number of players 1-2: ");
		if(Integer.parseInt(input) ==  1 || Integer.parseInt(input) ==  2){
			g++;
			this.players = Integer.parseInt(input);
		}
		else{
			input = JOptionPane.showInputDialog("Invalid Entry. Enter number of players 1-2: ");
			}
		}
	}
	public int getPlayers(){
		return players;
	}
}
