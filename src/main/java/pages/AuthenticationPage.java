package pages;

import org.openqa.selenium.By;

public class AuthenticationPage extends Page {

    private static final By txtEmail = By.id("email");
    private static final By txtPassword = By.id("passwd");

    public void fillEmail(String email){
        clearAndType(txtEmail, email);
    }

    public void fillPassword(String password){
        clearAndType(txtPassword, password);
    }
}
