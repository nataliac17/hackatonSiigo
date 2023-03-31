package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cont802486\\IdeaProjects\\TestHackatonSiigo\\chromedriver.exe");
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement (String locator){
        Find(locator).click();
    }

    public static String replaceValue(String xpath, String value){
        String newXpath= xpath.replace("NUM", value);
        return newXpath;
    }

    public String getText (String locator){
        String result = Find(locator).getAttribute("value");
        return result;
    }







}
