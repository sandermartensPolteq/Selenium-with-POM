package factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static WebDriver driver;

    public enum Browser{
        CHROME,
        FIREFOX,
        IE
    }

    public static WebDriver useBrowser(Browser browser){
        switch (browser){
            case CHROME: default:
                return getChromeBrowser();
            case FIREFOX:
                return getFirefoxBrowser();
        }
    }

//    private static WebDriver getChromeBrowser(){
//        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-notifications");
//        return new ChromeDriver(options);
//    }

    private static WebDriver getChromeBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--enable-logging --v");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxBrowser(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
