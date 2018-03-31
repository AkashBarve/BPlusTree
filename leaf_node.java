import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

//Define class leaf_node which is inherited from class node.
public class leaf_node extends node {

    protected ArrayList<ArrayList<String>> values;
    protected leaf_node leaf_next;
    protected leaf_node leaf_previous;

    /**
     * Initial insert into a leaf node
     * @param firstKey
     * @param firstValue
     */
    public leaf_node(Double firstKey, String firstValue) {
        is_leaf = true;
        keys = new ArrayList<Double>();
        values = new ArrayList<ArrayList<String>>();
        keys.add(firstKey);

        ArrayList<String> valueList = new ArrayList<String>();
        valueList.add(firstValue);

        values.add(valueList);

    }

    /**
     * Insert into leaf node caused due to a split operation
     * @param new_keys
     * @param newValues
     */
    public leaf_node(ArrayList<Double> new_keys, ArrayList<ArrayList<String>> newValues) {
        is_leaf = true;
        keys = new ArrayList<Double>(new_keys);
        values = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> value:newValues){

            values.add(value);

        }
    }

    /**
     * Perform insertion in sorted order
     * @param key
     * @param valueList
     */
    public void ordered_insert(Double key, ArrayList<String> valueList){

        if(key.compareTo(keys.get(0)) < 0) {
            keys.add(0, key);
            values.add(0, valueList);
        }
        else if (key.compareTo(keys.get(keys.size() - 1)) > 0){
            keys.add(key);
            values.add(valueList);

        }
        else{
            ListIterator<Double> iterator = keys.listIterator();
            while(iterator.hasNext()){
                if(iterator.next().compareTo(key) > 0){
                    int position = iterator.previousIndex();
                    keys.add(position, key);
                    values.add(position,valueList);
                    break;

                }
            }
        }

    }

    /**
     * Updates the list after each insert
     * @param index
     * @param value
     */
    public void update(int index, String value){
        values.get(index).add(value);

    }


}
