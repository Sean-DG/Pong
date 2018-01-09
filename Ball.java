import java.awt.Graphics;
import java.awt.Color;
/**************************************
 * This class represents the ball
 * and is often called to see if it
 * intersects with either player or 
 * one of the goals and if so it calls
 * the score method to add +1 to the 
 * other players score
 ***************************************/
public class Ball {
	private int x = Pong.WINDOW_WIDTH/2;
	private int y = Pong.WINDOW_HEIGHT/2;
	
	private int score = 0;
	private int score2 = 0;
	private int speed = 12;
	private int size = 20;
	
	private int xVelocity = -speed;
	private int yVelocity = speed;
	
	public void update(){
		x = x + xVelocity;
		y = y + yVelocity;
		
		if(x < 0){
			xVelocity = speed;
		}
		else if(x + size > Pong.WINDOW_WIDTH - 7){
			xVelocity = -speed;
		}
		if(y < 0){
			yVelocity = speed;
		}
		else if(y + size > Pong.WINDOW_HEIGHT - 33){
			yVelocity = -speed;
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, size, size);
	}
	private void reverseDirection(){
		xVelocity = -xVelocity;
	}
	public void setScore(int _score){
		score = _score;
	}
	private void score(){
				score++;
	}
	public void setScore2(int _score){
		score2 = _score;
	}
	private void score2(){
				score2++;
	}
	public int getScore(){
		return score;
	}
	public int getScore2(){
		return score2;
	}
	public void checkCollisionWith(Player player){
		
		if(this.x > player.getX() && this.x < player.getX() + player.getWidth()){
			if(this.y > player.getY() && this.y < player.getY() + player.getHeight()){
				reverseDirection();
			}
		}
	}
	public void checkCollisionWith(Player2 player){
		if(this.x + size > player.getX() && this.x + size < player.getX() + player.getWidth()){
			if(this.y > player.getY() && this.y < player.getY() + player.getHeight()){
				reverseDirection();
			}
		}
	}
	public void checkCollisionWith(Net net){
		if(this.x > net.getX() && this.x < net.getX() + net.getWidth()){
			if(this.y > net.getY() && this.y < net.getY() + net.getHeight()){
				x = Pong.WINDOW_WIDTH/2;
				y = Pong.WINDOW_HEIGHT/2;
				score2();
			}
		}
	}
	public void checkCollisionWith(Net2 net2){
		if(this.x > net2.getX() && this.x < net2.getX() + net2.getWidth()){
			if(this.y > net2.getY() && this.y < net2.getY() + net2.getHeight()){
				x = Pong.WINDOW_WIDTH/2;
				y = Pong.WINDOW_HEIGHT/2;
				score();
		}
	}
}
	
	public void checkCollisionWith(Computer computer){
		if(this.x + size > computer.getX() && this.x + size < computer.getX() + computer.getWidth()){
			if(this.y > computer.getY() && this.y < computer.getY() + computer.getHeight()){
				reverseDirection();
			}
		}
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
