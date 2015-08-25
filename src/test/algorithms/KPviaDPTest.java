package test.algorithms;

import java.util.List;

import algorithms.knapsackProblem.KnapsackProblemViaDP;

public class KPviaDPTest {
	
	public static void main(String[] args) {
		//Data set from http://rosettacode.org/wiki/Knapsack_problem/Bounded
		double[] values = {150,35,200,200,200,60,60,60,60,45,45,45,60,60,60,40,40,40,30,10,10,10,70,30,15,15,10,10,40,70,75,80,20,12,12,50,10,10};
		int[] weights = {9,13,153,153,153,50,50,15,15,68,68,68,27,27,27,39,39,39,23,52,52,52,11,32,24,24,48,48,73,42,43,22,7,18,18,4,30,30};
		String[] names = {"map","compass","water","water","water","sandwich","sandwich", 
				"glucose", "glucose","tin","tin","tin","banana","banana","banana",
				"apple","apple","apple","cheese", "beer", "beer", "beer", "suntan cream", 
				"camera", "t-shirt", "t-shirt", "trousers", "trousers", "umbrella",
				"waterproof trousers", "waterproof overclothes","note-case","sunglasses",
				"towel", "towel", "socks", "book", "book"};
		int capacity = 400;
		KnapsackProblemViaDP kp = new KnapsackProblemViaDP(values, weights, capacity);
		List<Integer> solution = kp.getSolution();
		
		System.out.println("Things to pack in the knapsack:");
		for(int i = solution.size()-1; i>=0; i--) {
			System.out.println("- " + names[solution.get(i)-1]);
		}
		
		System.out.println("Total value: " + kp.getSolutionValue());
	}


}
