package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergesortTest {

    @Test
    void testMergesortInt() {
        Mergesort<Integer> obj1 = new Mergesort<Integer>();
        Integer array[] = {5, 2, 3, 6};
        obj1.sort(array, 0, 3);
        Integer sorted[] = {2, 3, 5, 6};
        assertArrayEquals(sorted, array);
    }

    @Test
    void testMergesortChar() {
        Mergesort<Character> obj1 = new Mergesort<Character>();
        Character array[] = {'a', 'c', 'd', 'b'};
        obj1.sort(array, 0, 3);
        Character sorted[] = {'a', 'b', 'c', 'd'};
        assertArrayEquals(sorted, array);
    }

    @Test
    void testMergesortDouble() {
        Mergesort<Double> obj1 = new Mergesort<Double>();
        Double array[] = {3.0, 2.3, 1.5, 4.3};
        obj1.sort(array, 0, 3);
        Double sorted[] = {1.5, 2.3, 3.0, 4.3};
        assertArrayEquals(sorted, array);
    }

    @Test
    void testMergesortString() {
        Mergesort<String> obj1 = new Mergesort<String>();
        String array[] = {"snow", "i", "really", "like"};
        obj1.sort(array, 0, 3);
        String sorted[] = {"i", "like", "really", "snow"};
        assertArrayEquals(sorted, array);
    }
}
