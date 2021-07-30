package com.javatrain.Day4;
import java.util.ArrayList;
import java.util.Collections;
// Shuffle ArrayList

public class ShuffleArrayList {

	public ArrayList<String> shuffleArrayList(ArrayList<String> aL) {
		Collections.shuffle(aL);
		return aL;
	}
	
	public String toString(ArrayList<String> aL) {
		String colors = "";
		
		for(String color:aL) {
			colors += color + " ";
		}
		return colors;
	}
}
