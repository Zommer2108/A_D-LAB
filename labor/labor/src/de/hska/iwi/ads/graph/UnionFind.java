package de.hska.iwi.ads.graph;

/**
 * Abstract data type for the union find problem and its
 * solution.
 * The elements of the underlying sets are given by int-Numbers
 * int the range <code>[0..size() - 1]</code>.
 * Each set is represented by a unique element of the set.
 * <p/>
 * Initially there are <code>n = size()</code> disjoint sets: one for each int-Number.
 * <code>{0}, {1}, ..., {n-1}</code> and each of these sets
 *  is represented by the single element itself.
 */
public interface UnionFind {

  /**
   * Creates the union of two equal or disjoint sets represented by
   * <code>node1</code> and <code>node2</code>.
   * <p/>
   * Examples:
   * <p/>
   * A set <code>{1, 3, 7}</code> and <code>{2, 5}</code> for
   * a given <code>node1</code> = 1 and <code>node2</code> = 5 
   * are unified to a set <code>{1, 2, 3, 5, 7}</code>.
   * <p/>
   * A set <code>{2, 3, 7, 11}</code>
   *  <code>node1</code> = 3 and <code>node2</code> = 11 leaves the set
   *  unchanged.
   * @param node1 a number from 0 up to size() - 1
   * @param node2 a number from 0 up to size() - 1
   */
	public void union(int node1, int node2);
	
	/**
	 * returns for the given element <code>node</code> the 
	 * unique representant of the set node is member of
	 * 
	 * @param node a number from 0 up to size() - 1
	 */
	public int find(int node);

	/**
	 * returns the number of elements of all sets
	 */
	public int size();
}
