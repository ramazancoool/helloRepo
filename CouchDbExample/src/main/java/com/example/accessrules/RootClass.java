package com.example.accessrules;

class RootClass{
	
	private int privateRootField = 1;
	protected int protectedRootField = 1;
	public int publicRootField = 1;
	
	
	private void privateRootMethod(){
		System.out.println("privateRootMethod");
	}
	private void protectedRootMethod(){
		System.out.println("protectedRootMethod");
	}
	private void publicRootMethod(){
		System.out.println("publicRootMethod");
	}
	
	@Override
	public String toString() {
		return "Root [privateRootField=" + privateRootField
				+ ", protectedRootField=" + protectedRootField
				+ ", publicRootField=" + publicRootField + "]";
	}

}