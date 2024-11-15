package testNGs.cars;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RollsRoyce {
	@Test(groups = "integration")
	public void lauch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.rolls-roycemotorcars.com/en_GB/home.html");
		Reporter.log("roll Royce launched", true);
//		driver.close();

	}
}
