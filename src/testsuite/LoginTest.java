package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        WebElement login = driver.findElement(By.xpath("//a[@class = 'ico-login']"));
        login.click();
        String expectedText = "Welcome, Please Sign In!";

        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("The validation of actual and expected:", expectedText, actualText);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        WebElement login = driver.findElement(By.xpath("//a[@class = 'ico-login']"));
        login.click();
        driver.findElement(By.name("Email")).sendKeys("werticle@sharklasers.com");
        driver.findElement(By.name("Password")).sendKeys("WhataHead?");
        driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
        String text = "Log out";
        String actualtext = driver.findElement(By.xpath("//div[@class = 'header-links']//a[text()= 'Log out' ]")).getText();
        Assert.assertEquals("Difference between actual and expected: ",actualtext,text);
    }
    @Test
    public void verifyTheErrorMessage(){
        WebElement login = driver.findElement(By.xpath("//a[@class = 'ico-login']"));
        login.click();
        driver.findElement(By.name("Email")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText();

        Assert.assertEquals("verify this two: ", expectedMessage, actualMessage);
    }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
