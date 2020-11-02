package TestPlan;

public class TestPlan2 {
	String testEnv = "TestPlan2_Env";
	String scope = "TestPlan2_scope";

	public void testCycle3() {

		System.out.println(this.testEnv);
		System.out.println(this.scope);
	}

	public void testCycle4() {
		System.out.println(this.testEnv);
		System.out.println(this.scope);
	}
}
