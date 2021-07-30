package com.javatrain.Day4;
import java.util.ArrayList;
//import java.util.List;
import java.util.Collections;

// 8. Write a Java program to sort a given array list.



public class SortArrayList {

	public ArrayList<String> sortArrLstltem(ArrayList<String> aL) { 
		//List<String> list = new ArrayList<String>(); 

		// Update ArrayList aL 
		Collections.sort(aL);
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
