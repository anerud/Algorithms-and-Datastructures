package util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CombinationGenerator implements Iterator<List<Integer>> {
	
		private int n;
		private int k;
		private int[] pointers;
		private boolean hasNext;
		
		/**
		 * Creates an object where one can iterate through all k size combinations of integers 0,...,n-1.
		 * @param n the number of integers in the combination
		 * @param k the size of smallest subset
		 */
		public CombinationGenerator(int n, int k) {
			this.n = n;
			this.k = k;
			reset();
		}
		
		private void reset(){
			hasNext = true;
			pointers = new int[k];
			for(int i = 0; i < k; i++) {
				pointers[i] = i;
			}
		}
		
		/**
		 * Using k pointers which points at the integers 0,...,n-1. Each time this function is called
		 * the rightmost pointer is incremented. If the rightmost pointer exceeds its max position
		 * the pointer to the left of it should be incremented and the rightmost pointer should be reset
		 * to its minimum position. If in turn the pointer to the left of the rightmost pointer exceeded its max position
		 * then the pointer to the left of it should also be incremented and so on... The last combination is reached
		 * when the leftmost pointer has exceeded its max position.
		 * @return then next combination if there is any, else it returns the last combination
		 */
		public List<Integer> next(){
			//Construct current combination for return at the end
			List<Integer> nextCombination = new LinkedList<>();
			for (Integer i : pointers) {
				nextCombination.add(i);
			}

			//Find out the leftmost carry
			int pointerWithCarry = k-1;
			while(pointerWithCarry >= 0 && pointers[pointerWithCarry] >= n-(k-pointerWithCarry)) {
				pointerWithCarry--;
			}
			
			//The leftmost pointer has reached max pos --> There are no more combinations
			if(pointerWithCarry < 0) {
				hasNext = false;
				return nextCombination;
			}
			
			//Given the leftmost carry, increment it and reset the pointers to the right of it
			pointers[pointerWithCarry]++;
			for(int i = pointerWithCarry + 1; i < k; i++) {
				pointers[i] = pointers[i-1]+1;
			}
			
			//return current comb
			return nextCombination;
		}
		
		/**
		 * @return true if there are more combinations, false if not.
		 */
		public boolean hasNext(){
			return hasNext;
		}
		

}
