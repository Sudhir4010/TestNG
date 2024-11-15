package testNGs.assignments;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assignment1 {
	@Test(invocationCount = 2, priority = -1)
	public void createAccount() {
		Reporter.log("Account has been created.", true);
	}
	
	@Test(priority = 3)
	public void deleteAccount() {
		Reporter.log("Account deleted", true);
	}
	
	@Test(invocationCount = 3, threadPoolSize = 3,priority = 2)
	public void  editAccount() {
		Reporter.log("details have beed updated.", true);
	}
}
