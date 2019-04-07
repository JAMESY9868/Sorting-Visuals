package container;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import graph.Line;
import graph.Repainter;

public class Element implements Comparable<Element>, Repainter {
    private Integer item;
    private Line line;
    private MonitoredArray mai;

    public static JPanel p;

    private static final Color C1 = Color.GREEN, C2 = Color.RED;

    Element(Integer item, Line _line, MonitoredArray mai) {
        this.item = item;
        line = _line;
        this.mai = mai;
    }

    @Override
    public int compareTo(Element o) {
        // set color
        Color c1 = line.swapColor(C1), c2 = o.line.swapColor(C2);

        // stores result
        int cmp = item.compareTo(o.item);

        // line repaints
        line.swapColor(c1);
        o.line.swapColor(c2);

        // update counters
        mai.compared();

        // return
        return cmp;
    }

    public Color swapLineColor(Color c) {
        return line.swapColor(c);
    }

    @Override
    public void repaint(Graphics2D g) {
        line.repaint(g);
    }

    public void moveLine(int x) {
        line.moveTo(x);
    }

}
