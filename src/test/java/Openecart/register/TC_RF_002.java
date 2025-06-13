package Openecart.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_RF_002 {
	
	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
		driver.findElement(By.id("ap_email_login")).sendKeys("sujata62sonawane@gmail.com");
	     driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
	     driver.findElement(By.xpath("//a[@id='auth-fpp-link-bottom']")).click();
	     driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
	}
	

}
