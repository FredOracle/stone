package com.example.demo.business;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("returnInTry:   " + Test.returnInTry());
		System.out.println("returnInFinally:   " + Test.returnInFinally());
		System.out.println("returnInEndLine:   " + Test.returnInEndLine());


//		 JDKInterface.showMessage();
//		 SubClass subClass1 = new SubClass();
//		 SubClass subClass2 = new SubClass();
//		 System.out.println(subClass1.i);
//		 System.out.println(subClass2.i);
//		 System.out.println(subClass1.j);
//		 System.out.println(subClass2.j);
//
//		//
//		 String aString = "hello2";
//		 final String bString = "hello";
//		 String dString = "hello";
//		 String cString = bString + "2";
//		 String eString = dString + "2";
//		 System.out.println(aString == cString);
//		 System.out.println(aString == eString);
//		 System.out.println(aString + "======a======" +
//		 System.identityHashCode(aString.hashCode()));
//		 System.out.println(cString + "=====c=======" +
//		 System.identityHashCode(cString.hashCode()));
//		 System.out.println(eString + "======e======" +
//		 System.identityHashCode(eString.hashCode()));
//		 System.out.println(bString + "======b======" +
//		 System.identityHashCode(bString.hashCode()));
//		 System.out.println(dString + "======d======" +
//		 System.identityHashCode(dString.hashCode()));
//
//		 System.out.println(aString.equals(cString));
//		 System.out.println(aString.equals(eString));
//
//		MyClass myClass = new MyClass();
//		final Integer i = 10;
//		myClass.changeValue(i);
//		System.out.println(i);

	}

	public static String returnInTry (){
		String a = "Fred";
		try {
			a = "Good";
			return a;
		} catch ( Exception e) {
			a = "MBB";
			e.printStackTrace();
		} finally {
			a = "Hello";
//			return a;
		}
		return a;
	}

	public static String returnInFinally (){
		String a = "Fred";
		try {
			a = "Good";
			return a;
		} catch ( Exception e) {
			a = "MBB";
			e.printStackTrace();
		} finally {
			a = "Hello";
			return a;
		}
//		return a;
	}

	public static String returnInEndLine (){
		String a = "Fred";
		try {
			a = "Good";
			return a;
		} catch ( Exception e) {
			a = "MBB";
			e.printStackTrace();
		} finally {
			a = "Hello";
//			return a;
		}
		return a;
	}










}

class MyClass {
	Integer changeValue( Integer value) {
		value = 3;
		value= value + 10;
		return value;
	}
}
