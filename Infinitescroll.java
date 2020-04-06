package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Infinitescroll {
	@Test
	public void infinitescroll() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagxs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Infinite Scroll']")).click();
		Actions a=new Actions(driver);
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		String actualText=driver.findElement(By.xpath("//*[text()='Infinite Scroll']")).getText();
		System.out.println(actualText);
		String expectedText="Infinite Scroll";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Test 2 Passed");
		driver.quit();
	}
}
