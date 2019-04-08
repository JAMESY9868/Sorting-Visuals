package sorter;

import java.util.ArrayList;

import container.Element;
import container.MonitoredArray;

public class InsertionSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {

    @Override
    public Arr sort(Arr arr) {
        // index 0 already sorted, start at 1 and end at len-1
        for (int i = 1; i < arr.size(); i++)
            insert(arr, i);

        return arr;
    }

    private void insert(Arr arr, int i) {
        // sanity check
        if (i >= arr.size())
            return;

        // when not at start, and when need swapping ([i] < [i-1])
        while (i > 0 && arr.get(i).compareTo(arr.get(i - 1)) < 0) {
            MonitoredArray.swap(arr, i, i - 1);
            i--;
        }
    }

}
