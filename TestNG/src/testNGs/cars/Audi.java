package testNGs.cars;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Audi {
	@Test(groups = "smoke")
	public void lauch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.audi.in/in/web/en/models.html");
		Reporter.log("Audi launched", true);
//		driver.close();

	}

}
