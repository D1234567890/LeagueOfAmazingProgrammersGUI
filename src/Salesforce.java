import java.util.ArrayList;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class Salesforce {

	public static ArrayList<Level> getStudents() {

		ArrayList<Level> levels = new ArrayList<>();
		levels.add(new Level((byte) 0));
		levels.add(new Level((byte) 1));
		levels.add(new Level((byte) 2));
		levels.add(new Level((byte) 3));
		levels.add(new Level((byte) 4));
		levels.add(new Level((byte) 5));
		levels.add(new Level((byte) 6));
		levels.add(new Level((byte) 7));
		levels.add(new Level((byte) 8));
		levels.add(new Level((byte) 9));

		// Connect to SalesForce

		ConnectorConfig config = new ConnectorConfig();
		config.setUsername("leaguebot@jointheleague.org");
		config.setPassword("bot4league7oimRp2FyjBs5tddyYtVrvkLhm");
		config.setTraceMessage(false);

		try {

			EnterpriseConnection connection = Connector.newConnection(config);
			QueryResult queryResults = connection.query(
					"SELECT FirstName, LastName, Last_Class_Level__c, Home_Location_Code__c FROM Contact WHERE Last_Class_Level__c != null AND Last_Class_Level__c != '?' AND Last_Class_Level__c != 'O'");

			System.out.println("Query Complete");

			SObject[] s = queryResults.getRecords();

			System.out.println("Length: " + s.length);

			if (queryResults.getSize() > 0) {

				String studentName;
				String studentLocation;

				byte studentLevel;

				for (int i = 0; i < s.length; i++) {
					Contact c = (Contact) s[i];
					studentName = c.getFirstName() + " " + c.getLastName();
					studentLevel = Byte.parseByte(c.getLast_Class_Level__c());

					if (c.getHome_Location_Code__c().equals("UNKNOWN")) {
						studentLocation = "CV";
					} else {
						studentLocation = c.getHome_Location_Code__c();
						levels.get(studentLevel).addStudent(new Student(studentName, studentLocation, studentLevel));
					}
				}
			}
		} catch (ConnectionException e1) {
			System.out.println("Failed to connect\n");
			e1.printStackTrace();
		}

		return levels;
	}
}