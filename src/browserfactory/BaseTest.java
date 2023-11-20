package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    public static WebDriver driver;

    public void openBrowser(String baseUrl){

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else{
            System.out.println("invalid browser name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
