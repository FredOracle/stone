package com.example.demo.business;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// JDKInterface.showMessage();

		// SubClass subClass1 = new SubClass();
		// SubClass subClass2 = new SubClass();
		//
		// System.out.println(subClass1.i);
		// System.out.println(subClass2.i);
		// System.out.println(subClass1.j);
		// System.out.println(subClass2.j);
		//
		//
		//// subClass.protectString();
		//// subClass.pubFinalString();
		//// subClass.pubString();
		//
		// String aString = "hello2";
		//
		// final String bString = "hello";
		// String dString = "hello";
		//
		// String cString = bString + "2";
		// String eString = dString + "2";
		//
		// System.out.println(aString == cString);
		// System.out.println(aString == eString);
		//
		// System.out.println(aString + "======a======" +
		// System.identityHashCode(aString.hashCode()));
		// System.out.println(cString + "=====c=======" +
		// System.identityHashCode(cString.hashCode()));
		// System.out.println(eString + "======e======" +
		// System.identityHashCode(eString.hashCode()));
		// System.out.println(bString + "======b======" +
		// System.identityHashCode(bString.hashCode()));
		// System.out.println(dString + "======d======" +
		// System.identityHashCode(dString.hashCode()));

		// System.out.println(aString.equals(cString));
		// System.out.println(aString.equals(eString));

		MyClass myClass = new MyClass();
		StringBuffer stringBuffer = new StringBuffer("Hello");
		Integer i = 10;
		myClass.changeValue(i);
		System.out.println(i);

	}

}

class MyClass {
	void changeValue( Integer value) {
		value = 3;
		value= value + 10;
	}
}
