package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Entireproject {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagxs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com");
	}

	@Test(priority = 1)
	public void login() {
		// Test case 1 Scenario 1
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Form Authentication']")).click();
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.cssSelector(".radius")).click();
		String actualError1 = driver.findElement(By.id("flash")).getText();
		String expectedError1 = "Your password is invalid!";
		Assert.assertTrue(actualError1.contains(expectedError1));

		// Test case 1 Scenario 2
		driver.findElement(By.id("username")).sendKeys("abcxyz");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector(".radius")).click();
		String actualError2 = driver.findElement(By.id("flash")).getText();
		String expectedError2 = "Your username is invalid!";
		Assert.assertTrue(actualError2.contains(expectedError2));

		// Test case 1 Scenario 3
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector(".radius")).click();
		driver.findElement(By.cssSelector(".button.secondary.radius")).click();
		System.out.println("Test Case 1 Passed");
	}

	@Test(priority = 2)
	public void infiniteScroll() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Infinite Scroll']")).click();
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		String actualText = driver.findElement(By.xpath("//*[text()='Infinite Scroll']")).getText();
		System.out.println(actualText);
		String expectedText = "Infinite Scroll";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Test Case 2 Passed");
	}

	@Test(priority = 3)
	public void keypressesEvent() {

		driver.findElement(By.xpath("//*[text()='Key Presses']")).click();

		WebElement textBox = driver.findElement(By.id("target"));

		textBox.sendKeys(Keys.TAB);
		WebElement target = driver.findElement(By.id("result"));
		String tabResult = "You entered: TAB";
		Assert.assertEquals(target.getText(), tabResult);

		textBox.sendKeys(Keys.CONTROL);
		String controlResult = "You entered: CONTROL";
		Assert.assertEquals(target.getText(), controlResult);

		textBox.sendKeys(Keys.ESCAPE);
		String escapeResult = "You entered: ESCAPE";
		Assert.assertEquals(target.getText(), escapeResult);

		textBox.sendKeys(Keys.ALT);
		String altResult = "You entered: ALT";
		Assert.assertEquals(target.getText(), altResult);
		System.out.println("Test Case 3 Passed");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
