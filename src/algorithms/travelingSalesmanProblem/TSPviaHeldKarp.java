package algorithms.travelingSalesmanProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import util.CombinationGenerator;

public class TSPviaHeldKarp {

    private int[] hashCodeExponents;
	private double[][] distances;
	private int n;
	private HashMap<HashableList, HKTuple> M; //The memoization HashMap containing the values and predecessors
	private double optimalValue;
	private List<Integer> optimalSolution;

	/**
	 * This is a solver for the traveling salesman problem using the Held-Karp algorithm.
	 * @param distances a matrix of all pairwise distances: distances[i][j] is the distance
	 * to travel from j to i. The distance matrix does not have to be symmetric.
	 */
	public TSPviaHeldKarp(double[][] distances) {
		if(distances.length < 3) {
			throw new IllegalArgumentException("The number of cities must be 3 or more!");
		}
		
		if(distances.length != distances[0].length) {
			throw new IllegalArgumentException("The distance matrix must be square!");
		}

        int exponent = 13;
        this.hashCodeExponents = new int[distances.length - 1];
        hashCodeExponents[0] = exponent;
        for (int i = 1; i < hashCodeExponents.length; i++) {
            hashCodeExponents[i] = hashCodeExponents[i-1] * exponent;
        }
		
		this.distances = distances;
		this.n = distances.length;
		M = new HashMap<>();
		run();
	}
	
	private void run(){
		optimalValue = Double.POSITIVE_INFINITY;
		
		//Assume that one starts and ends in the last node to make indexing simpler...
		//Initiate all subsets of size 2 starting in the last node.
		for(int i = 0; i < n-1; i++) {
			List<Integer> S = new LinkedList<>();
			S.add(i);
			HashableList hl = new HashableList(S,i);
			M.put(hl, new HKTuple(distances[i][n-1], n-1));
		}
		
		//For all subsets of all sizes...
		for(int k = 2; k < n; k++) {
			CombinationGenerator cg = new CombinationGenerator(n-1, k);
            cg.forEachRemaining(combination -> {
                    for (Integer i : combination) {
                        List<Integer> S_i = new LinkedList<>(combination);
                        S_i.remove(i);
                        double minValue = Double.POSITIVE_INFINITY;
                        int minJ = 0;
                        for (Integer j : S_i) {
                            HashableList hl = new HashableList(S_i, j);
                            double value = M.get(hl).value;
                            if (minValue > value + distances[i][j]) {
                                minValue = value + distances[i][j];
                                minJ = j;
                            }
                        }
                        HashableList hl = new HashableList(combination, i);
                        M.put(hl, new HKTuple(minValue, minJ));
                    }
                }
            );
        }

    //Last step: find our way home
		List<Integer> S = new CombinationGenerator(n-1, n-1).next();
		Integer minI = 0;
		for(int i : S) {
			HashableList hl = new HashableList(S,i);
			double value = M.get(hl).value;
			if(optimalValue > value + distances[n-1][i]) {
				optimalValue = value + distances[n-1][i];
				minI = i;
			}
		}
		
		// Recreate optimal path
		optimalSolution = new LinkedList<>();
		optimalSolution.add(n-1);
		optimalSolution.add(minI);
		while(!S.isEmpty()) {
			HashableList hl = new HashableList(S,minI);
			int j = M.get(hl).predecessor;
			S.remove(minI);
			minI = j;
			optimalSolution.add(minI);
		}
	}
	
	public List<Integer> getSolution(){
		return optimalSolution;
	}
	
	public double getSolutionValue(){
		return optimalValue;
	}
	
	private class HashableList {
		List<Integer> S;
		int endNode;
		HashableList(List<Integer> S, int i){
			this.S = S;
			endNode = i;
		}

        @Override
		public boolean equals(Object o) {
			HashableList hl = (HashableList) o;
			return hl.endNode == this.endNode && hl.S.equals(this.S);
		}
		
		@Override
		public int hashCode(){
			int hc = endNode;
            int i = 0;
			for(int x : S) {
				hc ^= hashCodeExponents[i] * x;
                i++;
			}
			return hc;
		}
	}
	
	private class HKTuple{
		
		double value;
		int predecessor;
		
		HKTuple(double value, int pre){
			this.value = value;
			predecessor = pre;
		}
		
	}
}
