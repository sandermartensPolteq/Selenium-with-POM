import factories.BrowserFactory;
import fixtures.UserFixture;
import flows.LoginFlow;
import models.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.Page;

public class Mytest {

    private static final String URL = "https://techblog.polteq.com/testshop/index.php";
    private User DEFAULT_USER = UserFixture.DEFAULT_USER();

    @BeforeMethod
    public void setup(){
        Page.setWebDriver(BrowserFactory.Browser.FIREFOX);
        Page.openUrl(URL);
    }

    /*
    Here we define each page and use the methods to sign in
     */
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
