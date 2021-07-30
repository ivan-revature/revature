package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		
		ShuffleArrayList shuffle = new ShuffleArrayList();
		System.out.println("Array list: " + shuffle.toString(arrayList));
		arrayList = shuffle.shuffleArrayList(arrayList);
		System.out.println("Shuffled array list: " + shuffle.toString(arrayList));
	}

}
