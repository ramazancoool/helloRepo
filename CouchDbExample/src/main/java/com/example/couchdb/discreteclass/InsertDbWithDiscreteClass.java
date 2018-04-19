package com.example.couchdb.discreteclass;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import com.example.couchdb.constant.ICouchDbConstants;
import com.example.couchdb.entity.Sofa;
import com.example.couchdb.utility.DisplayHelper;

/**
 * Hello world!
 *
 */
public class InsertDbWithDiscreteClass {
	public static void main(String[] args) throws MalformedURLException {

		HttpClient httpClient = new StdHttpClient.Builder()
				.url(ICouchDbConstants.HOST_ADDRESS_OF_DB)
				.username(ICouchDbConstants.USERNAME_OF_DB)
				.password(ICouchDbConstants.PASSWORD_OF_DB).build();

		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it
		// doesn't exists
		CouchDbConnector dbConnector = dbInstance.createConnector(
				ICouchDbConstants.DATABASE_NAME_MY_FIRST_DB, true);
		
		dbConnector.createDatabaseIfNotExists();
		
		Map<String, Object> map;
		
		map = dbConnector.find(Map.class, ICouchDbConstants.ID_REFERENCE_EKTORP);
		
		if(map != null){
			dbConnector.delete(map);
		}
		
		map = new HashMap<String, Object>();
		map.put("_id", ICouchDbConstants.ID_REFERENCE_EKTORP);
		dbConnector.create(map );
		
		map = dbConnector.find(Map.class, ICouchDbConstants.ID_REFERENCE_EKTORP); 
		DisplayHelper.showDocument(map);
		
		Sofa sofa = dbConnector.get(Sofa.class, ICouchDbConstants.ID_REFERENCE_EKTORP);
		sofa.setColor("blue");
		sofa.setAmount(150.0);
		dbConnector.update(sofa);
		
		System.out.println("--- updated color, amount -----\n");
		
		map = dbConnector.find(Map.class, ICouchDbConstants.ID_REFERENCE_EKTORP); 
		DisplayHelper.showDocument(map);
	}
}