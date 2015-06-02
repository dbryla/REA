package edu.agh.rea.logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.agh.rea.model.ComplexNode;
import edu.agh.rea.model.Node;
import edu.agh.rea.testimonies.TestimonyDatabase;

public interface Parser {

    /**
     * Default implementation of converting Testimonies to trees
     * 
     * @param caseName
     *            name of case for which testimonies are saved in database
     * @return list of trees representing testimonies
     */
    default List<ComplexNode> convert(String caseName) {
        TestimonyDatabase database = TestimonyDatabase.getInstance(caseName);
        List<ComplexNode> eventList = new LinkedList<ComplexNode>();
        database.getTestimonies().forEach(testimony -> {
            ComplexNode tree = new ComplexNode();
            Arrays.asList(testimony.getContent().split(";")).forEach(fact -> {
                String[] strings = fact.split("#");
                Node root = tree;
                for (int i = 0; i < strings.length - 1; ++i) {
                    root = root.set(strings[i], strings[i + 1], i == strings.length - 2);
                }
            });
            eventList.add(tree);
        });
        return eventList;
    }

}
