package Sand;

public class SandHandler {
	SandBox sb1;
	SandBox sb2;
	SandBox addedPile;
	public static final int SB_1 = 0;
	public static final int SB_2 = 1;
	public static final int ADDED_SB = 2;
	int currentPile = 0;
	
	public SandHandler(int size) {
		this.sb1 = new SandBox(size);
		this.sb2 = new SandBox(size);
		this.addedPile = new SandBox(size);
		sb2.setAll();
		sb1.setAll();
	}
	
	public boolean isZero() {
		for(int i = 0; i < sb1.getSize(); i ++) {
			for(int ii = 0; ii < sb1.getSize(); ii ++) {
				if(sb1.getSandAt(i, ii) != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void update() {
		sb1 = SandAdder.addSandBoxes(this.sb1, this.sb2);
	}
	
	public void switchBox(int pile) {
		this.currentPile = pile;
	}
	
	public SandBox getCurrentSandBox() {
		
		if(currentPile == SandHandler.SB_1) {
			return this.sb1;
		} else if(currentPile == SandHandler.SB_2) {
			return this.sb2;
		}
		
		return this.addedPile;
		
	}
}
