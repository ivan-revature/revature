package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		
		GetSubListFromArrayList sublist = new GetSubListFromArrayList();
		System.out.println("Array list: " + sublist.toString(arrayList));
		arrayList = sublist.getSubListFromArrayList(arrayList);
		System.out.println("Sub list from array list: " + sublist.toString(arrayList));
	}

}
