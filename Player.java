
import java.awt.Color;
import java.awt.Graphics;
/**************************************************************
 * This class is for the first players location and dimensions
 **************************************************************/
public class Player {
	
	private int x = 75;
	private int y = Pong.WINDOW_HEIGHT/2;
	private int yVelocity = 0;
	private int width = 15;
	private int height = 85;
	private int highScore = 0;
	public Player(){
		
	}	
	public void update(){
		if(y + height > Pong.WINDOW_HEIGHT){
			y = Pong.WINDOW_HEIGHT - height;
		}
		else if(y < 0){
			y = 0;
		}
		else{
		y = y + yVelocity;
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
	public void setYVelocity(int speed){
		yVelocity = speed;
	}
	
	public int getHighScore(){
		return highScore;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height; 	
	}
}
