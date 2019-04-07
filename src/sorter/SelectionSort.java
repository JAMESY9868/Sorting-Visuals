package sorter;

import java.util.ArrayList;

import container.Element;
import container.MonitoredArray;

public class SelectionSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {

    @Override
    public Arr sort(Arr arr) {
        // don't need to check last index
        for (int i = 0; i < arr.size() - 1; i++)
            // swap [i] with min[i+1 ... end]
            MonitoredArray.swap(arr, i, min(arr, i + 1));

        return arr;
    }

    /**
     * finds the minimum index
     * 
     * @param arr the array
     * @param start the starting index, inclusive
     * @return the index holding the smallest element
     */
    private int min(Arr arr, final int start) {
        // sanity check
        if (start >= arr.size())
            return -1;

        // starting to find min
        final int end = arr.size();
        int m = start;
        for (int i = start + 1; i < end; i++) {
            // curr < min
            if (arr.get(m).compareTo(arr.get(i)) > 0)
                // new min
                m = i;
        }
        return m;
    }

}
