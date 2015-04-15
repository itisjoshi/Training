package com.talenttar.kowsalya.operator;

public class Relational implements Operator {

	@Override
	public void performOperation(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("***RELATIONAL OPERATORS***");
		if(a>b)
		{
			System.out.println("a is greater than b");
		}
		else{
			System.out.println("b is greater than a");
		}
	}

}
