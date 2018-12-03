package e2e;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import factories.BrowserFactory;
import fixtures.UserFixture;
import flows.LoginFlow;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.Page;

public class Mytest {

    private static final String URL = "https://techblog.polteq.com/testshop/index.php";
    private User DEFAULT_USER = UserFixture.DEFAULT_USER();
    private static ExtentHtmlReporter extentHtmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;
    @BeforeMethod
    public void setup(){
        Page.setWebDriver(BrowserFactory.Browser.FIREFOX);
        Page.openUrl(URL);
    }

    @Test
    public void reporter(){
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation1.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest logger=extent.createTest("LoginTest");
        logger.log(Status.INFO, "Login to amazon");
        logger.log(Status.PASS, "Title verified");
        extent.flush();

    }

    @Test
    public void login(){
        HomePage homePage = new HomePage();
        homePage.clickSignIn();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.fillEmail(DEFAULT_USER.getUsername());
        authenticationPage.fillPassword(DEFAULT_USER.getPassword());
    }

    /*
    Here we do the same as the previous test but instead of defining each page, we can use a static loginFlow
     */
    @Test
    public void loginViaFlow(){
        LoginFlow.clickSignInOnTopToolbar(DEFAULT_USER);
    }

    @AfterMethod
    public void tearDown(){
        Page.closeBrowser();
    }
}
