import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.lightcouch.Changes;
import org.lightcouch.ChangesResult;
import org.lightcouch.CouchDbClient;
import org.lightcouch.ReplicationResult;
import org.lightcouch.Response;

public class LightCouch {
	
	public void x() throws IOException{
		CouchDbClient dbClient = new CouchDbClient(); 

		Foo foo = new Foo(); // Plain Java Object

		Response dbClientResponse = dbClient.save(foo);

		foo = dbClient.find(Foo.class, "doc-id");

		dbClient.update(foo);

		dbClient.remove(foo);

		boolean b = dbClient.contains("doc-id");

		// views
		List<Foo> list = dbClient.view("ddoc/by_date")
		 	.key("key")
		 	.includeDocs(true)
		 	.query(Foo.class);
		 	
		long count = dbClient.view("ddoc/by_tag")
		    .key("couchdb").queryForLong(); 

//		InputStream inputStream = null;
//		// attachments
//		Response response = dbClient.saveAttachment(inputStream , "photo.png", "image/png");
//		InputStream in = dbClient.find("doc-id/photo.png");
//		in.close();

		// replication
		ReplicationResult replication = dbClient.replication()
			.source("source-db").target("target-db")
			.createTarget(true)
			.trigger();

		// changes feed
		Changes changes = dbClient.changes()
			.includeDocs(true)
			.heartBeat(30000)
			.continuousChanges();

		while (changes.hasNext()) {
			ChangesResult.Row feed = changes.next();
		}		 	

		// shutdown the client
		dbClient.shutdown(); 
	}

}
