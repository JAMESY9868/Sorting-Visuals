package sorter;

import java.util.ArrayList;

import container.Element;
import container.MonitoredArray;
import main.Const;

/**
 * @see <a href="https://www.geeksforgeeks.org/heap-sort/">(External Link)
 * HeapSort Reference</a>
 * @author ruy16109
 *
 * @param <Arr> array type
 */
public class HeapSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {

    @Override
    public Arr sort(Arr arr) {
        // build heap
        for (int i = arr.size() / 2 - 1; i >= 0; i--)
            heapify(arr, arr.size(), i);

        // one by one extract element from heap
        for (int i = arr.size() - 1; i >= 0; i--) {
            // move current root to end
            MonitoredArray.swap(arr, 0, i);

            // call max heapify on reduced heap
            heapify(arr, i, 0);
        }

        return arr;
    }

    /**
     * heapify subheap at root i
     * 
     * @param arr the array
     * @param n the size of (sub)heap
     * @param i the root index
     */
    private void heapify(Arr arr, final int n, final int i) {
        int max = i;
        final int left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && arr.get(left).compareTo(arr.get(max)) > 0)
            max = left;
        if (right < n && arr.get(right).compareTo(arr.get(max)) > 0)
            max = right;

        // if max is branch
        if (max != i) {
            MonitoredArray.swap(arr, i, max);
            heapify(arr, n, max);
        }
    }

}
