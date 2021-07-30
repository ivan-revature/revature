package com.javatrain.Day4;
import java.util.ArrayList;

public class Remove3rdItemFromArrayList {

	public ArrayList<String> remove3rdltem( ArrayList<String> aL ) { 
		// Remove 3rd item in passed in ArrayList
		aL.remove( 2 ); 
		return aL;
	}
	
	public String printItems(ArrayList<String> aL) {
		String colors = "";
		
		for(String color:aL) {
			colors += color + " ";
		}
		return colors;
	}
}
