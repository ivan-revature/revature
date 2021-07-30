package com.javatrain.Day4;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

//import java.util.Iterator;

public class InsertAtZeroArrayList {
	ArrayList<String> colorList = new ArrayList<String>();
	
	public InsertAtZeroArrayList(ArrayList<String> lst) {
		for(int i = 0; i<lst.size(); i++)
			this.colorList.add(lst.get(i));
	}
	
	public String toString() {
		String colors = "";
		
		for(String color:this.colorList) {
			colors += color + " ";
		}
		return colors;
	}
	
	public ArrayList<String> insertAtZero(String color) {
		this.colorList.add(0, color);
		return this.colorList;
	}
}
