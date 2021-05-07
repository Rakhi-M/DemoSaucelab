package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestOnSauceLabs {
	
	public WebDriver driver;
	String url="https://sauce-user:552ff3c3-7445-4ede-9a0c-f38f5ab9b6f2@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	@BeforeClass
	@Parameters({ "browser","version","platform" })
	public void setUp(String br,String vr,String pf) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("browserName",br);
		cap.setCapability("version",vr);
		cap.setCapability("platform",pf);
		driver=new RemoteWebDriver(new URL(url),cap);
		
	}
	
	@Test
	public void testTitle() {
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google","Title not matched");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
