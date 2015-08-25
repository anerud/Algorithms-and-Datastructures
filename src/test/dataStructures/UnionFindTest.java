package test.dataStructures;

import java.util.HashSet;
import java.util.Set;

import dataStructures.collections.UnionFind;

public class UnionFindTest {
	
	public static void main(String[] args){
		Set<String> elements = new HashSet<String>();
		for(int i = 0; i < 10; i++) {
			elements.add("Element " + i);
		}
		UnionFind<String> uf = new UnionFind<String>(elements);
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
		
		System.out.println("");
		uf.Union("Element 0", "Element 9");
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
		
		System.out.println("");
		uf.Union("Element 0", "Element 8");
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
		
		System.out.println("");
		uf.Union("Element 1", "Element 2");
		uf.Union("Element 2", "Element 3");
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
		
		System.out.println("");
		uf.Union("Element 6", "Element 5");
		uf.Union("Element 4", "Element 5");
		uf.Union("Element 7", "Element 6");
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
		
		System.out.println("");
		uf.Union("Element 6", "Element 9");
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
		
		System.out.println("");
		uf.Union("Element 3", "Element 4");
		for(int i = 0; i < 10; i++) {
			System.out.println("Element " + i + " id: " + uf.find("Element " + i));
		}
	}

}
