package testNGs.cars;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TataMotors {
	@Test(groups = "functionality")
	public void lauch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.tatamotors.com/");
		Reporter.log("TATA MOTORS launched", true);
		driver.close();

	}
}
