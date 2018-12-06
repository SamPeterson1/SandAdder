package Sand;

public class SandAdder {
	
	public static SandBox addSandBoxes(SandBox sb1, SandBox sb2) {
		SandBox retVal = new SandBox(sb1.getSize());
		
		for(int i = 0; i < sb1.getSize(); i ++) {
			for(int ii = 0; ii < sb1.getSize(); ii ++) {
				int total = sb1.getSandAt(i, ii) + sb2.getSandAt(i, ii);
				retVal.setSand(i, ii, total);
			}
		}
		
		retVal.toppleAll();
		
		return retVal;
	}
	
}
