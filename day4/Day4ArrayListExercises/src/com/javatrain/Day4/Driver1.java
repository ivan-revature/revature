package com.javatrain.Day4;
import java.util.ArrayList;

public class Driver1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> arrLst = new ArrayList<String>();
		arrLst.add("blue");
		arrLst.add("red");
		arrLst.add("yellow"); 
		arrLst.add("green");
		arrLst.add("grey");
	
		ArrayList1 arrayLst = new ArrayList1(arrLst);
		System.out.println("arrayLst: " + arrayLst.toString());
	}

}
