package edu.agh.rea;

import java.util.List;

import edu.agh.rea.descriptors.Event;
import edu.agh.rea.logic.Analysis;
import edu.agh.rea.logic.ResultTree;
import edu.agh.rea.logic.SimpleParser;
import edu.agh.rea.report.SimplePrinter;
import edu.agh.rea.testimonies.Testimony;
import edu.agh.rea.testimonies.TestimonyDatabase;

public class Demo {

	private static final String CAR_ACCIDENT_1 = "Car Accident #1";

	public static void main(String[] args) {
		// Get testimony database for this case
		TestimonyDatabase database = TestimonyDatabase
				.getInstance(CAR_ACCIDENT_1);

		// Add sample testimonies in format in which they will be send from UI
		database.addTestimony(new Testimony("Adam Firc",
				"participantsNumber 2;" + "weather sunny;"
						+ "place corner st Mickiewicza and st Lukasiewskiego;"
						+ "datetime 04.05.14 15:04;"
						+ "perpetrator car color red;"
						+ "perpetrator car plates CTU 2K34;"
						+ "victim car color blue;"));
		database.addTestimony(new Testimony("Bozena Polak",
				"participantsNumber 2;" + "place st Mickiewicza;"
						+ "datetime 04.05.14 15;"
						+ "perpetrator car color red;"
						+ "perpetrator car brand toyota;"
						+ "victim car plates WAW NW22;"
						+ "victim car color blue;" + "victim car brand opel"));
		database.addTestimony(new Testimony("Bogdan Wojtek",
				"datetime 04.05.14;" + "perpetrator car color blue;"
						+ "perpetrator car brand opel;"
						+ "perpetrator car plates WAW NW22;"
						+ "victim car color red;" + "victim car brand toyota"));
		

		// Process testimonies to create their representations in descriptors
		// model
		List<Event> eventsVersions = new SimpleParser().convert(CAR_ACCIDENT_1);

		// Testimonies analysis

		ResultTree resultTree = new Analysis().buildTree(eventsVersions);
		
		// Print report
		
		new SimplePrinter().execute(resultTree, CAR_ACCIDENT_1); 
	}

}
