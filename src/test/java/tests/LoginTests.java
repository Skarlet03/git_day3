package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;
    @BeforeMethod
    public void setDriver()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

    @Test
    public void positiveLogin(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));
        System.out.println("d");
    }
    @Test
    public void negativeLogin() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));
        String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Test");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("Test" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Web Orders Login"));
        Assert.assertTrue(driver.getCurrentUrl().equals(currentUrl));
    }

    @Test
    public void veLogin() {}
}
