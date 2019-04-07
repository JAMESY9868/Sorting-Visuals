package sorter;

import java.util.ArrayList;

import container.Element;

/**
 * This interface indicates that the class contains an algorithm that sorts the
 * array; it assumes that the sorted item is of Element type.
 * 
 * @author ruy16109
 *
 * @param <Arr> the array type
 * 
 * @see sorter.Sorter
 * @see container.Element
 */
public interface AlgoSorter<Arr extends ArrayList<Element>> extends Sorter<Element, Arr> {
}
