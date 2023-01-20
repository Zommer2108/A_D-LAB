package de.hska.iwi.ads.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.graph.Graph.Edge;
import de.hska.iwi.ads.graph.Graph.Edge.EdgeImpl;

/**
 * a few tests for Graph implementations
 */
public abstract class GraphTest {

  protected abstract Graph createGraph(int size);
  
  private Graph testGraph;
  
  /**
   ++++ are the edges of the minimal spanning tree
   <pre>
       1       3
   0 +++++ 1 +++++ 2
   +       +       +
 2 +     4 +     5 +
   +   6   +  8    +
   3 ----- 4 ----- 5
   +       +       +
 7 +     9 +    10 +
   +  11   +  12   +
   6 ----- 7 ----- 8
   </pre>
   */
  @BeforeEach
  public void createTestGraph() {
    testGraph = createGraph(9);
    testGraph.add( new EdgeImpl(0, 1, 1) );
    testGraph.add( new EdgeImpl(0, 3, 2) );
    testGraph.add( new EdgeImpl(1, 2, 3) );
    testGraph.add( new EdgeImpl(1, 4, 4) );
    testGraph.add( new EdgeImpl(2, 5, 5) );
    testGraph.add( new EdgeImpl(3, 4, 6) );
    testGraph.add( new EdgeImpl(3, 6, 7) );  
    testGraph.add( new EdgeImpl(4, 5, 8) );
    testGraph.add( new EdgeImpl(4, 7, 9) );  
    testGraph.add( new EdgeImpl(5, 8, 10) );
    testGraph.add( new EdgeImpl(6, 7, 11) );
    testGraph.add( new EdgeImpl(7, 8, 12) );
  }

  @Test
  public void testGraphSize() {
    assertEquals(12, testGraph.getEdgesList().size());
  }

  @Test
  public void testGetMinimalSpaningTree() {
    Graph tree = testGraph.getMinimalSpaningTree();
    Edge [] edges = tree.getEdges();
    assertEquals(8, edges.length);
    Arrays.sort(edges);
    assertEquals(0, edges[0].getNode1());
    assertEquals(1, edges[0].getNode2());
    assertEquals(0, edges[1].getNode1());
    assertEquals(3, edges[1].getNode2());
    assertEquals(1, edges[2].getNode1());
    assertEquals(2, edges[2].getNode2());
    assertEquals(1, edges[3].getNode1());
    assertEquals(4, edges[3].getNode2());
    assertEquals(2, edges[4].getNode1());
    assertEquals(5, edges[4].getNode2());
    assertEquals(3, edges[5].getNode1());
    assertEquals(6, edges[5].getNode2());
    assertEquals(4, edges[6].getNode1());
    assertEquals(7, edges[6].getNode2());
    assertEquals(5, edges[7].getNode1());
    assertEquals(8, edges[7].getNode2());
  }
  
}
