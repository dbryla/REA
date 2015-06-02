package edu.agh.rea.model;

/**
 * Leaf with string value
 *
 */
public class SimpleNode implements Node {

    private String value;
    private String key;

    public SimpleNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        if (key.equals("")) {
            return value;
        }
        return key + " " + value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(((SimpleNode) obj).getValue());
    }

    private String getValue() {
        return value;
    }
}
