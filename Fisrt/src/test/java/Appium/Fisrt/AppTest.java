package Appium.Fisrt;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppTest<MobileElement> 
{
	AppiumDriver driver;  
	@BeforeTest
	public void setUp() throws MalformedURLException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("PlatformVersion", "11.0");
		caps.setCapability("deviceName", "AndroidEMulator");
		caps.setCapability("appPackage", "com.forsale.forsale");
		caps.setCapability("appActivity", "com.forsale.app.features.maincontainer.LauncherActivity");
		caps.setCapability("noReset", true);
	
		//driver = new AndroidDriver(new URL("https://localhost:4723/wd/hub"), caps);
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

	}
	@Test(priority = 1)
	public void Login() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
     	driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.forsale.forsale:id/navigation_bar_item_icon_view\"])[3]")).click();//postad
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("00000111");
	    driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText")).sendKeys("4saleTest");//mob num
		driver.findElement(By.xpath("//android.view.View[@resource-id='loginBtn']/android.widget.Button")).click();//login
		//driver.findElement(By.id("00000000-0000-001a-ffff-ffff000000b7")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.forsale.forsale:id/chooseCategoryField']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.forsale.forsale:id/tvCategoryName\" and @text='Automotive']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.forsale.forsale:id/tvCategoryName\" and @text='Classic Cars']")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
		String ActualText=driver.findElement(By.xpath("//android.widget.TextView[@text=\"Location information is mandatory\"]")).getText();
		System.out.println(ActualText);
		Assert.assertEquals(ActualText,"Location information is mandatory", "Text does not match");
	}
	@Test(priority = 2)
	public void FillData() {
		driver.findElement(By.id("com.forsale.forsale:id/chooseDistrictField")).click();
		driver.findElement(By.id("com.forsale.forsale:id/locationSelectorText")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Ahmadi\"]")).click();
		driver.findElement(By.id("com.forsale.forsale:id/btnProceed")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Choose Area\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Middle of Ahmadi\"]")).click();
		driver.findElement(By.id("com.forsale.forsale:id/btnProceed")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Done\"]")).click();
		driver.findElement(By.id("com.forsale.forsale:id/adTitleField")).sendKeys("TestAddPost");
		driver.findElement(By.id("com.forsale.forsale:id/adPriceField")).sendKeys("100");
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
		String mediaText = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add Media\"]")).getText();
		System.out.println(mediaText);
		Assert.assertEquals(mediaText,"Add Media", "Text does not match");
		System.out.println("succcessfull test");

	}
	
//	@AfterTest
//	public void tearDown() {
//		if(null!=driver)
//		{
//			driver.quit();
//		}
//	}
}
