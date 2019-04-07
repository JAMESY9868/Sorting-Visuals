package sorter;

import java.util.ArrayList;

import container.Element;
import container.MonitoredArray;

public class BubbleSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {
    @Override
    public Arr sort(Arr arr) {
        // end index
        for (int end = arr.size() - 1; end >= 0; end--) {
            // compare index (reaches end-1)
            for (int i = 0; i < end - 1; i++) {
                // compare [i] and [i+1], compareTo > 0 means [i] greater
                if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
                    MonitoredArray.swap(arr, i, i + 1);
                }
            }
        }
        return arr;
    }

}
