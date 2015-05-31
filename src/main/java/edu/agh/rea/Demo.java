package edu.agh.rea;

import edu.agh.rea.testimonies.Testimony;
import edu.agh.rea.testimonies.TestimonyDatabase;

public class Demo {

	public static void main(String[] args) {
		// Get testimony database for this case
		TestimonyDatabase database = TestimonyDatabase
				.getInstance("Car Accident #1");

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
						+ "perpetrator car brand WAW NW22;"
						+ "victim car color red;" + "victim car brand toyota"));

		// Process testimonies to create their representations in descriptors
		// model

		// Testimonies analysis

		// Print report
	}

}
