package de.hska.iwi.ads.solution.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import de.hska.iwi.ads.dictionary.MapTest;

public class BinarySearchTreeTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        // TODO Auto-generated method stub
        return new BinarySearchTree<K, V>();
    }

    private Map<Integer, String> example;

    @BeforeEach
    public void before() {
        example = createMap();

        example.put(1, "A");
        example.put(4, "D");
        example.put(5, "E");
        example.put(2, "B");
        example.put(3, "C");
        example.put(6, "F");
        example.put(7, "G");
    }


    @Test
    public void testput01() {
        assertEquals(7, example.size());
        example.put(8, "H");
        assertEquals(8, example.size());
        assertEquals("H", example.get(8));
    }

    @Test
    public void testput02() {
        example.put(8, "H");
        example.put(9, "I");
        assertEquals("I", example.get(9));
        assertEquals(9, example.size());
    }

    @Test
    public void testput03() {  //doppelt
        example.put(10, "J");
        assertEquals(8, example.size());
        example.put(4, "D");
        example.put(10, "J");
        assertEquals("J", example.get(10));
        assertEquals(8, example.size());
    }

    @Test
    public void testput04() {  //doppelt
        Map<Integer, Integer> map = createMap();
        map.put(5, 10);
        map.put(3, 6);
        map.put(1, 2);
        map.put(9, 18);
        map.put(3, 6);
        assertEquals(4, map.size());


    }

    @Test
    public void testget01() {
        assertEquals("A", example.get(1));
        assertEquals("B", example.get(2));
        assertEquals("C", example.get(3));
    }

    @Test
    public void testget02() {
        assertEquals("E", example.get(5));
    }

    @Test
    public void testget03() {   //fehlendes Element suchen
        assertNull(example.get(10));
    }

    @Test
    public void testget04() {  //fehlendes Element suchen
        Map<Integer, String> map = createMap();
        map.put(5, "E");
        assertEquals("E", map.get(5));
        assertNull(map.get(6));

    }

    @Test
    public void testsize01() {
        Map<Integer, String> map = createMap();

        map.put(5, "Fuenf");
        map.put(3, "Drei");
        map.put(7, "Vier");
        map.put(11, "Elf");
        map.put(1, "Eins");
        map.put(9, "Neun");
        map.put(9, "Zehn");
        assertEquals("Zehn", map.get(9));
        assertEquals(6, map.size());
    }

    @Test
    public void testsize02() {
        assertEquals(7, example.size());

    }

    @Test
    public void testsize03() {
        example.put(8, "H");
        assertEquals(8, example.size());
    }

    @Test
    public void testsize04() {  //size 0
        Map<Integer, String> map = createMap();
        assertEquals(0, map.size());

    }


    @Test
    public void testNullPointerException() {
        assertThrows(NullPointerException.class, () -> example.put(null, ""));
    }


}
