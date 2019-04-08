package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;

import container.Element;
import container.MonitoredArray;
import graph.Line;
import sorter.AlgoSorter;
import sorter.BubbleSort;
import sorter.HeapSort;
import sorter.InsertionSort;
import sorter.MergeSort;
import sorter.QuickSort;
import sorter.SelectionSort;
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
            // mf.sorts(0);

            // merge sort
            // mf.sorts(1);

            // quick sort
            // mf.sorts(2);

            // selection sort
            // mf.sorts(3);

            // insertion sort
            // mf.sorts(4);

            // heap sort
            mf.sorts(5);

        } catch (IOException e) {
            System.err.println("IO Error. Exiting. ");
            System.exit(-1);
        } finally {
            System.out.println("Completed! ");
        }
    }

    /**
     * sort using the factory created sorting algorithm
     * 
     * @param i factory index
     * @see sortFactory
     */
    private void sorts(int i) {
        sp.sort(new SortTrier(sortFactory(i)));
    }

    private static AlgoSorter<MonitoredArray> sortFactory(int i) {
        switch (i) {
            case 0:
            return new BubbleSort<MonitoredArray>();
            case 1:
            return new MergeSort<MonitoredArray>();
            case 2:
            return new QuickSort<MonitoredArray>();
            case 3:
            return new SelectionSort<MonitoredArray>();
            case 4:
            return new InsertionSort<MonitoredArray>();
            case 5:
            return new HeapSort<MonitoredArray>();
            default:
            return null;
        }
    }
}
