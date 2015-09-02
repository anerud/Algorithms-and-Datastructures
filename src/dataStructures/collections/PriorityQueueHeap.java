package dataStructures.collections;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueHeap<T extends Comparable<T>> {
	
	private ArrayList<T> tree;
	private int lastIndex;
	
	public PriorityQueueHeap(){
		tree = new ArrayList<T>();
	}
	
	public PriorityQueueHeap(int capacity){
		tree = new ArrayList<T>(capacity);
	}
	
	/**
	 * 
	 * @param e inserts e into the queue
	 * @return true
	 */
	public boolean insert(T e) {
		//Add it last
		tree.add(lastIndex, e);
		bubbleUp(lastIndex);
		lastIndex++;
		return true;
	}
	
	private void bubbleUp(int i) {
		int parent = (i-1)/2;
		if(i <= 0 || tree.get(i).compareTo(tree.get(parent)) >= 0) {
			return;
		}
		swap(parent,i);
		bubbleUp(parent);
	}
	
	private void bubbleDown(int i) {
		int left = 2*i+1;
		if(left >= lastIndex) {
			//i is leaf node
			return;
		}
		
		int minChild;
		
		int right = 2*i+2;
		if(right >= lastIndex) {
			//i only have left children
			minChild = left;
		} else {
			//both children are present
			minChild = tree.get(left).compareTo(tree.get(right)) <= 0 ? left : right;
		}
		
		//if i is larger than it's smallest children, swap places and call recursively. Else it is in the right place.
		if(tree.get(i).compareTo(tree.get(minChild)) > 0) {
			swap(i,minChild);
			bubbleDown(minChild);
		}
	}
	
	private void swap(int i, int j) {
		T tmp = tree.get(j);
		tree.set(j, tree.get(i));
		tree.set(i, tmp);
	}

	/**
	 * 
	 * @return null if queue is empty, else the first element in queue.
	 */
	public T poll(){
		//Empty queue
		if(lastIndex <= 0) {
			return null;
		}
		
		//1 element in queue
		if(lastIndex == 1) {
			lastIndex--;
			return tree.remove(0);
		}
		
		//More than 1 element in queue
		T firstElem = tree.get(0);
		
		//Remove the last element and set it to root
		tree.set(0, tree.remove(lastIndex-1));
		lastIndex--;
		
		//Then bubble down the root
		bubbleDown(0);
		return firstElem;
	}

	public boolean hasNext() {
		return lastIndex > 0;
	}
	
	public ArrayList<T> getTree(){
		return tree;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		int limit = 1;
		for(int i = 0; i < tree.size(); i++) {
			sb.append(tree.get(i));
			sb.append("\t");
			counter++;
			if(counter >= limit) {
				counter = 0;
				sb.append("\n");
				limit *= 2;
			}
		}
		return sb.toString();
	}
	
	public static <T extends Comparable<T>> void sort(List<T> l) {
		PriorityQueueHeap<T> q = new PriorityQueueHeap<T>(l.size());
		for(T t : l) {
			q.insert(t);
		}
		l.clear();
		while(q.hasNext()) {
			l.add(q.poll());
		}
	}
}
