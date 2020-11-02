package TestCycles;

import TestPlan.TestPlan2;

public abstract class TestCycle4 extends TestPlan2{

	public String requirements = "TestCycle4_req";

	public void testCycle1() {

		super.testCycle4();
		System.out.println("TestCycle4_implemetation");
		System.out.println(requirements);
	}
	protected TestCycle4(){
		testCycle4();
	}
}
