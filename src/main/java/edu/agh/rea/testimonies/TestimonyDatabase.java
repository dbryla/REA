package edu.agh.rea.testimonies;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class TestimonyDatabase {

	private static final HashMap<String, TestimonyDatabase> databases = new HashMap<String, TestimonyDatabase>();
	private String caseName;
	private LinkedList<Testimony> testimonies = new LinkedList<Testimony>();

	private TestimonyDatabase(String caseName) {
		this.caseName = caseName;
	}

	public static TestimonyDatabase getInstance(String caseName) {
		if (databases.containsKey(caseName)) {
			return databases.get(caseName);
		} else {
			TestimonyDatabase instance = new TestimonyDatabase(caseName);
			databases.put(caseName, instance);
			return instance;
		}
	}

	public List<Testimony> getTestimonies() {
		return Collections.unmodifiableList(testimonies);
	}

	public void addTestimony(Testimony testimony) {
		testimonies.add(testimony);
	}

	public String getCaseName() {
		return caseName;
	}

    public void printTestimonies() {
        testimonies.forEach(x -> {
            System.out.println("Testimony by " + x.getAuthor() + ", parsed content:");
            Arrays.asList(x.getContent().split(";")).forEach(s -> System.out.println("\t" + s));
        });
    }
}
