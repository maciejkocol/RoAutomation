package com.application.steps;

import com.application.common.CommonAssert;
import com.application.common.CommonSteps;
import com.application.pages.StartMyVisitPage;
import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;

import static com.application.common.DataStoreUtils.*;

public class StartMyVisitSteps extends CommonSteps {

    private final Logger logger = Logger.getLogger(StartMyVisitSteps.class);
    private StartMyVisitPage startMyVisitPage;

    @Step("Fill form with <email>, <first_name>, <last_name>, and <password>")
    public void fillForm(String email, String first, String last, String password) {
        startMyVisitPage = new StartMyVisitPage(driver);
        startMyVisitPage.assertElementExists("Email Address input field not found", startMyVisitPage.txtEmail);
        startMyVisitPage.assertElementExists("First Name input field not found", startMyVisitPage.txtFirst);
        startMyVisitPage.assertElementExists("Last Name input field not found", startMyVisitPage.txtLast);
        startMyVisitPage.assertElementExists("Password input field not found", startMyVisitPage.txtPassword);
        startMyVisitPage.assertElementExists("Agreement checkbox not found", startMyVisitPage.chkAgreement);
        startMyVisitPage.fillInputField(startMyVisitPage.txtEmail, email);
        startMyVisitPage.fillInputField(startMyVisitPage.txtFirst, first);
        startMyVisitPage.fillInputField(startMyVisitPage.txtLast, last);
        startMyVisitPage.fillInputField(startMyVisitPage.txtPassword, password);
        startMyVisitPage.clickElement(startMyVisitPage.chkAgreement);
        storeStringToScenarioDataStore("first_name", first);
    }

    @Step("Start my visit")
    public void startMyVisit() {
        startMyVisitPage = new StartMyVisitPage(driver);
        startMyVisitPage.assertElementExists("'START MY VISIT' button not found", startMyVisitPage.btnStartMyVisit);
        startMyVisitPage.startMyVisit();
    }

    @ContinueOnFailure
    @Step("Validate online visit")
    public void validateOnlineVisit() {
        startMyVisitPage = new StartMyVisitPage(driver);
        String firstName = fetchStringFromScenarioDataStore("first_name");
        String welcomeHdr = startMyVisitPage.getElement(startMyVisitPage.hdrWelcomeLoc).getText();
        CommonAssert.assertEqualsText(welcomeHdr, "Hi " + firstName + ",\n" +
                "thanks for starting your\n" +
                "online visit.");
        CommonAssert.assertTrue("Page URL does not match", startMyVisitPage.getPageURL().contains("/rory/vaginal-dryness/online-visit/10"));
        CommonAssert.assertTrue("Page title does not match", startMyVisitPage.getPageTitle().equalsIgnoreCase("RO Online Visit"));
    }
}
