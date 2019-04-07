package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

import javax.swing.JPanel;

import main.Const;

public final class Line implements Repainter {
    private final int width, height;
    private int x;

    private Color c;
    public static JPanel p;
    public final static Color neutral = Color.WHITE;

    private Point start, end;

    protected Line(int height, int x, int width) {
        this.width = width;
        this.height = height;
        this.x = x;
        c = neutral;

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

    public Color swapColor(final Color __c) {
        final Color _c = this.c;
        this.c = __c;

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
        final Paint tmpPaint = g.getPaint();
        final Stroke tmpStrk = g.getStroke();

        g.setPaint(c);

        g.setStroke(new BasicStroke(width));
        g.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());

        g.setPaint(tmpPaint);
        g.setStroke(tmpStrk);
    }

    public Color getColor() {
        return c;
    }

    public void setColor(Color _c) {
        c = _c;
    }
}
