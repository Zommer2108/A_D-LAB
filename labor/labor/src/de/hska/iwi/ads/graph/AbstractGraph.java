package de.hska.iwi.ads.graph;

import java.util.List;
import java.util.Map;

/**
 * Abstract data type for a graph implementation with
 * adjacence lists.
 */
public abstract class AbstractGraph implements Graph {

  /**
   * Because of type erasure creating a <code>new Map<Edge, Edge>[size]</code> ojbect  is not possible.
   * Only store Map<Edge, Edge> instances into this array!
   * <pre>
   * nodes[5] = new HashMap<Edge, Edge>();
   * </pre>
   * Use {@link getEdges())} 
   * <pre>
   * Map<Edge, Edge> edges = getEdges(5);
   * </pre>
   * or the cast operator for read access.
   * <pre>
   * @SuppressWarnings("unchecked")
   * Map<Edge, Edge> map = ( Map<Edge, Edge> ) node[5];
   * </pre>
   */
  protected Object[] nodes; 

  
  /**
   * Returns all Edges with the minimal given <code>node</node>.
   * @param node  0 <= node < size
   */
  @SuppressWarnings("unchecked")
  protected Map<Edge, Edge> getEdges(int node) {
    return ( Map<Edge, Edge> ) nodes[node];
  }
  /**
   * Creates a Graph with nodes <code>0, 1, ..., size-1</code>
   * and no edges.
   * @param size a positive integer value
   * @throws ArrayIndexOutOfBoundsException if size is negative
   */
  public AbstractGraph(int size) {
    nodes = new Object[size];
  }
  
  @Override
  public Edge[] getEdges() {
    List<Edge> edges = getEdgesList();
    return edges.toArray(new Edge[edges.size()]);
  }
}
