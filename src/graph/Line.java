package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

import javax.swing.JPanel;

import main.Const;

public final class Line implements Repainter {
    private final int width, height;
    private int x;

    private Color c;
    public static JPanel p;

    private Point start, end;

    protected Line(int height, int x, int width) {
        this.width = width;
        this.height = height;
        this.x = x;
        c = Color.WHITE;

        start = new Point();
        end = new Point();

        updatePoints();
    }

    public Line(int height, int x) {
        this(height, x, 1);
    }

    public void moveTo(int x) {
        this.x = x;
        updatePoints();
    }

    public Color swapColor(Color c) {
        Color _c = this.c;
        this.c = c;

        // repaints
        p.repaint();

        return _c;
    }

    private void updatePoints() {
        start.setLocation(x, Const.HEIGHT);
        end.setLocation(x, Const.HEIGHT - height);
    }

    @Override
    public void repaint(Graphics2D g) {
        fill(g);
        draw(g);
    }

    public void fill(Graphics2D g) {
        return;
    }

    public void draw(Graphics2D g) {
        Color tmpColor = g.getColor();
        Stroke tmpStrk = g.getStroke();

        g.setColor(c);
        g.setStroke(new BasicStroke(width));
        g.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());

        g.setStroke(tmpStrk);
        g.setColor(tmpColor);
    }
}
