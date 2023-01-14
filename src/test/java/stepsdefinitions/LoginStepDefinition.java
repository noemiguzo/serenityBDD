package stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.Home;
import pageobject.Login;

public class LoginStepDefinition {
    @Steps
    Home home;

    @Steps
    Login login;

    @When("^ingresar login datos (.*), (.*)$")
    public void ingresarLoginDatosUserPassword(String user,String password) {
        login.loginUser(user,password);
    }

    @Then("^validate login failed$")
    public void validateLoginFailed() {
        login.validarLoginFailed();
    }
}
