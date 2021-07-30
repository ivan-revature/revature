package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		SortArrayList sort = new SortArrayList();
		System.out.println(sort.toString(arrayList));
		arrayList = sort.sortArrLstltem(arrayList);
		System.out.println("Sorted array list: " + sort.toString(arrayList));
	}

}
