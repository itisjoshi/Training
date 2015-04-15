package com.talenttar.kowsalya.userException;

import java.io.DataInputStream;
import java.io.IOException;

public class LifeException {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int a,b;
		DataInputStream dataInputStream = new DataInputStream(System.in);
		a = dataInputStream.readInt();
		b = dataInputStream.readInt();
		try{
			if(a>b){
				throw new MyException();
			}
		}
		catch(MyException e){
			System.out.print("ExceptionHNDL"+e.getMessage());
		}
	}

}
