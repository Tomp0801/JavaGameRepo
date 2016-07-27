package map;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;


public class Block {
	String category;
	String type;
	HashMap<String,String> sides = new HashMap<String,String>();
	Point position;
	Color color;
	
	
	Block(String t,Point P,Color c) {
		position = P;
		type = t;
		color = c;
		
		sides.put("left","input");
		sides.put("right","output");
		sides.put("top","input");
		sides.put("bottom","output");
	}
	
	
	HashMap<String,Float> input = new HashMap<String,Float>();
	HashMap<String,Float> neededInput = new HashMap<String,Float>();
	HashMap<String,Float> output = new HashMap<String,Float>();
	HashMap<String,Float> expectedOutput = new HashMap<String,Float>();
	


//	void setInput(String side,String type,Float value) {
//		input.put(type, value);
//	}
//	
//	void setOutput(String side,String type,Float value) {
//		output.put(type, value);
//	}
	
	
	void redirect(String side,String inOut) {
		sides.put(side,inOut);
	}
	
	
	
	//RUN block
	HashMap<Point,HashMap<String,Float>> run() {
		
		Boolean positive = true;
		for (String key : input.keySet()) {
			if (input.get(key)!=neededInput.get(key)) {
				positive = false;
				break;
			}
		}
		
		HashMap<Point,HashMap<String,Float>> passedOutput = new HashMap<Point,HashMap<String,Float>>();

		
		if (positive==false){
			output = expectedOutput;
			
			if (sides.get("left")=="output") {
				passedOutput.put(new Point(position.x-1,position.y),output);
			}
			if (sides.get("top")=="output") {
				passedOutput.put(new Point(position.x,position.y-1),output);
			}
			if (sides.get("right")=="output") {
				passedOutput.put(new Point(position.x+1,position.y),output);
			}
			if (sides.get("bottom")=="output") {
				passedOutput.put(new Point(position.x,position.y+1),output);
			}
			
		}
		
		return passedOutput;
		
	}
	
	void addInput(HashMap<String,Float> receivedInput) {
		for (String type : receivedInput.keySet()) {
			input.put(type, input.get(type) + receivedInput.get(type));
		}
	}
	

}
