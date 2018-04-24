package com.example.accessrules;

public class Container {

	class RootClass{
		
		private int privateRootField = 1;
		protected int protectedRootField = 1;
		public int publicRootField = 1;
		
		
		private void privateRootMethod(){
			System.out.println("privateRootMethod");
		}
		protected void protectedRootMethod(){
			System.out.println("protectedRootMethod");
		}
		public void publicRootMethod(){
			System.out.println("publicRootMethod");
		}
		
		@Override
		public String toString() {
			return "Root [privateRootField=" + privateRootField
					+ ", protectedRootField=" + protectedRootField
					+ ", publicRootField=" + publicRootField + "]";
		}

	}
	
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
					+ super.privateRootField + "super.protectedRootField=" 
					+ super.protectedRootField + "super.publicRootField=" 
					+ super.publicRootField;
		}
		
	}
	
	class SubClassWithoutFields extends RootClass {

		@Override
		public String toString() {
			return "SubClassWithoutFields [protectedRootField="
					+ protectedRootField + ", publicRootField="
					+ publicRootField + "]";
		}
		
		public String getSuperPrivateFieldWithSuperKeyWord(){
			return "superPrivateField=" + super.privateRootField;
		}

	}
}
