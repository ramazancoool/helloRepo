package com.cloudant;

import java.util.List;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;

public class HelloCloudant {

	public static void main(String[] args) {
		CloudantClient client = ClientBuilder.account("af848a33-f373-4bf8-95d9-5aa5b185dd3c-bluemix")
                .username("af848a33-f373-4bf8-95d9-5aa5b185dd3c-bluemix")
                .password("729139fb685cdfac7b2fc7a2bae2fc616f70db2412ad2dfb0f473bcdbabb489d")
                .build();
		
		System.out.println("finish");
		
		List<String> databases = client.getAllDbs();
		System.out.println("All my databases : ");
		for ( String db : databases ) {
			System.out.println(db);
		}
		
//		System.out.println("Server Version: " + client.serverVersion());
	}

}
