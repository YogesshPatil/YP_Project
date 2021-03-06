import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Grid_2 {
	WebDriver driver;
	String baseUrl, nodeURL;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		baseUrl = "http://newtours.demoaut.com";
		nodeURL = "http://192.168.0.109:5566/wd/hub";
		DesiredCapabilities capablity = DesiredCapabilities.chrome();
		capablity.setBrowserName("chrome");
		capablity.setPlatform(Platform.VISTA);
		driver = new RemoteWebDriver(new URL(nodeURL), capablity);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test
	public void simpleTest() {
		driver.get(baseUrl);
		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
	}
	

}
