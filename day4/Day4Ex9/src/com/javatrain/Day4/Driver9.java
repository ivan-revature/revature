package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Populate ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("deep red");
		arrayList.add("deep purple");
		arrayList.add("deep orange");
		arrayList.add("deep grey");
		arrayList.add("deep green");
		
		CopyArrayListIntoAnother copy = new CopyArrayListIntoAnother();
		System.out.println("Array list: " + copy.toString(arrayList));
		ArrayList<String> anotherArrLst = copy.copyArrayList(arrayList);
		System.out.println("Another array list: " + copy.toString(anotherArrLst));
	}

}
