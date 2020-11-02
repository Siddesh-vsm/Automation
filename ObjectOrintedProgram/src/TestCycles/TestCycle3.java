package TestCycles;

import TestPlan.TestPlan2;

public abstract class TestCycle3 extends TestPlan2 {

	public String requirements = "TestCycle3_req";

	public void testCycle3() {

		super.testCycle3();
		System.out.println("TestCycle3_implemetation");
		System.out.println(requirements);
	}
	protected TestCycle3(){
		testCycle3();
	}
}
