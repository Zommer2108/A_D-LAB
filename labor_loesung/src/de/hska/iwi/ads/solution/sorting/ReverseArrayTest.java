package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseArrayTest {

    @Test
    void testReverseArrayInt() {
        ReverseArray<Integer> obj1 = new ReverseArray<Integer>();
        Integer array[] = {5, 2, 3, 6};
        obj1.reverse(array, 0, 3);
        Integer reversed[] = {6, 3, 2, 5};
        assertArrayEquals(reversed, array);
    }

    @Test
    void testReversePartialArrayInt() {
        ReverseArray<Integer> obj1 = new ReverseArray<Integer>();
        Integer array[] = {5, 2, 3, 6};
        obj1.reverse(array, 1, 2);
        Integer reversed[] = {5, 3, 2, 6};
        assertArrayEquals(reversed, array);
    }


    @Test
    void testReverseArrayChar() {
        ReverseArray<Character> obj1 = new ReverseArray<Character>();
        Character array[] = {'a', 'c', 'd', 'b'};
        obj1.reverse(array, 0, 3);
        Character reversed[] = {'b', 'd', 'c', 'a'};
        assertArrayEquals(reversed, array);
    }

    @Test
    void testReverseArrayDouble() {
        ReverseArray<Double> obj1 = new ReverseArray<Double>();
        Double array[] = {3.0, 2.3, 1.5, 4.3};
        obj1.reverse(array, 0, 3);
        Double reversed[] = {4.3, 1.5, 2.3, 3.0};
        assertArrayEquals(reversed, array);
    }

    @Test
    void testReverseArrayString() {
        ReverseArray<String> obj1 = new ReverseArray<String>();
        String array[] = {"snow", "i", "really", "like"};
        obj1.reverse(array, 0, 3);
        String reversed[] = {"like", "really", "i", "snow"};
        assertArrayEquals(reversed, array);
    }
}
