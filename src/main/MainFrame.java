package main;

import javax.swing.JFrame;

import container.Element;
import container.MonitoredArray;
import graph.Line;
import sorter.BubbleSort;
import sorter.SortTrier;

@SuppressWarnings("serial")
public final class MainFrame extends JFrame {
    public SortPanel sp;

    public MainFrame() {
        this(new SortPanel());
    }

    public MainFrame(SortPanel _sp) {
        super("Sorting Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // field init
        sp = _sp;

        // add onto frame
        this.add(sp);

        // set visible
        this.pack();
        this.setVisible(true);
    }

    public void update() {
        Element.p = Line.p = sp;
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();

        mf.update();

        // sort
        mf.sp.sort(new SortTrier(new BubbleSort<MonitoredArray>()));
    }
}
