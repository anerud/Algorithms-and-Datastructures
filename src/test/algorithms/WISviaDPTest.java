package test.algorithms;

import algorithms.weightedIntervalScheduling.WeightedIntervalSchedulingViaDP;


public class WISviaDPTest {
	
	public static void main(String[] args) {
		double v[] = {2,4,4,7,2,1};
		int p[] = {0,0,1,0,3,3};
		WeightedIntervalSchedulingViaDP wis = new WeightedIntervalSchedulingViaDP(v, p);
		System.out.println(wis.getSolution());
		System.out.println(wis.getSolutionValue());
		
		v = new double[]{5,6,5,1};
		p = new int[]{0,0,1,2};
		wis = new WeightedIntervalSchedulingViaDP(v, p);
		System.out.println(wis.getSolution());
		System.out.println(wis.getSolutionValue());
	}

}
