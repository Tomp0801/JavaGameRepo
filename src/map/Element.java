package map;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;



public class Element {
	Map<Point,Block> blocks = new HashMap<Point,Block>();
	
	public void place(Point P,String type,Color c) {
		blocks.put(P,new Block(type,P,c));
	}
	
	
	void test(HashMap<Point,HashMap<String,Float>> startoffs) {
		
		if (startoffs.size()==0) {
			return;
		}
	
		HashMap<Point,Block> runningBlocks = new HashMap<Point,Block>();
		
		for (Point point : startoffs.keySet()) {
			runningBlocks.put(point, blocks.get(point));
			runningBlocks.get(point).addInput(startoffs.get(point));
		}
		
		
		while (true) {
			
			for (Point point : runningBlocks.keySet()) {
				HashMap<Point,HashMap<String,Float>> receivedOutput = runningBlocks.get(point).run();
				for (Point passOn : receivedOutput.keySet()) {
					if (blocks.get(passOn)!=null) {
						runningBlocks.put(passOn,blocks.get(passOn));
						runningBlocks.get(passOn).addInput(receivedOutput.get(passOn));
					}
				}
				runningBlocks.remove(point);
			}
			
			
			
		}
	}
	
	
	void toBlock() {
		
	}
	
}
