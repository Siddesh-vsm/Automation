package TestCase;
import TestCycles.*;


public class Testcase1 extends  TestCycle1{
	public static String Author = "Testcase1_Author";
	public static String condition = "Testcase1_cond";
			
	public  Testcase1( ) {
		super();
		System.out.println("Steps for testcase1");
		System.out.println("Results_1");
		System.out.println(Author);
		System.out.println(condition);
	}

}
