package GUI;

import javax.swing.JFrame;

import GameLoop.GameLoop;
import Sand.SandHandler;

public class Main {
	
	public static final int LOOP_SPEED_MS = 500;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1020;

	public static void main(String args[]) {
		SandHandler sh = new SandHandler(5);
		GameLoop loop = new GameLoop(sh);
		GUIEventQueue queue = new GUIEventQueue();
		JFrame frame = new JFrame("Sand Adder");
		GUICanvas canvas = new GUICanvas(WIDTH, HEIGHT);
		GUIFrame uiFrame = new GUIFrame(canvas, frame, loop, sh);
		uiFrame.setSize(Main.WIDTH, Main.HEIGHT);
        canvas.addEventQueue(queue);
        canvas.requestFocus();
        loop.setElements(queue, canvas, uiFrame);
        uiFrame.start(uiFrame.getWidth(), uiFrame.getHeight());
        
        
	}
	
	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
