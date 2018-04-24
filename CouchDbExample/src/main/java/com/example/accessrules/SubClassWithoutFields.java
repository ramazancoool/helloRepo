package com.example.accessrules;

class SubClassWithoutFields extends RootClass {

	@Override
	public String toString() {
		return "SubClassWithoutFields [protectedRootField="
				+ protectedRootField + ", publicRootField="
				+ publicRootField + "]";
	}
	
	public String getSuperPrivateFieldWithSuperKeyWord(){
		return "";
//		return "superPrivateField=" + super.privateRootField;
	}

}