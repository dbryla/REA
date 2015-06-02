package edu.agh.rea.model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ResultTree {
    private HashMap<String, HashMap<Object, Integer>> map = new HashMap<String, HashMap<Object, Integer>>();

    public boolean contains(String key) {
        return map.containsKey(key);
    }

    public void add(String key) {
        map.put(key, new HashMap<Object, Integer>());
    }

    public void addAttribute(String key, Node value) {
        HashMap<Object, Integer> hashMap = map.get(key);
        addAttribute(hashMap, key, value);
    }
    
    private void addAttribute(HashMap<Object, Integer> hashMap, String key, Node returnedValue) {
        if (returnedValue instanceof SimpleNode) {
            if (!hashMap.containsKey(returnedValue)) {
                hashMap.put(returnedValue, 1);
            } else {
                hashMap.put(returnedValue, hashMap.get(returnedValue).intValue() + 1);
            }
        } else {
            ((ComplexNode) returnedValue).getBranches().forEach(
                    branch -> addAttribute(hashMap, branch.getKey(), branch.getValue()));
        }
    }

    public Set<Entry<String, HashMap<Object, Integer>>> entrySet() {
        return map.entrySet();
    }

}
