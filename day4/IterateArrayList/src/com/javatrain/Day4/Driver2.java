package com.javatrain.Day4;

import java.util.ArrayList;

public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> aL = new ArrayList<String>();
		
		// Populate ArrayList
		aL.add("deep red");
		aL.add("deep purple");
		aL.add("deep orange");
		aL.add("deep grey");
		aL.add("deep green");
		
		IterateArrayList arrLst = new IterateArrayList(aL);
		System.out.println("array list: " + arrLst.toString());
	}

}
