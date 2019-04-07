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
        ali.neutralColor();

        // calculate time
        long total = tend - tstart;
        @SuppressWarnings("unused")
        long swap = Const.SWAPS == 0 ? 0 : ali.getSwap() / Const.SWAPS,
                compare = Const.COMPARES == 0 ? 0 : ali.getCompare() / Const.COMPARES;

        long only = total - swap - compare;

        // report data
        Const.out.println("Time spent (ms): " + only);
        Const.out.println("Including sleep (ms): " + total);
        Const.out.println("Swap used: " + ali.getSwap());
        Const.out.println("Compare used: " + ali.getCompare());
        Const.out.println();

        // return data
        return ali;
    }

}
