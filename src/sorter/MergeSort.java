package sorter;

import java.util.ArrayList;

import container.Element;
import container.MonitoredArray;

public final class MergeSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {

    @Override
    public Arr sort(Arr arr) {
        // end is exclusive
        subsort(arr, 0, arr.size());

        return arr;
    }

    /**
     * sort array section [start ... end]
     * 
     * @param arr the array
     * @param start the start of index
     * @param end the end of index, <strong>exclusive</strong>
     */
    private void subsort(Arr arr, int start, int end) {
        // base case, 1 or less elements
        final int numElems = end - start;
        if (numElems <= 1)
            return;

        // recursive
        int mid = (end + start) / 2;

        subsort(arr, start, mid);
        subsort(arr, mid, end);

        // now sections [start ... mid] and [mid ... end] are sorted
        merge(arr, start, mid, end);

        // now section [start ... end] is sorted
        return;
    }

    //
    /**
     * Assuming sorted sections of array arr[start ... mid] and arr[start2 ... end],
     * combine into one sorted section arr[start ... end].
     * 
     * @param arr the array
     * @param start start of first section
     * @param mid end of first section (exclusive), <strong>also</strong> start of
     * second section
     * @param end end of second section (exclusive)
     */
    private void merge(Arr arr, final int start, final int mid, final int end) {
        int ind1 = start, ind2 = mid;

        // create tmp array, copy
        ArrayList<Element> tmp = new ArrayList<>(end - start);

        // when at least one section has elements
        while (ind1 < mid || ind2 < end) {
            // when both have elements
            if (ind1 < mid && ind2 < end)
                // when [ind1] < [ind2], add [ind1]; otherwise add [ind2]; whichever is chosen
                // increases
                tmp.add(arr.get(arr.get(ind1).compareTo(arr.get(ind2)) < 0 ? ind1++ : ind2++));
            // when first has elements
            else if (ind1 < mid)
                tmp.add(arr.get(ind1++));
            // otherwise second has elements
            else tmp.add(arr.get(ind2++));
        }

        // now the tmp array should be sorted, copy to original section
        for (int i = 0; i < tmp.size(); i++)
            // arr has offset of "start"; tmp starts at 0; i + tmp.size() should = end
            MonitoredArray.swap(arr, i + start, tmp, i, start);

        // now the original section is sorted
        return;
    }

}
