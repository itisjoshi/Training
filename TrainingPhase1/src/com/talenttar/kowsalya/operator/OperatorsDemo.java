package com.talenttar.kowsalya.operator;

import java.io.DataInputStream;
import java.io.IOException;

public class OperatorsDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NumberFormatException, IOException
	{
	int a, b;
	DataInputStream in = new DataInputStream(System.in);
	a = Integer.parseInt(in.readLine());
	b = Integer.parseInt(in.readLine());
	String joshi = in.readLine();
	System.out.print(joshi);
	Arithmatic arithmatic=new Arithmatic();
	arithmatic.performOperation(a,b);
	arithmatic.print();
	Bitwise bitwise=new Bitwise();
	bitwise.performOperation(a,b);
	Logical logical=new Logical();
	logical.performOperation(a,b);
	Relational relational=new Relational();
	relational.performOperation(a,b);
	Shifting shifting=new Shifting();
	shifting.performOperation(a,b);
	Ternary ternary=new Ternary();
	ternary.performOperation(a,b);
	}
}
