package container;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import graph.Line;
import graph.Repainter;
import main.Const;

@SuppressWarnings("serial")
public final class MonitoredArray extends ArrayList<Element> implements Repainter {
    private static final Color swpC = Color.BLUE;
    private int nSwap, nCompare; // counters

    public MonitoredArray(ArrayList<Integer> ali) {
        super(ali.size());

        // set counters
        nSwap = nCompare = 0;

        for (int i = 0; i < ali.size(); i++)
            add(new Element(ali.get(i), new Line(ali.get(i), i), this));
    }

    public static <Item> void swap(ArrayList<Item> _ale, int i, int j) {
        @SuppressWarnings("unchecked")
        ArrayList<Element> ale = (ArrayList<Element>) _ale;

        // temp elements
        Element tmp1 = ale.get(i), tmp2 = ale.get(j);

        // colors
        Color c1 = tmp1.swapLineColor(swpC), c2 = tmp2.swapLineColor(swpC);

        // set element
        ale.set(i, tmp2);
        ale.set(j, tmp1);

        // swap Line
        tmp1.moveLine(j);
        tmp2.moveLine(i);

        // return their colors
        tmp1.swapLineColor(c1);
        tmp2.swapLineColor(c2);

        // update counter when class is MonitoredArray
        if (_ale.getClass() == MonitoredArray.class)
            ((MonitoredArray) _ale).swapped();
    }

    @SuppressWarnings("unused")
    public void swapped() {
        nSwap++;

        // sleep 1ms per given swaps
        if (Const.SWAPS > 0 && getSwap() % Const.SWAPS == 0)
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
    }

    @SuppressWarnings("unused")
    public void compared() {
        nCompare++;

        // sleep 1ms per given compares
        if (Const.COMPARES > 0 && getCompare() % Const.COMPARES == 0)
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
    }

    public int getSwap() {
        return nSwap;
    }

    public int getCompare() {
        return nCompare;
    }

    @Override
    public void repaint(Graphics2D g) {
        for (Element e : this)
            e.repaint(g);
    }

}
