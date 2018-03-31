import java.util.ArrayList;
import java.util.List;

//Definition of class index_node which is inherited from class node
public class index_node extends node {
    
    protected ArrayList<node> children;

    /**
     * Contructor to handle a single insertion into the insert node during initial operation
     * @param key
     * @param child0
     * @param child1
     */
    public index_node(Double key, node child0, node child1) {
        is_leaf = false;
        keys = new ArrayList<Double>();
        keys.add(key);
        children = new ArrayList<node>();
        children.add(child0);
        children.add(child1);
    }

    /**
     * Insert into the index node after an operation which is not the initial operation(insert caused by split)
     * @param new_keys
     * @param newChildren
     */
    public index_node(List<Double> new_keys, List<node> newChildren) {
        is_leaf = false;

        keys = new ArrayList<Double>(new_keys);
        children = new ArrayList<node>(newChildren);
    }

    /**
     * Insert entry into this node at the specified index so that it still remains sorted
     * @param e
     * @param index
     */
    public void ordered_insert(key_node_map e, int index) {
        Double key = e.getKey();
        node child = e.getValue();
        if (index >= keys.size()) {
            keys.add(key);
            children.add(child);
        } else {
            keys.add(index, key);
            children.add(index+1, child);
        }
    }

}