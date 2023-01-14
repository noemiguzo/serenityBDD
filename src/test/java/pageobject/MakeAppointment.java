package pageobject;
import actions.SelectOptions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


import static base.TestBase.prop;


public class MakeAppointment extends PageObject{

    @FindBy(css = "#combo_facility")
    public WebElementFacade facilityCombo;

    @FindBy(id = "chk_hospotal_readmission")
    public WebElementFacade readmissionChk;
    @FindBy(xpath = "//label[@class='radio-inline']")
    public List<WebElementFacade> programRadio;

    @FindBy(id = "txt_visit_date")
    public WebElementFacade visiteDate;



    @FindBy(id = "txt_comment")
    public WebElementFacade commentTxt;

    @FindBy(id = "btn-book-appointment")
    public WebElementFacade bookBtn;
    public void fullMakeAppointment(String facility, String readmission, String program, String visitDate, String comment){
        element(readmissionChk).waitUntilVisible();
        Select elementCountry = new Select(facilityCombo);
        elementCountry.selectByVisibleText(facility);
        if (Boolean.parseBoolean(readmission)) {
            readmissionChk.click();
        }
        SelectOptions.in(programRadio, program);
        visiteDate.type(visitDate);
        commentTxt.type(comment);
        bookBtn.click();
    }
    public void fullMakeAppointmentByConfig(){
        element(readmissionChk).waitUntilVisible();
        Select elementCountry = new Select(facilityCombo);
        elementCountry.selectByVisibleText(prop.getProperty("facility"));
        if (Boolean.parseBoolean(prop.getProperty("readmission"))) {
            readmissionChk.click();
        }
        SelectOptions.in(programRadio, prop.getProperty("program"));
        visiteDate.type(prop.getProperty("visitDate"));
        commentTxt.type(prop.getProperty("comment"));
        bookBtn.click();
    }
}
