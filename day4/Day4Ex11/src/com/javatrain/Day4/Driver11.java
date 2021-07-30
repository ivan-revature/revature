package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		
		ReverseArrayList reverse = new ReverseArrayList();
		System.out.println("Array list: " + reverse.toString(arrayList));
		arrayList = reverse.shuffleArrayList(arrayList);
		System.out.println("Reversed array list: " + reverse.toString(arrayList));
	}

}
