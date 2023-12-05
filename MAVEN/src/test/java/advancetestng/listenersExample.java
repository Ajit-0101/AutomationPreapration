package advancetestng;

import org.testng.annotations.Test;

public class listenersExample {
  
  @Test(enabled=true)
	public void createPIM() {
		int i=10/0;
		System.out.println("PIM is created...");
	}
	@Test(enabled=true)
	public void updatePIM() {
		System.out.println("updated PIM ....");
	}
}
