
package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesort<E> {

    @Override
    protected void mergesort(E[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(a, left, mid);
            mergesort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    public void merge(E[] a, int left, int mid, int right) {
        int l = left;
        //r is now the opposite and begins from behind former: r = mid + 1
        int r = right;

        ReverseArray<E> reverseMergeSort = new ReverseArray<>();
        reverseMergeSort.reverse(a, mid + 1, right);
        //a is being reversed from mid+1 to right

        for (int i = left; i <= right; i++) {
            if ((a[l].compareTo(a[r]) <= 0)) {
                b[i] = a[l];
                l = l + 1;
            } else {
                b[i] = a[r];
                r = r + -1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
    public void sort(E[] a, int left, int right) {
        b = a.clone();
        mergesort(a, left, right);
    }
}
