import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	private int players;
	private int score;
	private int score2;
	private int seconds;
	private int highScore;
	private int playAgain;
	private boolean running;
	private int myTimerDelay;
	private final Timer myTimer;
	Net net = new Net();
	Net2 net2 = new Net2();
	Ball ball = new Ball();
	Player player = new Player();
	Player2 player2 = new Player2();
	introScreen intro = new introScreen();
	scoreScreen outro = new scoreScreen();
	Computer computer = new Computer(this);
	
	
	/******************************************************
	 * Main part of the program sets everything into motion
	 * including adding a tick rate and creating the playing
	 * field as well as the ball, players and or the AI 	
	 *****************************************************/
	public GamePanel(){
		Timer tim = new Timer(25, this);
		tim.start();
		running = true;
		players = 0;
		score = 0;
		this.addKeyListener(this);
		this.setFocusable(true);
		seconds = 0;
		myTimerDelay = 1000;
		myTimer = new Timer(myTimerDelay, gameTimer);
		myTimer.start();
	}
	
	ActionListener gameTimer = new ActionListener(){
		public void actionPerformed(ActionEvent theEvent){
			seconds++;		
		}
	};
	
	/*****************************************************************
	 * Updates the ball and continually checks to see if it intersects 
	 * either player or goal. Can choose 1 player vs AI or 2 Players
	 * Can also choose to play again
	 *****************************************************************/
	private void update(){
		/**********************************
		 * Displays a panel asking for the 
		 * number of players
		 **********************************/
		intro.start();
		players = intro.getPlayers();
		
		
		/***************************************
		 * Depending on the choice from the 
		 * previous panel updates those players
		 * as well as the ball. Also checks to 
		 * see if the win condition has been met
		 ***************************************/
		while(running){
		if(players == 1){
				player.update();
				computer.update();
				ball.update();
				ball.checkCollisionWith(player);
				ball.checkCollisionWith(computer);
				ball.checkCollisionWith(net);
				ball.checkCollisionWith(net2);
				if(ball.getScore() == 7 || ball.getScore2() == 7 ){
					running = false;
				}
				return;
		}
		else{
				player.update();
				player2.update();
				ball.update();
				ball.checkCollisionWith(player);
				ball.checkCollisionWith(player2);
				ball.checkCollisionWith(net);
				ball.checkCollisionWith(net2);
				if(ball.getScore() == 7 || ball.getScore2() == 7 ){
					running = false;
				}
				return;
			}
		}
		
		
		/*******************************
		 * Asks the player if they want
		 * to play again
		 *******************************/
		//outro.enterName();
		outro.start();
		playAgain = outro.getPlayAgain();
		if(playAgain == 1){
			outro.setPlayAgain(0);
			ball.setScore(0);
			ball.setScore2(0);
			seconds = 0;
			myTimer.start();
			running = true;
			return;
			}
		else{
			System.exit(0);
			}
	}
	
	public Ball getBall(){
		return ball;
	}
	
	/***********************************
	 * Paints the ball, players and goals
	 * as well as a victory message at
	 * the end of the game
	 ***********************************/
	public void paintComponent(Graphics g){
		/********************************
		 * Paint the playing field black
		 ********************************/
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Pong.WINDOW_WIDTH,Pong.WINDOW_HEIGHT);
		
		
		/**************************************
		 * Display the players, ball and goals	
		 **************************************/
		if(players == 1){
			ball.paint(g);
			player.paint(g);
			computer.paint(g);
			net.paint(g);
			net2.paint(g);		
		}
		else{
			ball.paint(g);
			player.paint(g);
			player2.paint(g);
			net.paint(g);
			net2.paint(g);
		}
		
		
		/*************************************
		 * Display the score for both players
		 *************************************/
		g.setColor(Color.WHITE);
		Font f = new Font("TimesRoman", Font.BOLD, 30);
		g.setFont(f);
		g.drawString(Integer.toString(ball.getScore()), 400, 600);
		g.drawString(Integer.toString(ball.getScore2()), 600, 600);
		
		
		/**********************************************************
		 * Create our timer to display in the top left corner 
		 * of the game screen
		 **********************************************************/
		Font z = new Font("TimesRoman", Font.BOLD, 22);
		g.setFont(z);
		g.drawString("Time: " + seconds,0,20);
		
		
		/********************************
		 * Draw the field lines and goals
		 ********************************/
		g.setColor(Color.WHITE);
		g.drawLine(Pong.WINDOW_WIDTH/2, 0, Pong.WINDOW_WIDTH/2, Pong.WINDOW_HEIGHT);
		g.drawOval(Pong.WINDOW_WIDTH/2 - 50,Pong.WINDOW_HEIGHT/2 - 50, 100, 100);
		g.drawRect(850, 190, 150, 300);
		g.drawRect(0, 190, 150, 300);
		
		
		/*************************************
		 * Display the winner and their score 
		 * after the game ends
		 *************************************/
		if(!running){
			myTimer.stop();
			Font r = new Font("TimesRoman",Font.BOLD,60);
			g.setFont(r);
			highScore = 7 * seconds;
			if(players == 1){
			if(ball.getScore() == 7){
				g.drawString("Player 1 wins! Score: "+ highScore,215,100);
				}
			else{
				g.drawString("     AI wins! Score: " + highScore,215,100);
				}
			}
			else{
				if(ball.getScore() == 7){
					g.drawString("PLayer 1 wins! Score: " + highScore,215,100);
					}
				else{
					g.drawString("Player 2 wins! Score: " + highScore,215,100);
					}
			}
		}
		
	}
	
	
	/**************************************************************************
	 *These methods are all responsible for receiving and interpreting
	 *user input as well as updating where objects are and where to paint them
	 **************************************************************************/
	public void actionPerformed(ActionEvent e){
		update();
		repaint();
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			player2.setYVelocity(-10);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.setYVelocity(10);
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			player.setYVelocity(-10);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			player.setYVelocity(10);
		}
	}
	public void keyReleased(KeyEvent e){
		int KeyCode = e.getKeyCode();
		if(KeyCode == KeyEvent.VK_UP || KeyCode == KeyEvent.VK_DOWN){
			player2.setYVelocity(0); 
		}
		if(KeyCode == KeyEvent.VK_A || KeyCode == KeyEvent.VK_Z){
			player.setYVelocity(0); 
		}
	}
	public void keyTyped(KeyEvent e){
		
	}
}
