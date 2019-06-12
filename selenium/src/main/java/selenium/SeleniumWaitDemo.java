package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) {
		SeleniumWaits();
	}

	public static void SeleniumWaits(){
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//IMP - Default poll time for implicit wait is 250 ms
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = driver.findElement(By.name("q"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.name("abcd")).click();
		
		driver.close();
	}
}
