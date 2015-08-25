package test.util;

import util.CombinationGenerator;

public class CombGenTest {
	
	public static void main(String[] args) {
		CombinationGenerator cg = new CombinationGenerator(6, 3);
		while(cg.hasNext()) {
			System.out.println(cg.next());
		}
	}

}
