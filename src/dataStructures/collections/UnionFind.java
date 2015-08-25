package dataStructures.collections;

import java.util.HashMap;
import java.util.Set;

public class UnionFind<T> {
	
	private HashMap<T, Integer> elements;
	private int[] parent;
	private int[] rank;
	
	/**
	 * Creates a new union set data structure with the members of s as its elements.
	 * No need to call makeSet();
	 * @param s
	 */
	public UnionFind(Set<T> s){
		makeSet(s);
	}
	
	/**
	 * Initiates the union find data structure. This method is automatically called
	 * when creating a new union find via "UnionFind(Set<T> s)".
	 * @param s the set to initiate the union find data structure with.
	 */
	private void makeSet(Set<T> s){
		elements = new HashMap<T, Integer>();
		parent = new int[s.size()];
		rank = new int[s.size()];
		int id = 0;
		for(T x : s){
			elements.put(x, id);
			parent[id] = id;
			id++;
		}
	}
	
	/**
	 * 
	 * @param x the element to find.
	 * @return Returns the positive set-ID of the element x if x is the union find data structure. 
	 */
	public int find(T x){
		Integer tx = elements.get(x);
		if(tx == null) {
			throw new IllegalArgumentException("Element x is not in the set!");
		}
		return findHelper(tx);
	}
	
	/**
	 * Merges the corresponding sets of element x and y.
	 * @param x element x.
	 * @param y element y.
	 */
	public void Union(T x, T y){
		Integer tx = elements.get(x);
		Integer ty = elements.get(y);
		if(tx == null || ty == null) {
			throw new IllegalArgumentException("Either x or y does not exists in the set!");
		}
		int xRoot = findHelper(tx);
		int yRoot = findHelper(ty);
		
		// If they are already in same set
		if (xRoot == yRoot) {
			return;
		}
		
		// Merge and update rank of root
		if(rank[xRoot] > rank[yRoot]) {
			parent[yRoot] = xRoot;
		} else if(rank[xRoot] < rank[yRoot]) {
			parent[xRoot] = yRoot;
		} else {
			parent[yRoot] = xRoot;
			rank[xRoot]++;
		}
	}
	
	private int findHelper(int x){
		if(parent[x] != x) {
			parent[x] = findHelper(parent[x]);
		}
		return parent[x];
	}

}
