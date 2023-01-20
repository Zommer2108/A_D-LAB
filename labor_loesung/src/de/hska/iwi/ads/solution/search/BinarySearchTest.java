package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTest extends SearchTest {

    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        return new BinarySearch<E>();
    }


    // Add additional Tests to your test class
    @Test
    void testStringBinarySearch() {
        Search<String> bs = createSearch();
        String[] a = {"a", "b", "b", "c", "d", "d", "e"};

        int result = bs.search(a, "A", 0, a.length - 1);
        assertEquals(-1, result);

    }

    @Test
    void testIntBinarySearch() {
        Search<Integer> bs = createSearch();
        Integer[] a = {1, 2, 3, 3, 4, 6, 7, 8, 9};

        int result = bs.search(a, 5, 0, a.length - 1);
        assertEquals(5, result);
    }

    @Test
    void testBinarySearchIntArrayNullPointer() {
        Search<Integer> search = createSearch();
        Integer[] a = null;
        assertThrows(NullPointerException.class, () -> search.search(a, 1));
    }

    @Test
    void testBinarySearchIntArrayIntOutOfBounds() {
        Search<Integer> search = createSearch();
        Integer[] a = {0, 1, 2, 3, 4, 5};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> search.search(a, 2, -1, 5));
    }
}
