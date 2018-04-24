package com.example.accessrules;

public class TestAccess {

	public static void main(String[] args) {
		Container.RootClass containerRootRootClass = new Container().new RootClass();
		Container.RootClass containerRootSubClass = new Container().new SubClass();
		Container.SubClass containerSubSubClass = new Container().new SubClass();
		
		Container.SubClassWithoutFields containerSubClassWithoutFields = new Container(). new SubClassWithoutFields();
		
		System.out.println(containerRootSubClass.protectedRootField);
		System.out.println(containerSubSubClass.protectedRootField);
		
	}
	
}
