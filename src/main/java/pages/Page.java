package pages;

import factories.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

    protected static WebDriver driver;

    public static void setWebDriver(BrowserFactory.Browser browser){
        Page.driver = BrowserFactory.useBrowser(browser);
    }

    public static void openUrl(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.close();
    }

    public static void clearAndType(By element, String text){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public static void click(By element){
        driver.findElement(element).click();
    }
}
