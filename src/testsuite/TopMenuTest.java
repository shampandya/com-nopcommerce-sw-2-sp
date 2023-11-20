package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //click the computer tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile'] //a[text() = 'Computers ']")).click();
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title'] //h1[text() = 'Computers']")).getText();
        Assert.assertEquals("Verify two text:",expectedText,actualText );

    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        WebElement electric  = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Electronics ']"));
        electric.click();
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']//h1[text() = 'Electronics']")).getText();
        Assert.assertEquals("Varify the two Strings:",actualText, expectedText);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Apparel ']")).click();
        String expectedMes = "Apparel";
        String actualMes = driver.findElement(By.xpath("//div[@class='page category-page']//h1[text() = 'Apparel']")).getText();
        Assert.assertEquals( "Verify two message: ",expectedMes, actualMes);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
    driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Digital downloads ']")).click();
    String expectedText = "Digital downloads";
    String actualText =driver.findElement(By.xpath("//div[@class='page-title']//h1[text() = 'Digital downloads']")).getText();
    Assert.assertEquals("Verify two String:",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Books ']")).click();
        String expectedMess = "Books";
        String actualMess = driver.findElement(By.xpath("//div[@class='page-title']//h1[text() = 'Books']")).getText();
        Assert.assertEquals("Verify two words:",expectedMess,actualMess);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Jewelry ']")).click();
        String actualT = "Jewelry";
        String expectedT = driver.findElement(By.xpath("//div[@class='page-title']//h1[text() = 'Jewelry']")).getText();
        Assert.assertEquals("Verify two Strings: ",expectedT, actualT);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Gift Cards ']")).click();
        String actualText = "Gift Cards";
        String expectedText = driver.findElement(By.xpath("//div[@class='page-title']//h1[text() = 'Gift Cards']")).getText();
        Assert.assertEquals("Verify two Texts: ",expectedText, actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
