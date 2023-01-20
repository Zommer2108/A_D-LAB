package de.hska.iwi.ads.graph;

import java.util.List;

/**
 * Abstract data type for an edge weighted undirected graph.
 * The nodes are given by integer numbers.
 */
public interface Graph {

  /**
   * Abstract data type for an undirected weighted edge
   * from a node1 to a node2.
   * The nodes are given by integer numbers.
   */
  public interface Edge extends Comparable<Edge> {

    public class EdgeImpl implements Edge {
      
      private int weight;
      
      private int node1;
      
      private int node2;
      
      public EdgeImpl(int node1, int node2, int weight) {
        this.node1 = Math.min(node1, node2);
        this.node2 = Math.max(node1, node2);
        this.weight = weight;
      }
      
      @Override
      public int getWeight() {
        return this.weight;
      }
      
      /**
       * Returns the  smallest node number.
       */
      @Override
      public int getNode1() {
        return this.node1;
      }
      
      /**
       * Returns the largest node number.
       */
      @Override
      public int getNode2() {
        return this.node2;
      }
    }
    
    /**
     * Returns the weight associated to this Edge.
     */
    public int getWeight();
    
    /**
     * Returns the node with the smallest number.
     */
    int getNode1();

    /**
     * Returns the node with the largest number.
     */
    int getNode2();
    
    /**
     * Note: The natural ordering is inconsistent with equals.
     * 
     * edge1.compareTo(edge2) == o does not imply edge1.equals(edge2) == true
     */
    @Override
    default int compareTo(Edge edge) {
       return this.getWeight() - edge.getWeight();
    }
  }

  void add(Edge edge);
 
  /**
   Returns all edges of this graph in any order in a newly generated
   List.
   */
  List<Edge> getEdgesList();
  
  /**
   * Returns all edges of this graph in any order in a newly
   * generated array.
   */
  Edge [] getEdges();
  
  /**
   * Returns a graph representing a minimal spanning tree of this graph.
   */
  Graph getMinimalSpaningTree();
  
}
