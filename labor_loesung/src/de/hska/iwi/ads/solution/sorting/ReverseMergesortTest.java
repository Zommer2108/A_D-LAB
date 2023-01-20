package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseMergesortTest {

    @Test
    void testReverseMergesortInt() {
        ReverseMergesort<Integer> obj1 = new ReverseMergesort<Integer>();
        Integer array[] = {5, 2, 3, 6};
        obj1.sort(array, 0, 3);
        Integer reverseSorted[] = {2, 3, 5, 6};
        assertArrayEquals(reverseSorted, array);
    }

    @Test
    void testReverseMergesortChar() {
        ReverseMergesort<Character> obj1 = new ReverseMergesort<Character>();
        Character array[] = {'a', 'c', 'd', 'b'};
        obj1.sort(array, 0, 3);
        Character reverseSorted[] = {'a', 'b', 'c', 'd'};
        assertArrayEquals(reverseSorted, array);
    }

    @Test
    void testReverseMergesortDouble() {
        ReverseMergesort<Double> obj1 = new ReverseMergesort<Double>();
        Double array[] = {3.0, 2.3, 1.5, 4.3};
        obj1.sort(array, 0, 3);
        Double reverseSorted[] = {1.5, 2.3, 3.0, 4.3};
        assertArrayEquals(reverseSorted, array);
    }

    @Test
    void testReverseMergesortString() {
        ReverseMergesort<String> obj1 = new ReverseMergesort<String>();
        String array[] = {"snow", "i", "really", "like"};
        obj1.sort(array, 0, 3);
        String reverseSorted[] = {"i", "like", "really", "snow"};
        assertArrayEquals(reverseSorted, array);
    }

}
