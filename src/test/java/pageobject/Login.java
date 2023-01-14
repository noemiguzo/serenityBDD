package pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject  {
    @FindBy(id = "txt-username")
    public WebElementFacade usernameTxt;

    @FindBy(id = "txt-password")
    public WebElementFacade passwordTxt;

    @FindBy(id = "btn-login")
    public WebElementFacade loginBtn;

    @FindBy(xpath = "//*[@class='lead text-danger']")
    public WebElementFacade loginFailedTxt;
    public void loginAsDemoUser(){
        usernameTxt.type("John Doe");
        passwordTxt.type("ThisIsNotAPassword");
        loginBtn.click();
    }
  //  Login failed! Please ensure the username and password are valid

    public void loginUser(String user, String password) {
        usernameTxt.type(user);
        passwordTxt.type(password);
        loginBtn.click();
    }

    public void validarLoginFailed() {
        Assert.assertEquals(loginFailedTxt.getText(), "Login failed! Please ensure the username and password are valid.");
    }
}
