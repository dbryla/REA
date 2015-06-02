package edu.agh.rea.logic;

import java.util.List;

import edu.agh.rea.model.ComplexNode;
import edu.agh.rea.model.Node;
import edu.agh.rea.model.ResultTree;

public class Analysis {

    public ResultTree buildTree(List<ComplexNode> eventsVersions) {
        ResultTree resultTree = new ResultTree();
        eventsVersions.forEach(event -> 
            event.getBranches().forEach(branch -> {
                String edge = branch.getKey();
                Node node = branch.getValue();
                if (!resultTree.contains(edge)) {
                    resultTree.add(edge);
                }
                resultTree.addAttribute(edge, node);
            })
        );
        return resultTree;
    }
}
