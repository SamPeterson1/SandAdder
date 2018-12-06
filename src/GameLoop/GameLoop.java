package GameLoop;

import GUI.GUICanvas;
import GUI.GUIEvent;
import GUI.GUIEventQueue;
import GUI.GUIFrame;
import Sand.SandBox;
import Sand.SandCreator;
import Sand.SandHandler;


public class GameLoop {

	public GUIEventQueue queue;
	public GUICanvas canvas;
	public GUIEvent event;
	public GUIFrame frame;
	public SandHandler sh;
	int iters = 0;
	
	public GameLoop(SandHandler sh) {
		this.sh = sh;
	}
	
	public void update() {
		System.out.println(iters);
		if(sh.isZero()) {
			System.out.println("OMGGGGGG");
		}
		sh.update();
		iters ++;
		if(queue.isEventToProcess()) {
			event = queue.getEvent();
			if(event.getType() == GUIEvent.EVENT_KEY_PRESS) {
				if(event.getKeyChar() == 'a') {
					sh.switchBox(SandHandler.SB_1);
				} else if(event.getKeyChar() == 'b') {
					sh.switchBox(SandHandler.SB_2);
				} else if(event.getKeyChar() == 'c') {
					sh.switchBox(SandHandler.ADDED_SB);
				} else if(SandCreator.eventIsValid(event)) {
					System.out.println("HI");
					int[] vals = SandCreator.updateFromEvent(sh.getCurrentSandBox().getSize(), frame.getWidth(), frame.getHeight(), queue.getMouseX(), queue.getMouseY(), event.getKeyChar());
					sh.getCurrentSandBox().setSand(vals[0], vals[1], vals[2]);
				}
			}
			if(event.getType() == GUIEvent.EVENT_MOUSE_BUTTON_PRESS && event.isMouseLeftButton()) {
				sh.getCurrentSandBox().setCenter(2048);
				sh.getCurrentSandBox().toppleAll();
			}
		}
	
	}

	
	public void setElements(GUIEventQueue q, GUICanvas c, GUIFrame f) {
		this.queue = q;
		this.canvas = c;
		this.frame = f;
	}
	
}
