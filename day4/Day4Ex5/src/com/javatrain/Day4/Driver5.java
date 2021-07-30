package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> aL = new ArrayList<String>();
		
		// Populate ArrayList
		aL.add("deep red");
		aL.add("deep purple");
		aL.add("deep orange");
		aL.add("deep grey");
		aL.add("deep green");
		
		System.out.println("Array list: " + aL.toString());
		UpdateItemAtIndex update = new UpdateItemAtIndex(aL);
		aL = update.updateItemAtIndex(0, "deep crimson");
		
		System.out.println("Updated list: " + update.toString());
	}

}
