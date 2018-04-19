package com.example.couchdb.utility;

import java.util.Map;

public abstract class DisplayHelper {
	
	public static void showDocument(Map map){
		System.out.println("------------ Displaying map ---------------");
		for (Object id : map.keySet()) {
			System.out.println(id + ": " + map.get(id));
		}
		System.out.println("---------------------------------");
	}
	
}
