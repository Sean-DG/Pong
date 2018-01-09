import java.awt.Color;
import java.awt.Graphics;

public class Player2 {
	/**************************************************************
	 * This class is for the second players location and dimensions
	 **************************************************************/
	private int x = 900;
	private int y = Pong.WINDOW_HEIGHT/2;
	private int yVelocity = 0;
	private int width = 15;
	private int height = 85;
	
	public Player2(){
		
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
