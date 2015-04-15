package com.talenttar.kowsalya.operator;

public class Bitwise implements Operator {

	@Override
	public void performOperation(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("***BITWISE OPERATORS***");
		int c=a|b;
		System.out.println(c);
		c=a&b;
		System.out.println(c);
		c=a^b;
		System.out.println(c);
				
	}

}
