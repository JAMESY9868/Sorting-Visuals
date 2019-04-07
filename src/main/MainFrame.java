package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;

import container.Element;
import container.MonitoredArray;
import graph.Line;
import sorter.BubbleSort;
import sorter.MergeSort;
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
        try (PrintStream out = new PrintStream(new FileOutputStream("out.log", false));
                PrintStream err = new PrintStream(new FileOutputStream("err.log", false))) {

            Const.out = out;
            Const.err = err;

            MainFrame mf = new MainFrame();

            mf.update();

            // bubble sort
            mf.sp.sort(new SortTrier(new BubbleSort<MonitoredArray>()));

            // merge sort
            mf.sp.sort(new SortTrier(new MergeSort<MonitoredArray>()));

        } catch (IOException e) {
            System.err.println("IO Error. Exiting. ");
            System.exit(-1);
        }
    }
}
