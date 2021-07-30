package com.javatrain.Day4;
import java.util.ArrayList;

// 9. Copy ArrayList into another

public class CopyArrayListIntoAnother {
	public ArrayList<String> copyArrayList(ArrayList<String> src) {
		ArrayList<String> tgt = (ArrayList) src;
		return tgt;
	}
	
	public String toString(ArrayList<String> aL) {
		String colors = "";
		
		for(String color:aL) {
			colors += color + " ";
		}
		return colors;
	}
}
