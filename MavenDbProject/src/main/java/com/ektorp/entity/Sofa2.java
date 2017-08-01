package com.ektorp.entity;

import org.ektorp.support.CouchDbDocument;

public class Sofa2 extends CouchDbDocument {

	private static final long serialVersionUID = -5853255677168208975L;
	private String color;
    
    public void setColor(String s) {
            color = s;
    }
    
    public String getColor() {
            return color;
    }
}