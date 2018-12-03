package pages;

import org.openqa.selenium.By;

public class HomePage extends Page {

    private static By btnSignIn = By.className("login");

    public void clickSignIn(){
        click(btnSignIn);
    }
}
