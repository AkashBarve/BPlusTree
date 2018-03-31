//Define class key_node_map which associates the key to a particular value
public class key_node_map {
    Double key;
    node node;
    key_node_map(Double k, node n) {
        this.key = k;
        this.node = n;
    }

    /**
     * return the key
     * @return Double
     */
    public Double getKey() {
        return this.key;
    }

    /**
     * return the node
     * @return node
     */
    public node getValue() {
        return this.node;
    }
}