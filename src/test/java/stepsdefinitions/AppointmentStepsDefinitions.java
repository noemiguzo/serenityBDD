package stepsdefinitions;
import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.AppointmentConfirmation;
import pageobject.Login;
import pageobject.MakeAppointment;
import pageobject.Home;
public class AppointmentStepsDefinitions {
    @Steps
    Home home;

    @Steps
    Login login;

    @Steps
    TestBase testBase;

    @Steps
    MakeAppointment makeAppointment;
    @Steps
    AppointmentConfirmation appointmentConfirmation;
    @Given("^el usuario ingresar a make appointment page$")
    public void ElUsuarioIngresaAMakeAppointmentPage() {
        home.open();
        home.clickAppointment();

    }
    @And("login to make appointment")
    public void loginToMakeAppointment() {
        login.loginAsDemoUser();
    }
    @When("^ingresar appoinment datos (.*), (.*), (.*), (.*) y (.*)$")
    public void ingresarAppoinmentDatosFacilityReadmissionProgramVisitDateYComment(String facility,String readmission, String program, String visitDate, String comment) {
        makeAppointment.fullMakeAppointment(facility,readmission,program,visitDate,comment);
    }
    @Then("^verificar appointment datos (.*), (.*), (.*), (.*) y (.*)$")
    public void verificarAppointmentDatosFacilityReadmissionProgramVisitDateYComment(String facility,String readmission, String program, String visitDate, String comment)  {
        appointmentConfirmation.validateAppointment(facility,readmission,program,visitDate,comment);
    }

    @Then("verificar appointment confirmation reading config properties")
    public void verificarAppointmentConfirmationReadingConfigProperties() {
        appointmentConfirmation.validateAppointmentByConfig();
    }

    @When("registrar appointment by config properties")
    public void registrarAppointmentByConfigProperties() {
        testBase = new TestBase();
        makeAppointment.fullMakeAppointmentByConfig();
    }

}
