package Openecart.register;


import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_RF_001 {
	
    @Test
	public void verifyRegisteringFields() {
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        
        driver.findElement(By.id("input-firstname")).sendKeys("sujata");
        driver.findElement(By.id("input-lastname")).sendKeys("sonwane");
        driver.findElement(By.id("input-email")).sendKeys(randomEmailGenerator());
        driver.findElement(By.id("input-telephone")).sendKeys("9146689656");
        driver.findElement(By.id("input-password")).sendKeys("abc123");
        driver.findElement(By.id("input-confirm")).sendKeys("abc123");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
     

        String Expectedheading="Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), Expectedheading);
	    String actualProperDetailsOne="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	    String actualProperDetailsTwo="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String actualProperDetailsThree="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
        String actualProperDetailsFour="contact us.";
        
        String expectedProperDetails = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
        Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));

        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit Account")).isDisplayed());
        driver.quit();
    }
	
	public String randomEmailGenerator() {
		Date date = new Date();
		String stringDate = date.toString();
		String noSpaceStringDate = stringDate.replaceAll("\\s","");
		String noColonStringDate = noSpaceStringDate.replaceAll("\\:","");
		String emailWithTimeStamp = noColonStringDate+"@gmail.com";
		//System.out.println(emailWithTimeStamp);
		return emailWithTimeStamp;
        //return new Date().toString().replaceAll("\\s","".replaceAll("\\:", "")+"@gmail.com");
       
	}

}
