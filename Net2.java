import java.awt.Color;
import java.awt.Graphics;

public class Net2 {
	
	private int y = Pong.WINDOW_HEIGHT/2 - 75;
	private int width = 25;
	private int height = 150;
	private int x = 976;
	
	public Net2(){
		
	}	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
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
