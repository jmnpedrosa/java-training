package threads;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/* 
 * A funny example of how Thread.sleep() can be used to control motion speed in animations
 * as it guarantees that code execution will be suspended for at least the specified time.
 * 
 * If you have a UI, be careful not to call Thread.sleep() on the entire UI thread, lest your
 * application becomes unresponsive and you face the user's wrath.
 */

public class UsingThreadSleep {
  
	public static void main(String... args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		frame.setVisible(true);
		MovingBall ball = new MovingBall(60, frame);
		ball.start();
	}
	
}

class MovingBall extends Thread {
  
	int radius;
	Graphics g;
	int xPos, yPos;
	JFrame frame;
	
	MovingBall(int radius, JFrame frame) {
		this.radius = radius;
		this.g = frame.getGraphics();
		this.frame = frame;
	}
	
	public void run() {
		while (true) {
		    // This will ensure the thread pauses for at least 10 milliseconds.
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				System.out.println(e);
			}
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
			++xPos;
			++yPos;
			g.setColor(Color.BLACK);
			g.fillOval(xPos, yPos, radius, radius);
		}
	}
}