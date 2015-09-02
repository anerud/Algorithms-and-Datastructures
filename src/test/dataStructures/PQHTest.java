package test.dataStructures;

import java.util.ArrayList;
import java.util.Collections;

import dataStructures.collections.PriorityQueueHeap;

public class PQHTest {
	
	public static void main(String[] args){
		
		//Testing inserting and popping predetermined numbers in specific order
		int n = 15;
		PriorityQueueHeap<Integer> q = new PriorityQueueHeap<>(n);
		for(int i=0; i < n; i++) {
			int x = (n-i)*2;
			System.out.println("Inserting: " + x);
			q.insert(x);
		}
		for(int i=0; i < n; i++) {
			int x = 2*i+1;
			System.out.println("Inserting: " + x);
			q.insert(x);
		}
		
		while(q.hasNext()) {
			System.out.println("Polling: " + q.poll());
		}
		
		System.out.println("---");
		
		// A large quantity of random numbers
		n = 1000000;
		ArrayList<Integer> l1 = new ArrayList<>(n);
		ArrayList<Integer> l2 = new ArrayList<>(n);
		for(int i = 0; i < n; i++){
			int x = (int) (-n + Math.random()*2*n + 0.5); //Number between approx -n and n
			l1.add(x);
			l2.add(x);
		}
		
		long t1 = System.currentTimeMillis();
		PriorityQueueHeap.sort(l1); //Very inefficient way of sorting, but still works.
		System.out.println("Time elapsed sorting with PQ.sort(): " + (System.currentTimeMillis() - t1) + "ms");
		
		long t2 = System.currentTimeMillis();
		Collections.sort(l2);
		System.out.println("Time elapsed sorting with Collections.sort(): " + (System.currentTimeMillis() - t2) + "ms");
		
		boolean assertTrue = true;
		for(int i = 0; i < l1.size(); i++) {
			assertTrue &= l1.get(i).equals(l2.get(i));
		}
		
		System.out.println("Sorting with PQ gave same results as sorting with Collections: " + assertTrue);
	}
	
}

