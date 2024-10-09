package sort;

import java.util.ArrayList;

public interface SortInterface<E extends Comparable<E>> {
    void sort(E[] array);
}
