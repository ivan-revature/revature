package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> aL = new ArrayList<String>();
		
		// Populate ArrayList
		aL.add("deep red");
		aL.add("deep purple");
		aL.add("deep orange");
		aL.add("deep grey");
		aL.add("deep green");
		
		RetrieveItemAtIndex retrieve = new RetrieveItemAtIndex(aL);
		System.out.println(retrieve.toString());
		System.out.println("Item at pos 2 is: " 
				+ retrieve.retrieveItemAtIndex(2));
		System.out.println("Item at pos 4 is: "
				+ retrieve.retrieveItemAtIndex(4));
	}

}
