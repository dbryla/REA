package edu.agh.rea.logic;

import java.util.Arrays;
import java.util.List;

import edu.agh.rea.descriptors.Event;

public class Analysis {

	public ResultTree buildTree(List<Event> eventsVersions) {
		ResultTree resultTree = new ResultTree();
		eventsVersions.forEach(event -> {
			Arrays.asList(event.getClass().getMethods()).stream()
					.filter(method -> method.getName().startsWith("get") && !method.getName().equals("getClass"))
					.forEach(method -> {
						try {
							Object returnedValue;
							if ((returnedValue = method.invoke(event)) != null) {
								String key = method.getName().substring(3);
								if (!resultTree.contains(key)) {
									resultTree.add(key);
								}
								resultTree.addAttribute(key, returnedValue);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
		});
		return resultTree;
	}
}
