package TestPlan;

public class TestPlan1 {
	String testEnv = "TestPlan_Env";
	String scope = "TestPlan_scope";

	public void testCycle1() {
		System.out.println(this.testEnv);
		System.out.println(this.scope);
	}

	public void testCycle2() {
		System.out.println(this.testEnv);
		System.out.println(this.scope);

	}

}
