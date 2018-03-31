import java.util.ArrayList;

//Define class node which contains instances of ArrayList
public class node {

    protected boolean is_leaf;
    protected ArrayList<Double> keys;

    /**
     * This method contains a boolean to handle the overflow condition
     * @return boolean
     */
    public boolean overflow() {
        return keys.size() > b_plus_tree.tree_degree;
    }

}
