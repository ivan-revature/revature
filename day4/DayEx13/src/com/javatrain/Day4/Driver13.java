package com.javatrain.Day4;

import java.util.ArrayList;

public class Driver13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		SwapArrayListItems swap = new SwapArrayListItems();
		System.out.println("Array list: " + swap.toString(arrayList));
		arrayList = swap.swapArrayListItems(arrayList, 2, 4);
		System.out.println("New array list: " + swap.toString(arrayList));
				
	}

}
