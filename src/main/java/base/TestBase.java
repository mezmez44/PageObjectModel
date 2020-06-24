package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestUtil;
import util.WebEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {


    public static WebDriver driver;
    public static Properties prop;

    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/mezibena/IdeaProjects/FreeCRMTestAutomation/src/main/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/mezibena/IdeaProjects/FreeCRMTestAutomation/src/main/java/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "/Users/mezibena/IdeaProjects/FreeCRMTestAutomation/src/main/java/drivers/geckodriver");
            driver = new FirefoxDriver();
        }


        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));


    }
    //helper methods
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    //Select From single Menu
    public static void selectFromDrop(String locator1, String locator2){
        WebElement element = driver.findElement(By.xpath(locator1));
        Select drpWrd = new Select(element);
        drpWrd.selectByValue(locator2);
    }
}
