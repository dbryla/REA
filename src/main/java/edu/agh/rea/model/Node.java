package edu.agh.rea.model;

/**
 * Represents node in EventTree
 *
 */
public interface Node extends Comparable<Node>{

    /**
     * Default empty implementation for tree leaf.
     * 
     * @param key
     * @param value
     * @param isSimple 
     * @return null
     */
    default Node set(String key, String value, boolean isSimple) {
        return null;
    }
    
    default public int compareTo(Node o) {
        return this.toString().compareTo(o.toString());
    }

}
