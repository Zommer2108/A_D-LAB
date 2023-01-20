package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class Mergesort<E extends Comparable<E>> extends AbstractMergesort<E> {

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
        int r = mid + 1;

        for (int i = left; i <= right; i++) {
            if (r > right || (l <= mid && (a[l].compareTo(a[r]) <= 0))) {

                // b is from AbstractMergesort
                b[i] = a[l];
                l = l + 1;
            } else {

                b[i] = a[r];
                r = r + 1;
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
