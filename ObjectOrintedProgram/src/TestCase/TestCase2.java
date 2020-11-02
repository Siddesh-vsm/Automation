package TestCase;

import TestCycles.TestCycle1;

public class TestCase2 extends  TestCycle1 {
	public static String Author = "Testcase2_Author";
	public static String condition = "Testcase2_cond";

	public  TestCase2( ) {
		super();
		System.out.println("Steps for testcase2");
		System.out.println("Results_2");
		System.out.println(Author);
		System.out.println(condition);
		
	}
	
}
