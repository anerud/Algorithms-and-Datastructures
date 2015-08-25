package dataStructures.graph;

import java.util.LinkedList;

public class SimpleNode<T> {
	private T data;
	private LinkedList<SimpleNode<T>> neighbours;
	
	public SimpleNode(T data){
		this.data = data;
		neighbours = new LinkedList<SimpleNode<T>>();
	}
	
	public SimpleNode(T data, LinkedList<SimpleNode<T>> neighbours){
		this.data = data;
		this.neighbours = neighbours;	
	}
	
	public void addNeighbour(SimpleNode<T> n) {
		neighbours.add(n);
	}
	
	public void addNeighbours(LinkedList<SimpleNode<T>> nodes) {
		neighbours.addAll(nodes);
	}
	
	public void removeNeighbour(SimpleNode<T> n) {
		neighbours.remove(n);
	}
	
	public LinkedList<SimpleNode<T>> getNeighbours(){
		return neighbours;
	}
	
	public T getData(){
		return data;
	}
}
