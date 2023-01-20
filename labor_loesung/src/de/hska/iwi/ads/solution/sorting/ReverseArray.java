package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;


public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

    @Override
    public void reverse(E[] a, int from, int to) {

        for (; from <= to; from++, to--) {
            /* The two elements from and to are being swappend
                and changed with eachother and reaching the middle
                of the array
             */
            E tempMemory = a[to];

            a[to] = a[from];
            a[from] = tempMemory;
        }
    }
}
