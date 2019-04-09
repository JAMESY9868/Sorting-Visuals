package sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

import container.Element;
import container.MonitoredArray;

public class CountingSort<Arr extends ArrayList<Element>> implements AlgoSorter<Arr> {

    @Override
    public Arr sort(Arr arr) {
        final Element min = Collections.min(arr), max = Collections.max(arr);
        final Integer mini = min.getItem(), maxiex = max.getItem() + 1;
        final Integer range = maxiex - mini;

        ArrayList<Integer> c = new ArrayList<>(range), stream = new ArrayList<>(range);

        // build the range, add to stream
        IntStream.range(mini, maxiex).forEach(stream::add);
        for (@SuppressWarnings("unused")
        Integer i : stream)
            c.add(0);

        // counts
        for (Element e : arr) {
            // get its index by taking diff of e and min
            final int index = e.getItem() - mini;
            
            // that this is a comparison
            if (arr.getClass() == MonitoredArray.class)
                ((MonitoredArray) arr).compared();

            c.set(index, c.get(index) + 1);
        }

        // then starting to compile the final array
        ArrayList<Integer> compiled = new ArrayList<>(range);
        for (int i = 0; i < range; i++)
            for (int j = 0; j < c.get(i); j++)
                compiled.add(stream.get(i));

        // then put into mai
        MonitoredArray mai = new MonitoredArray(compiled, arr);
        for (int i = 0; i < range; i++)
            MonitoredArray.swap(arr, i, mai, i, 0);

        return arr;
    }
}
