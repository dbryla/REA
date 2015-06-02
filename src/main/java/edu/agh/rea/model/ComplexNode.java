package edu.agh.rea.model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class ComplexNode implements Node {

    private HashMap<String, Node> map = new HashMap<String, Node>();
    private String key;

    public ComplexNode(String key) {
        this.key = key;
    }

    public ComplexNode() {
    }

    public Node set(String key, String value, boolean isSimple) {
        if (isSimple || !map.containsKey(key)) {
            String nodeKey = this.key != null ? key : ""; 
            Node node = isSimple ? new SimpleNode(nodeKey, value) : new ComplexNode(key);
            map.put(key, node);
            return node;
        }
        return map.get(key);
    }

    public Set<Entry<String, Node>> getBranches() {
        return map.entrySet();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        map.entrySet().forEach(sb::append);
        return sb.toString();
    }

}
