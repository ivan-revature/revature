package com.javatrain.Day4;
import java.util.ArrayList;

public class SearchForArrayListItem {
	public SearchForArrayListItem() {
		
	}
	
	public boolean searchForArrayListItem(ArrayList<String> aL, String target) {
		boolean exists = false;
		if( aL.contains(target) )
			exists = true;
		else
			exists = false;
		return exists;
	}
	
	public String toString(ArrayList<String> aL) {
		String colors = "";
		
		for(String color:aL) {
			colors += color + " ";
		}
		return colors;
	}
}
