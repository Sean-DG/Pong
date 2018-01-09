import java.awt.Color;
import java.awt.Graphics;
/*****************************************************
 *This gives the information for the computer opponent
 *as well as the AI 
 *****************************************************/
public class Computer {
	private GamePanel field;
	private int x = 900;
	private int y = Pong.WINDOW_HEIGHT/2;
	private int yVelocity = 0;
	private int width = 15;
	private int height = 85;
	private int speed = 7;
	public Computer(GamePanel game){
		this.field = game;
	}	
	public void update(){
		if(field.getBall().getY() < this.y){
			yVelocity = -speed;
		}
		else if(field.getBall().getY() > this.y){
			yVelocity = speed;
		}
		y = y + yVelocity;
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
