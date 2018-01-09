import java.awt.Color;
import java.awt.Graphics;

public class Time {
	
	private int y = Pong.WINDOW_HEIGHT/2 - 75;
	private int width = 25;
	private int height = 150;
	private int x = 976;
	
	public Time(){
		
	}	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0.0;
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
	}
	public double getTime(){
		return 0.0;
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
