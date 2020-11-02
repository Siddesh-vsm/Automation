package TestCycles;


import TestPlan.TestPlan1;

public abstract class TestCycle2 extends TestPlan1 {

	
	public String requirements = "TestCycle2_req";

	public void testCycle2() {

		super.testCycle1();
		System.out.println("TestCycle2_implemetation");
		System.out.println(requirements);
	}
	protected TestCycle2(){
		testCycle2();
	}
	

}
