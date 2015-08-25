package test.algorithms;

import algorithms.travelingSalesmanProblem.TSPviaHeldKarp;

public class TSPviaHeldKarpTest {

	public static void main(String[] args) {
		
		//Data from comments section at: http://stackoverflow.com/questions/11007355/data-for-simple-tsp
		double[][] distances = new double[][]{{0,  29,  20,  21,  16,  31,  100, 12,  4,   31,  18},
											 {29,  0,   15,  29,  28,  40,  72,  21,  29,  41,  12},
											 {20  ,15,  0 ,  15 , 14 , 25,  81 , 9 ,  23 , 27 , 13},
											 {21  ,29,  15,  0 ,  4 ,  12,  92 , 12 , 25,  13,  25},
											 {16 , 28 , 14 , 4 ,  0,   16,  94 , 9 ,  20,  16,  22},
											 {31,  40 , 25 , 12 , 16 , 0 ,  95 , 24,  36,  3,   37},
											 {100, 72,  81,  92,  94,  95,  0,   90,  101, 99,  84},
											 {12,  21,  9 ,  12 , 9 ,  24,  90 , 0 ,  15 , 25,  13},
											 {4,   29 , 23 , 25 ,20 , 36 , 101, 15,  0,   35 , 18},
											 {31,  41 , 27 , 13 , 16 , 3 ,  99 , 25,  35,  0 ,  38},
											 {18,  12 , 13 , 25,  22  ,37 , 84,  13,  18 , 38,  0}};
		
		long t1 = System.currentTimeMillis();
//		distances = new double[20][20];
		TSPviaHeldKarp tsp = new TSPviaHeldKarp(distances);
		System.out.println("Optimal path value: " + tsp.getSolutionValue());
		System.out.println("Optimal path: " + tsp.getSolution());
		System.out.println("Computed in: " + (System.currentTimeMillis() - t1) + " ms.");
	}
}
