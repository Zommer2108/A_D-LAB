package de.hska.iwi.ads.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.graph.UnionFind;

/**
 * a few tests for UnionFind implementations
 */
public abstract class UnionFindTest {

  /**
   * Override this method to return an implementation of the
   * UnionFind interface.
   */
	protected abstract UnionFind createUnionFind(int size);
		
	@Test
	void testUnionFind() {
		UnionFind find = createUnionFind(100);
		
		for (int i = 0; i < 100; i++) {
			assertEquals(i, find.find(i));
		}
		assertEquals(100, find.size());
	}

	@Test
	void testUnion1() {
		UnionFind find = createUnionFind(2);
		find.union(0, 1);
		assertEquals(find.find(0), find.find(1));
	}

	@Test
	void testUnion2() {
		UnionFind find = createUnionFind(8);
		for (int step = 1; step < find.size(); step *= 2) {
			for (int i = 0; i + step < find.size(); i += step) {
				find.union(i, i + step);
			}
		}
		
		for (int i = 0; i < find.size(); i++) {
		   assertEquals(find.find(0), find.find(i));
		}
	}
	
	@Test
	void testUnion3() {
		UnionFind find = createUnionFind(2);
		find.union(0, 0);
		assertEquals(find.find(0), find.find(0));
	}
	
	@Test
	void testFind1() {
		UnionFind find = createUnionFind(1_000_000);
		for (int i = 1; i < find.size(); i++) {
			find.union(0, i);
		}
		for (int i = 0; i < find.size(); i++) {
			find.union(find.find(0), find.find(i) );
		}
	}

	@Test
	void testFind2() {
		UnionFind find = createUnionFind(1_000_000);
		for (int i = 1; i < find.size(); i++) {
			find.union(i, 0);
		}
		for (int i = 0; i < find.size(); i++) {
			find.union(find.find(0), find.find(i) );
		}
	}
	
	@Test
	void testFind3() {
		UnionFind find = createUnionFind(1_000_000);

        find.union(1, 10); // {1, 10}
        find.union(2, 20); // {2, 20}
        find.union(3, 30); // {3, 30}
        find.union(4, 40); // {4, 40}
        find.union(5, 50); // {5, 50}
        
        find.union(10, 6); // {1, 6, 10}
        find.union(20, 7); // {2, 7, 20}
        find.union(30, 8); // {3, 8, 30}
        find.union(40, 9); // {4, 9, 40}
        find.union(50, 11); // {5, 11, 50}

        find.union(1, 30); // {1, 3, 6, 8, 10, 30}
        find.union(40, 7); // {2, 4, 7, 9, 20, 40}
        
        assertEquals( find.find(1), find.find(3));
        assertEquals( find.find(1), find.find(6));
        assertEquals( find.find(1), find.find(8));
        assertEquals( find.find(1), find.find(10));
        assertEquals( find.find(1), find.find(30));
        
        assertEquals( find.find(2), find.find(4));
        assertEquals( find.find(2), find.find(7));
        assertEquals( find.find(2), find.find(9));
        assertEquals( find.find(2), find.find(20));
        assertEquals( find.find(2), find.find(40));
        
        assertEquals( find.find(5), find.find(11));
        assertEquals( find.find(5), find.find(50));
	}
}
