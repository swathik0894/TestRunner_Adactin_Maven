package com.datadriven;

public class Reverse_String {
	
	private static void Reverse() {
		String s="Welcome";
		char ch[]=s.toCharArray();
		String reverse="";
		for(int i=ch.length-1; i>=0; i--) {
			reverse=reverse+ch[i];
		}
		System.out.println(reverse);

	}
	
	public static void main(String[] args) {
		Reverse();
		
	}

}
