package edu.agh.rea.report;

import java.util.TreeSet;

import edu.agh.rea.model.ResultTree;
import edu.agh.rea.testimonies.TestimonyDatabase;


public class SimplePrinter {

	public void execute(ResultTree resultTree, String caseName) {
	    int testimoniesCounter = TestimonyDatabase.getInstance(caseName).getTestimonies().size();
		System.out.println("Report for case: " + caseName);
		resultTree.entrySet().forEach(edge -> {
			System.out.println(edge.getKey() + ": ");
			TreeSet<Object> set = new TreeSet<Object>(edge.getValue().keySet());
			set.forEach(fact -> {
				System.out.println("\t" + fact + " : " + (edge.getValue().get(fact) * 100)/testimoniesCounter + "%");
			});
		});
		
	}

}
