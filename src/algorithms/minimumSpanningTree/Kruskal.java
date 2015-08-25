package algorithms.minimumSpanningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import dataStructures.collections.UnionFind;

public class Kruskal {
	
	private List<KruskalEdge> edges;
	private List<KruskalEdge> solution;
	private PriorityQueue<KruskalEdge> Q;
	private UnionFind<Integer> uf;
	private int nNodes;
	
	public Kruskal(List<KruskalEdge> edges, int nNodes){
		this.edges = edges;
		this.nNodes = nNodes;
		run();
	}
	
	private void run(){
		//Create new union-find structure for cycle checking
		Set<Integer> S = new HashSet<Integer>();
		for(int i = 0; i < nNodes; i++) {
			S.add(i);
		}
		uf = new UnionFind<Integer>(S);
		
		//Sort all edges
		for(KruskalEdge e : edges) {
			Q.add(e);
		}
		
		//Get solution
		solution = new ArrayList<KruskalEdge>();
		while(solution.size() < nNodes-1 && !Q.isEmpty()) {
			KruskalEdge e = Q.poll();
			if(uf.find(e.u) != uf.find(e.v)) { //Cycle check
				solution.add(Q.poll());
				uf.Union(e.u, e.v);
			}
		}
	}
	
	public class KruskalEdge implements Comparable<KruskalEdge>{
		private int u;
		private int v;
		private double value;
		
		public KruskalEdge(int u, int v, int value){
			this.u = u;
			this.v = v;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof KruskalEdge) {
				KruskalEdge e = (KruskalEdge) o;
				return e.u == this.u && e.v == this.v;
			}
			return false;
		}

		@Override
		public int compareTo(KruskalEdge e) {
			return Double.compare(value, e.value);
		}
		
	}

}
