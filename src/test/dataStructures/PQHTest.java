package test.dataStructures;

import dataStructures.collections.PriorityQueueHeap;

public class PQHTest {
	
	public static void main(String[] args){
		int n = 15;
		PriorityQueueHeap<Integer> q = new PriorityQueueHeap<>(n);
		for(int i=0; i < n; i++) {
			Integer x = (n-i)*2;
			System.out.println("Inserting: " + x);
			q.insert(x);
		}
		for(int i=0; i < n; i++) {
			Integer x = 2*i+1;
			System.out.println("Inserting: " + x);
			q.insert(x);
		}
		
		while(q.hasNext()) {
			System.out.println("Polling: " + q.poll());
		}
	}
	
}

