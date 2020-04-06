package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Keypressevent {

	@Test
	public void keyEventTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagxs\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Key Presses']")).click();
		
		WebElement textBox = driver.findElement(By.id("target"));
		
		textBox.sendKeys(Keys.TAB);
		WebElement target=driver.findElement(By.id("result"));
		String tabResult="You entered: TAB";
		Assert.assertEquals(target.getText(), tabResult);
		
		textBox.sendKeys(Keys.CONTROL);
		String controlResult="You entered: CONTROL";
		Assert.assertEquals(target.getText(), controlResult);
		
		textBox.sendKeys(Keys.ESCAPE);
		String escapeResult="You entered: ESCAPE";
		Assert.assertEquals(target.getText(), escapeResult);
		
		textBox.sendKeys(Keys.ALT);
		String altResult="You entered: ALT";
		Assert.assertEquals(target.getText(), altResult);
		System.out.println("Test 3 Passed");
		driver.quit();
			
	}

}
