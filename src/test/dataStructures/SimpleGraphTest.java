package test.dataStructures;

import java.util.LinkedList;
import java.util.List;

import dataStructures.graph.SimpleGraph;
import dataStructures.graph.SimpleNode;

public class SimpleGraphTest {
	
	public static void main(String[] args){
		//7 Test nodes is simple binary tree structure
		SimpleNode<Integer> n1 = new SimpleNode<Integer>(1);
		SimpleNode<Integer> n2 = new SimpleNode<Integer>(2);
		SimpleNode<Integer> n3 = new SimpleNode<Integer>(3);
		SimpleNode<Integer> n4 = new SimpleNode<Integer>(4);
		SimpleNode<Integer> n5 = new SimpleNode<Integer>(5);
		SimpleNode<Integer> n6 = new SimpleNode<Integer>(6);
		SimpleNode<Integer> n7 = new SimpleNode<Integer>(7);
		
		n1.addNeighbour(n2); n1.addNeighbour(n3);
		n2.addNeighbour(n4); n2.addNeighbour(n5);
		n3.addNeighbour(n6); n3.addNeighbour(n7);
		
		List<SimpleNode<Integer>> nodes = new LinkedList<SimpleNode<Integer>>();
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		nodes.add(n6);
		nodes.add(n7);
		SimpleGraph<Integer> g = new SimpleGraph<Integer>(nodes);
		
		//BFS
		g.resetBFS();
		System.out.println("BFS:");
		while(g.hasNextBFSNode()) {
			System.out.println(g.nextBFSNode().getData());
		}
		System.out.println("\nDFS:");
		g.resetDFS();
		while(g.hasNextDFSNode()) {
			System.out.println(g.nextDFSNode().getData());
		}
	}

}
