package sorter;

import java.util.ArrayList;

import container.Element;
import container.MonitoredArray;

public class QuickSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {

    @Override
    public Arr sort(Arr arr) {
        quicksort(arr, 0, arr.size());

        return arr;
    }

    /**
     * The sorting algorithm
     * 
     * @param arr the array
     * @param start the starting index, inclusive
     * @param end the ending index, exclusive
     * 
     * @see <a href="https://www.geeksforgeeks.org/quick-sort/">(External Link)
     * QuickSort Pseudocode</a>
     * @see QuickSort#partition
     */
    private void quicksort(Arr arr, final int start, final int end) {
        final int numElems = end - start;
        // when 1, already sorted; when <=0, invalid so ignore
        if (numElems > 1) {
            // the pivot index, and [piv] is at correct position
            final int piv = partition(arr, start, end);

            // subdivide, *ignoring pivot position
            quicksort(arr, start, piv); // remember end is exclusive
            quicksort(arr, piv + 1, end);
        }
    }

    /**
     * this method partitions the array
     * 
     * @param arr the array
     * @param start the starting index, inclusive
     * @param end the ending index, exclusive
     * @return the pivot index
     */
    private int partition(Arr arr, final int start, final int end) {
        // takes the last element as pivot value
        final Element pivotElem = arr.get(end - 1);

        // index of smaller element
        int i = start - 1;
        for (int j = start; j < end - 1; j++)
            // if current <= pivot
            if (arr.get(j).compareTo(pivotElem) <= 0)
                MonitoredArray.swap(arr, ++i, j);

        MonitoredArray.swap(arr, ++i, end - 1);
        return i;
    }

}
