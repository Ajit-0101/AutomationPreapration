package advancetestng;

import org.testng.annotations.Test;

public class GroupExamples2 {
	@Test(groups = "Regression")
	public void testLogin() {
		System.out.println("I am login method - And in Regression Group");
	}

	@Test(groups = "Sanity Test")
	public void testSignIn() {
		System.out.println("I am Signin method - And in Sanity Group");
	}

	@Test(groups = "Smoke Test")
	public void testPIM() {
		System.out.println("I am PIM method - And in Smoke Test Group");
	}

	@Test(groups = "Regression")
	public void testLeads() {
		System.out.println("I am Leads method - And in Regression Group");
	}

	@Test(groups = "Smoke Test")
	public void testTask() {
		System.out.println("I am task method - And in Smoke Test Group");
	}
}