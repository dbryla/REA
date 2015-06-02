package edu.agh.rea.logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import edu.agh.rea.descriptors.Car;
import edu.agh.rea.descriptors.Event;
import edu.agh.rea.descriptors.ObjectFactory;
import edu.agh.rea.descriptors.Person;
import edu.agh.rea.testimonies.TestimonyDatabase;

public class SimpleParser {

	public List<Event> convert(String caseName) {
		TestimonyDatabase database = TestimonyDatabase.getInstance(caseName);
		List<Event> eventList = new LinkedList<Event>();
		ObjectFactory objectFactory = new ObjectFactory();
		database.getTestimonies().forEach(testimony -> {
			Car victimCar = objectFactory.createCar();
			Car perpetratorCar = objectFactory.createCar();
			Event event = objectFactory.createEvent();
			Person victim = objectFactory.createPerson();
			Person perpetrator = objectFactory.createPerson();

			Arrays.asList(testimony.getContent().split(";")).forEach(fact -> {

				List<String> elements = Arrays.asList(fact.split(" "));
				switch (elements.get(0)) {
				case "participantsNumber":
					event.setParticipantsNumber(new Integer(elements.get(1)));
					break;

				case "weather":
					event.setWeather(elements.get(1));
					break;

				case "place":
					
					
					event.setPlace(getRestOfElements(elements.listIterator(1)));
					break;

				case "datetime":
					event.setDateTime(elements.get(1));
					break;

				case "perpetrator":

					switch (elements.get(2)) {
					case "color":
						perpetratorCar.setColor(elements.get(3));
						break;
					case "plates":
						perpetratorCar.setPlates(getRestOfElements(elements.listIterator(3)));
						break;

					case "brand":
						perpetratorCar.setBrand(getRestOfElements(elements.listIterator(3)));
						break;

					default:
						break;
					}

					break;

				case "victim":
					switch (elements.get(2)) {
					case "color":
						victimCar.setColor(elements.get(3));
						break;
						
					case "plates":
						victimCar.setPlates(getRestOfElements(elements.listIterator(3)));
						break;

					case "brand":
						victimCar.setBrand(getRestOfElements(elements.listIterator(3)));
						break;
					default:
						break;
					}
					break;

				default:
					break;
				}

			});

			victim.setCar(victimCar);
			perpetrator.setCar(perpetratorCar);
			event.setVictim(victim);
			event.setPerpetrator(perpetrator);
			eventList.add(event);
		});

		return eventList;
	}
	
	private String getRestOfElements(ListIterator<String> listIterator){
		StringBuilder stringBuilder = new StringBuilder();
		listIterator.forEachRemaining(it ->
			stringBuilder.append(it).append(" ")
		);
		return stringBuilder.toString();
	}
}
