import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class scoreScreen extends JOptionPane{
	/*******************************************************
	 * After the game ends the user is prompted to indicate
	 * whether or not they would like to play again
	 *******************************************************/
	private int playAgain;
	private String name;
	private int g;
	private int f;
	public scoreScreen(){
		this.playAgain = 0;
		this.g = -1;
		this.f = -1;
	}
	/* Reads high scores from a file and displays them then asks for your initials
	public void enterName(){
		while(f < 0){
			try{
				BufferedReader br = new BufferedReader(new FileReader("resources/Rankings.txt"));
				
				String str = null;
				while((str = br.readLine()) != null){
					JOptionPane.showMessageDialog(null,str + "\n");
				}
				br.close();
				name = JOptionPane.showInputDialog("Enter your initials: ");
				return;
			}catch(IOException e){
				JOptionPane.showMessageDialog(null,"File not found");
			}
			
			
			f++;
		}
	}*/
	public void start(){
	while(g < 0){
		String input = JOptionPane.showInputDialog("Press 1 to play again 2 to quit");
		if(Integer.parseInt(input) ==  1 || Integer.parseInt(input) ==  2){
			g++;
			this.playAgain = Integer.parseInt(input);
		}
		else{
			input = JOptionPane.showInputDialog("Invalid Entry. Enter 1 or 2: ");
			}
		}
	}
	public void setPlayAgain(int _playAgain){
		playAgain = _playAgain;
	}
	public int getPlayAgain(){
		return playAgain;
	}
}
