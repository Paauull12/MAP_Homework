package domain;

import sort.SortInterface;
import sort.SortingFactory;
import sort.SortingStrategy;


public class SortingTask<E extends Comparable<E>> extends Task {
    private E[] array;
    private SortingStrategy sortingType;

    public SortingTask(String taskId, String desc, E[] array, SortingStrategy sortingType) {
        super(taskId, desc);
        this.array = array;
        this.sortingType = sortingType;
    }

    @Override
    public void execute() {
        SortingFactory<E> factory = new SortingFactory<>();
        SortInterface<E> sorter = factory.createSorter(this.sortingType);
        sorter.sort(this.array);
        System.out.println("Executat sortat");
    }
}
