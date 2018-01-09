/*
 *  @author Sean Grenfell	
 *  @version 2016/4/3
 *  
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
/************
 *Main Driver  
 ************/
public class Pong extends JFrame {
	final static int WINDOW_WIDTH = 1007;
	final static int WINDOW_HEIGHT = 683;
	public Pong(){
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pong");
		add(new GamePanel());
		setVisible(true);
	}
	public static void main(String[] args){
		new Pong();
	}
}
