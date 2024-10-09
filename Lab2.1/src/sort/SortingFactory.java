package sort;

public class SortingFactory<E extends Comparable<E>> {

    public SortInterface<E> createSorter(SortingStrategy strategy){
        if(strategy == SortingStrategy.Selection)
            return new SelectionSort<E>();
        else if(strategy == SortingStrategy.Merge)
            return new MergeSort<E>();
        return null;
    }

}
