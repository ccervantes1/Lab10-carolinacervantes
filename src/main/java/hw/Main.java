package hw;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

public class Main {

  public static void main(final String[] args) {
    final String UA = CountryCodes.UA;
    final String BY = CountryCodes.BY;
    final String PL = CountryCodes.PL;
    final String HU = CountryCodes.HU;
    final String RO = CountryCodes.RO;
    final String MD = CountryCodes.MD;

    final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

    // Add vertices for 5 countries
    myMap.addVertex(UA);
    myMap.addVertex(BY);
    myMap.addVertex(PL);
    myMap.addVertex(HU);
    myMap.addVertex(RO);
    myMap.addVertex(MD);

    // Add edges for 5 countries that share a border with Ukraine
    myMap.addEdge(UA, BY);
    myMap.addEdge(UA, PL);
    myMap.addEdge(UA, HU);
    myMap.addEdge(UA, RO);
    myMap.addEdge(UA, MD);

    // Belarus also shares an edge with Poland
    myMap.addEdge(BY, PL);

    // Hungary also shares an edge with Romania
    myMap.addEdge(HU, RO);

    // Romania also shares an edge with Moldova
    myMap.addEdge(RO, MD);

    // Print the map
    System.out.println(myMap);

    final Iterator<String> bf = new BreadthFirstIterator<>(myMap, UA);
    while (bf.hasNext()) {
      final String state = bf.next();
      System.out.println(state);
    }

  /*  final Iterator<String> cf = new ClosestFirstIterator<>(myMap, UA);
    while (cf.hasNext()) {
      final String state = cf.next();
      System.out.println(state);
    }



    final Iterator<String> df = new DepthFirstIterator<>(myMap, UA);
    while (df.hasNext()) {
      final String state = df.next();
      System.out.println(state);
    }


    final Iterator<String> rw = new RandomWalkIterator<>(myMap, UA);
    while (rw.hasNext()) {
      final String state = rw.next();
      System.out.println(state);
    }
*/
    GreedyColoring graph = new GreedyColoring(myMap);

    System.out.println(graph.getColoring());
  }
}
