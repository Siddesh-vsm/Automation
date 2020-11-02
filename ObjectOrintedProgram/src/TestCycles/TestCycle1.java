package TestCycles;

import TestPlan.TestPlan1;

public abstract class TestCycle1 extends TestPlan1 {

	public String requirements = "TestCycle1_req";

	public void testCycle1() {

		super.testCycle1();
		System.out.println("TestCycle1_implemetation");
		System.out.println(requirements);
	}
	protected TestCycle1(){
		testCycle1();
	}

}
