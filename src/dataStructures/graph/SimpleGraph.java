package dataStructures.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleGraph<T> {
	
	private List<SimpleNode<T>> nodes;
	private LinkedList<SimpleNode<T>> bfsQ;
	private LinkedList<SimpleNode<T>> dfsQ;
	
	public SimpleGraph(){
		nodes = new LinkedList<SimpleNode<T>>();
		bfsQ = new LinkedList<SimpleNode<T>>();
		dfsQ = new LinkedList<SimpleNode<T>>();
	}
	
	public SimpleGraph(List<SimpleNode<T>> nodes){
		this.nodes = new LinkedList<SimpleNode<T>>();
		this.nodes.addAll(nodes);
		bfsQ = new LinkedList<SimpleNode<T>>();
		dfsQ = new LinkedList<SimpleNode<T>>();
	}
	
	public void addNode(SimpleNode<T> node) {
		nodes.add(node);
	}
	
	public void resetBFS(SimpleNode<T> startNode){
		bfsQ.clear();
		bfsQ.add(startNode);
	}
	
	public void resetBFS(){
		bfsQ.clear();
		bfsQ.add(nodes.get(0));
	}
	
	public void resetDFS(SimpleNode<T> startNode){
		dfsQ.clear();
		dfsQ.add(startNode);
	}
	
	public void resetDFS(){
		dfsQ.clear();
		dfsQ.add(nodes.get(0));
	}
	
	public boolean hasNextBFSNode(){
		return !bfsQ.isEmpty();
	}
	
	public boolean hasNextDFSNode(){
		return !dfsQ.isEmpty();
	}
	
	public SimpleNode<T> nextBFSNode(){
		SimpleNode<T> node = bfsQ.poll();
		for(SimpleNode<T> n : node.getNeighbours()) {
			bfsQ.addLast(n);
		}
		return node;
	}
	
	public SimpleNode<T> nextDFSNode(){
		SimpleNode<T> node = dfsQ.poll();
		Iterator<SimpleNode<T>> it = node.getNeighbours().descendingIterator();
		while(it.hasNext()) {
			dfsQ.addFirst(it.next());
		}
		return node;
	}
	
}
