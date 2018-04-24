package com.example.accessrules;

class SubClass extends RootClass{
	private int privateRootField = 2;
	protected int protectedRootField = 2;
	public int publicRootField = 2;
	
	@Override
	public String toString() {
		return "SubClass [privateRootField="
				+ privateRootField + ", protectedRootField="
				+ protectedRootField + ", publicRootField="
				+ publicRootField + "]" + ",super.privateRootField="
//				+ super.privateRootField + "super.protectedRootField=" 
				+ super.protectedRootField + "super.publicRootField=" 
				+ super.publicRootField;
	}
	
}