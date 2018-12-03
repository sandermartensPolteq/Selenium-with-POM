package flows;

import models.User;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.Page;

public class LoginFlow extends Page {

    public static void clickSignInOnTopToolbar(User user){
        HomePage homePage = new HomePage();
        homePage.clickSignIn();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.fillEmail(user.getUsername());
        authenticationPage.fillPassword(user.getPassword());
    }


}
