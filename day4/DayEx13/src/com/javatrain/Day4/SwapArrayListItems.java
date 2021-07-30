package com.javatrain.Day4;
import java.util.ArrayList;
import java.util.Collections;

public class SwapArrayListItems {
	public ArrayList<String> swapArrayListItems(ArrayList<String> aL, int index1, int index2) {
		Collections.swap(aL, index1, index2);
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
