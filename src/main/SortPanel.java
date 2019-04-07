package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JPanel;

import container.MonitoredArray;
import sorter.SortTrier;

@SuppressWarnings("serial")
public final class SortPanel extends JPanel {
    private MonitoredArray mai;
    private Random r;

    SortPanel() {
        super();

        // general setup
        Dimension d = new Dimension(Const.WIDTH, Const.HEIGHT);
        this.setPreferredSize(d);
        this.setBackground(Color.BLACK);

        // field setup
        r = new Random(865167375);
        mai = new MonitoredArray(shuffledIntegers(Const.WIDTH));
    }

    private ArrayList<Integer> shuffledIntegers(int len) {
        ArrayList<Integer> ali = new ArrayList<>(len);

        for (int i = 0; i < len; i++)
            ali.add(i);

        Collections.shuffle(ali, r);
        return ali;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        mai.repaint((Graphics2D) g);
    }

    public void sort(SortTrier st) {
        st.sort(mai);
    }

}
