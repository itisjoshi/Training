package com.talenttar.kowsalya.operator;

public class Logical implements Operator {

	@Override
	public void performOperation(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("**LOGICAL OPERATORD***");
		if(a!=0&&b!=0)
		{
			System.out.println("Both are not equal to zero");
		}
		else if(a>0||b>0)
		{
			System.out.println(" one of the variable is greater than zero");
		}
		else
		{
			System.out.println("Both are greater than zero");
		}
		}
	}
	
