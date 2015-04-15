package com.talenttar.kowsalya.operator;

public class Ternary implements Operator {

	@Override
	public void performOperation(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("***TERNARY OPERATORS***");
		int c;
		c=(a>b)?a:b;
		System.out.println(c);
	}

}
