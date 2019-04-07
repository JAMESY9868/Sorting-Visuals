package sorter;

import java.util.ArrayList;

public interface Sorter<Item extends Comparable<Item>, Arr extends ArrayList<Item>> {
    public abstract Arr sort(Arr arr);
}
