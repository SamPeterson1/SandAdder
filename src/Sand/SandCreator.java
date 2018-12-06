package Sand;

import GUI.GUIEvent;

public class SandCreator {
	
	public static int[] updateFromEvent(int size, int windowWidth, int windowHeight, int mouseX, int mouseY, char key) {
		
		int[] retVal = new int[3];
		int selectX = mouseX/(windowWidth/size);
		int selectY = mouseY/(windowHeight/size);
		retVal[0] = selectY;
		retVal[1] = selectX;
		
		Character num = new Character(key);
		System.out.println("[[" + retVal[0] + ", " + retVal[1] + "], " + "[" + mouseX + ", " + mouseY + "]]");
		retVal[2] = Integer.parseInt(num.toString());
		
		return retVal;
		
	}
	
	public static boolean eventIsValid(GUIEvent e) {
		
		char c = e.getKeyChar();
		return (c == '1' || c == '2' || c == '3');
		
	}
	
}
