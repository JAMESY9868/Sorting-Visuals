package main;

import java.awt.GraphicsEnvironment;
import java.io.PrintStream;

public final class Const {
    private static final int offset = 32;
    private static final int EQ = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height
            - offset;
    public static final int WIDTH = EQ, HEIGHT = EQ;
    public static final int SWAPS = 10, COMPARES = 60;

    public static PrintStream out, err;
}
