package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colorList = new ArrayList<String>();
		
		// Populate ArrayList
		colorList.add("deep red");
		colorList.add("deep purple");
		colorList.add("deep orange");
		colorList.add("deep grey");
		colorList.add("deep green");
		
		System.out.println("Array list: " + colorList);
		Remove3rdItemFromArrayList remove3rd = new Remove3rdItemFromArrayList();
		colorList = remove3rd.remove3rdltem(colorList);
		System.out.println("Updated array list: " + remove3rd.printItems(colorList));
	}

}
