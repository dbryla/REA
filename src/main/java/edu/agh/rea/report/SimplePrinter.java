package edu.agh.rea.report;

import edu.agh.rea.logic.ResultTree;

public class SimplePrinter {

	public void execute(ResultTree resultTree, String caseName) {
		System.out.println("Report for case: " + caseName);
		resultTree.entrySet().forEach(edge -> {
			System.out.println(edge.getKey() + ": ");
			edge.getValue().forEach((fact, counter) -> {
				System.out.println("\t" + fact + " : " + counter);
			});
		});
		
	}

}
