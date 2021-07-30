package com.javatrain.Day4;
import java.util.ArrayList;

public class UpdateItemAtIndex {
	ArrayList<String> colorList;
	
	public UpdateItemAtIndex(ArrayList<String> aL) {
		this.colorList = (ArrayList) aL;
	}
	
	public ArrayList<String> updateItemAtIndex(int index, String updateItem) {
		this.colorList.set(index, updateItem);
		return this.colorList;
	}
	
	public String toString() {
		String colors = "";
		
		for(String color:this.colorList) {
			colors += color + " ";
		}
		return colors;
	}
}
