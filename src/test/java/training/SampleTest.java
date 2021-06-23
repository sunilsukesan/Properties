package training;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(".//src/test//resources//prop.properties");
		Properties properties = new Properties();
		properties.load(file);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.findElement(By.linkText("Login")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
		driver.findElement(By.id("login-email")).sendKeys(properties.getProperty("uname"));
		driver.findElement(By.id("login-pswd")).sendKeys(properties.getProperty("pwd"));
	}

}
