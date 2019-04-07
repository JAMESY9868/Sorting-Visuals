package sorter;

import container.Element;
import container.MonitoredArray;
import main.Const;

public final class SortTrier implements Sorter<Element, MonitoredArray> {
    Sorter<Element, MonitoredArray> sorter;

    public SortTrier(Sorter<Element, MonitoredArray> s) {
        sorter = s;
    }

    @Override
    public MonitoredArray sort(MonitoredArray arr) {
        // start timer
        long tstart = System.currentTimeMillis();

        // run sort algorithm
        MonitoredArray ali = sorter.sort(arr);

        // end timer
        long tend = System.currentTimeMillis();

        // calculate time
        long total = tend - tstart;
        @SuppressWarnings("unused")
        long swap = Const.SWAPS == 0 ? 0 : ali.getSwap() / Const.SWAPS,
                compare = Const.COMPARES == 0 ? 0 : ali.getCompare() / Const.COMPARES;

        long only = total - swap - compare;

        // report data
        System.out.println("Time spent (ms): " + only);
        System.out.println("Including sleep (ms): " + total);
        System.out.println("Swap used: " + ali.getSwap());
        System.out.println("Compare used: " + ali.getCompare());

        // return data
        return ali;
    }

}
