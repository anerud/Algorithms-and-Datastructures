package algorithms.knapsackProblem;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblemViaDP {
	
	private double[] values;
	private int[] weights;
	private int capacity;
	private double[][] M;
	private boolean finished;
	
	public KnapsackProblemViaDP(double[] values,int[] weights, int capacity){
		if(values.length != weights.length) {
			throw new IllegalArgumentException("The length of values and weights must be the same "
					+ "(values.length = " + values.length + " and weights.length = " + weights.length);
		}
		if(capacity < 1) {
			throw new IllegalArgumentException("The capacity of the knapsack must be greater than 0");
		}
		this.values = values;
		this.weights = weights;
		this.capacity = capacity;
		M = new double[values.length+1][capacity+1];
	}

	private void run(){
		for(int i = 1; i < M.length; i++) {
			for(int w = 1; w < M[0].length; w++) {
				if(w < weights[i-1]) {
					M[i][w] = M[i-1][w];
				} else {
					M[i][w] = Math.max(M[i-1][w], values[i-1] + M[i-1][w-weights[i-1]]);
				}
			}
		}
		finished = true;
	}
	
	private List<Integer> findSolution(int i, int w,List<Integer> solution){
		if(i <= 0) {
			return solution;
		}
		if(w >= weights[i-1] && M[i-1][w] <= values[i-1] + M[i-1][w-weights[i-1]]) {
			//i is in solution
			solution.add(i);
			return findSolution(i-1, w-weights[i-1], solution);
		} else {
			return findSolution(i-1, w, solution);
		}
	}
	
	public List<Integer> getSolution(){
		if(!finished) {
			run();
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		return findSolution(M.length-1, capacity, solution);
	}
	
	public double getSolutionValue(){
		if(!finished) {
			run();
		}
		return M[values.length][capacity];
	}
	
}
