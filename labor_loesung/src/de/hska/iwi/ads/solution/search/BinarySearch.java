package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] a, E key, int left, int right) {
        int returnValue;
        // compareTo returns a negative integer, zero, or a positive integer as this
        // object is less than, equal to, or greater than the specified object.

        // 1. key < a[left] -> i = left - 1
        if (key.compareTo(a[left]) < 0) {

            returnValue = left - 1;

            // 2. key > a[right] -> i = right + 1
        } else if (key.compareTo(a[right]) > 0) {

            returnValue = right + 1;

            // 3. case can be detected and handled by an ordinary binary search
        } else {
            returnValue = binarySearch(a, key, left, right);
        }

        return returnValue;
    }

    // Recursive Binary Search
    private int binarySearch(E[] a, E key, int left, int right) {
        if (left > right) {

            return right + 1;

        } else {

            int mid = (left + right) / 2;

            if (key.compareTo(a[mid]) == 0) {

                int lowerIndex = binarySearch(a, key, left, mid - 1);
                return (key.compareTo(a[lowerIndex]) == 0) ? lowerIndex : mid;

            } else if (key.compareTo(a[mid]) < 0) {
                return binarySearch(a, key, left, mid - 1);

            } else {
                return binarySearch(a, key, mid + 1, right);
            }
        }
    }
}
