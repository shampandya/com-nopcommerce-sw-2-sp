package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        WebElement register  = driver.findElement(By.xpath("//div[@class='header-links']//a[text() = 'Register']"));
        register.click();
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']//h1[text() = 'Register']")).getText();
        Assert.assertEquals("Varify the two Strings:",actualText, expectedText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfullyClickOnTheRegisterLink(){
        WebElement register  = driver.findElement(By.xpath("//div[@class='header-links']//a[text() = 'Register']"));
        register.click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("mohini");
        driver.findElement(By.id("LastName")).sendKeys("vyas");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("2");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("December");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1930");
        driver.findElement(By.name("Email")).sendKeys("wonderful@grr.la");
        driver.findElement(By.name("Password")).sendKeys("WhataHead?");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("WhataHead?");
        driver.findElement(By.id("register-button")).click();
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[@class = 'page-body']//div[text()= 'Your registration completed' ]")).getText();
        Assert.assertEquals("Verify two message",expectedText, actualText);

    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
