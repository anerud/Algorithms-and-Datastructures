package algorithms.weightedIntervalScheduling;

import java.util.ArrayList;
import java.util.List;

public class WeightedIntervalSchedulingViaDP {
	
	private double[] v;
	private int[] p;
	private boolean finished;
	private double M[];
	
	/**
	 * An instance of the Weighted Interval Scheduling problem. 
	 * Note that v and p should both be ordered s.t:
	 * f_1 <= f_2 <= ... <= f_n, where f_i is the finish time of interval i.
	 * Note that intervals are indexed 1,...,n in any output functions
	 * and not 0,..,n-1 as in the input arrays.
	 * @param v a vector interval weights
	 * @param p a vector of predecessors
	 */
	public WeightedIntervalSchedulingViaDP(double[] v, int[] p){
		if(v.length != p.length) {
			throw new IllegalArgumentException("Length of v and p must be the same");
		}
		this.v = v;
		this.p = p;
		M = new double[v.length+1];
	}
	
	private void run(){
		// DP starts
		for(int i = 1; i < M.length; i++) {
			M[i] = Math.max(v[i-1] + M[p[i-1]], M[i-1]);
		}
		finished = true;
	}
	
	private List<Integer> findSolution(int i, List<Integer> solution) {
		//Base case
		if(i <= 0) {
			return solution;
		}
		if(v[i-1] + M[p[i-1]] >= M[i-1] ) {
			// i is in the solution
			solution.add(i);
			return findSolution(p[i-1], solution);
		} else {
			// i not in solution, try i-1
			return findSolution(i-1,solution);
		}
	}
	
	/**
	 * Note that the indexes returned are based on the interval having
	 * indexes 1,...,n and not 0,...,n-1. This means that
	 * index i in the returned list correspond to index i-1 in the input arrays.
	 * @return returns a list of the interval indexes in the optimal solution.
	 */
	public List<Integer> getSolution(){
		if(!finished) {
			run();
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		return findSolution(M.length-1, solution);
	}
	
	public double getSolutionValue(){
		if(!finished) {
			run();
		}
		return M[M.length-1];
	}
	
	
}
