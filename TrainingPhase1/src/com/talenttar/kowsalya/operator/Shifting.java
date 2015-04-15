package com.talenttar.kowsalya.operator;

public class Shifting implements Operator{

	@Override
	public void performOperation(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("***SHIFTING OPERATORS***");
		int c=a>>1;
		System.out.println(c);
		c=b<<2;
		System.out.println(c);
	}

}
