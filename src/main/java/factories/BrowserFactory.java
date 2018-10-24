package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public enum Browser{
        CHROME,
        FIREFOX,
        IE
    }

    public static WebDriver useBrowser(Browser browser){
        switch (browser){
            case CHROME: default:
                return getChromeBrowser();
        }
    }

    private static WebDriver getChromeBrowser(){
        System.setProperty("webdriver.chrome.driver", "C://Selenium/Chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }
}
