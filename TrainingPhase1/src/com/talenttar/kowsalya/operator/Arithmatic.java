package com.talenttar.kowsalya.operator;

public class Arithmatic extends A implements Operator{

	@Override
	public void performOperation(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("***ARITHMATIC OPERATORS***");
	 int c = a+b;
	try{	System.out.println(c);
		c=a-b;
		System.out.println(c);
		c=a*b;
		System.out.println(c);
		c=a/b;
		System.out.println(c);
		}
	catch(ArithmeticException ex){
		System.out.print("Aruthmetic exception handled"+ex.getMessage());
	}
	catch(ArrayIndexOutOfBoundsException e){
		System.out.print("Array exception handled");		
	}
	catch(Exception e){
		System.out.print("exception handled");
	}
	finally{
		System.out.println("Kowsalya joshi");
	}
	}
	@Override
	void print() {
		// TODO Auto-generated method stub
			System.out.println("New year");
	}
}
