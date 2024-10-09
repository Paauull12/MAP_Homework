package sort;

public class MergeSort<E extends Comparable<E>> implements SortInterface<E> {

    @Override
    public void sort(E[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        E[] leftHalf = (E[]) new Comparable[mid];
        E[] rightHalf = (E[]) new Comparable[array.length - mid];

        System.arraycopy(array, 0, leftHalf, 0, mid);
        System.arraycopy(array, mid, rightHalf, 0, array.length - mid);

        sort(leftHalf);
        sort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private void merge(E[] original, E[] left, E[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                original[k++] = left[i++];
            } else {
                original[k++] = right[j++];
            }
        }

        while (i < left.length) {
            original[k++] = left[i++];
        }

        while (j < right.length) {
            original[k++] = right[j++];
        }
    }
}
