package com.javatrain.Day4;
import java.util.ArrayList; 
import java.util.Iterator;

// 2. Write a Java program to iterate through all elements in a array list.
public class IterateArrayList {
	ArrayList colorList;
	
	public IterateArrayList(ArrayList<String> aL) {
		
		this.colorList = (ArrayList) aL.clone();
	}
	
	public String toString() {
		String colors = "";
		Iterator iterator = this.colorList.iterator();
		
		while( iterator.hasNext() ) {
			colors += iterator.next() + " ";
		}
		//for(String color: this.colorList) {
			
		//}
		return colors;
	}
}
