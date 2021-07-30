package com.javatrain.Day4;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RetrieveItemAtIndex {
	ArrayList<String> colorList;
	
	public RetrieveItemAtIndex(ArrayList<String> aL) {
		this.colorList = (ArrayList) aL;
	}
	
	public String retrieveItemAtIndex(int index) {
		return this.colorList.get(index);
	}
	
	public String toString() {
		String colors = "";
		
		for(String color:this.colorList) {
			colors += color + " ";
		}
		return colors;
	}
}
