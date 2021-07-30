package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		SearchForArrayListItem search = new SearchForArrayListItem();
		if( search.searchForArrayListItem(arrayList, "deep black") ) 
			System.out.println("Item \"deep black\" exists!");
		else
			System.out.println("Item \"deep black\" does NOT exist.");
		
		System.out.println("Array list: " + search.toString(arrayList));
		if( search.searchForArrayListItem(arrayList, "deep green") ) 
			System.out.println("Item \"deep green\" exists!");
		else
			System.out.println("Item \"deep green\" does NOT exist.");
	}
	
	

}
