package com.javatrain.Day4;
import java.util.ArrayList;
import java.util.List;
// SubList ArrayList

public class GetSubListFromArrayList {

	public ArrayList<String> getSubListFromArrayList(ArrayList<String> aL) {
		return new ArrayList<String>(aL.subList(2, 5));
	}
	
	public String toString(ArrayList<String> aL) {
		String colors = "";
		
		for(String color:aL) {
			colors += color + " ";
		}
		return colors;
	}
}
