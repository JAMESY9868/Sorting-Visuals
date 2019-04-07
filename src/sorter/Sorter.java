package sorter;

import java.util.ArrayList;

/**
 * this interface indicates that the class accomplishes the job of sorting by its 'sort' method. 
 * @author ruy16109
 *
 * @param <Item> the sorted type, must be comparable
 * @param <Arr> the array containing the item
 */
public interface Sorter<Item extends Comparable<Item>, Arr extends ArrayList<Item>> {
    public abstract Arr sort(Arr arr);
}
