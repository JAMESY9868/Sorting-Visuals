package container;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;
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

    public static void swap(ArrayList<Element> ale, int i, int j) {
        swap(ale, i, ale, j, 0);
    }

    public static void swap(ArrayList<Element> ale1, int i, ArrayList<Element> ale2, int j, int ale2Offset) {
        // temp elements
        Element tmp1 = ale1.get(i), tmp2 = ale2.get(j);

        // colors
        tmp1.setLineColor(swpC);
        tmp2.setLineColor(swpC);

        // set element
        ale1.set(i, tmp2);
        ale2.set(j, tmp1);

        // swap Line
        if (ale1 == ale2)
            tmp1.moveLine(j + ale2Offset);
        tmp2.moveLine(i);

        // return their colors
        tmp1.neutralColor();
        tmp2.neutralColor();

        // update counter when class is MonitoredArray
        if (ale1.getClass() == MonitoredArray.class)
            ((MonitoredArray) ale1).swapped();
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

    public void put(PrintStream ps) {
        ps.printf("[");
        for (Element e : this)
            ps.printf("%d ", e.getItem());
        ps.printf("\b]\n");
    }

    public void neutralColor() {
        for (Element e : this)
            e.neutralColor();
    }
}
