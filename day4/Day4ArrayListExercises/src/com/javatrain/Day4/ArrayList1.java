package com.javatrain.Day4;
import java.util.ArrayList; 
//import java.util.Iterator;

public class ArrayList1 {
	ArrayList colorList;
	
	public ArrayList1(ArrayList<String> aL) {
		
		this.colorList = (ArrayList) aL.clone();
		
	}
	
	public String toString() {
		return this.colorList.get(0) + " " + this.colorList.get(1) 
			+ " " + this.colorList.get(2)
			+ " " + this.colorList.get(3) + " " + this.colorList.get(4);
	}
}