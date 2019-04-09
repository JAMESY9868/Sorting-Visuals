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

    private static final Color C1 = Color.RED, C2 = Color.RED;

    Element(Integer item, Line _line, MonitoredArray mai) {
        this.item = item;
        line = _line;
        this.mai = mai;
    }

    @Override
    public int compareTo(Element o) {
        // set color
        final Color c1 = swapLineColor(C1), c2 = o.swapLineColor(C2);

        // stores result
        int cmp = item.compareTo(o.item);

        // repaint
        p.repaint();

        // line repaints
        swapLineColor(c1);
        o.swapLineColor(c2);

        // update counters
        mai.compared();

        // return
        return cmp;
    }

    public int compareTo(Integer item) {
        // set color
        final Color c = swapLineColor(C1);

        // stores result
        int cmp = this.item.compareTo(item);

        // repaint
        p.repaint();

        // line repaints
        swapLineColor(c);

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

    public Integer getItem() {
        return item;
    }

    public void neutralColor() {
        swapLineColor(Line.neutral);
    }

    public Color getLineColor() {
        return line.getColor();
    }

    public void setLineColor(Color c) {
        line.setColor(c);
        p.repaint();
    }
}
