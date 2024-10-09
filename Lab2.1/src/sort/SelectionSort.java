package sort;

public class SelectionSort<E extends Comparable<E>> implements SortInterface<E>{

    @Override
    public void sort(E[] array) {
        for(int i = 1; i < array.length; ++i)
            for(int j = i + 1; j < array.length; ++j)
                if(array[j].compareTo(array[i]) < 0){
                    E temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
    }
}
