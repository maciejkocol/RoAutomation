package com.application.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartMyVisitPage extends BasePage {

    private final Logger logger = Logger.getLogger(StartMyVisitPage.class);

    //headers
    public By hdrWelcomeLoc = By.xpath("//h2[contains(.,'thanks for starting')]");

    //fields
    @FindBy(xpath = "//*[@id='temporaryEmail' and @autocomplete='false']")
    public WebElement txtEmail;
    @FindBy(id = "firstName")
    public WebElement txtFirst;
    @FindBy(id = "lastName")
    public WebElement txtLast;
    @FindBy(id = "password")
    public WebElement txtPassword;

    //checkboxes
    @FindBy(xpath = "//label[@for='agreedToTos']/div")
    public WebElement chkAgreement;

    //buttons
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnStartMyVisit;

    public StartMyVisitPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Starts the online visit by submitting form details
     *
     */
    public void startMyVisit() {
        clickElement(btnStartMyVisit);
        waitURLContains("/online-visit");
        waitElementVisibility(hdrWelcomeLoc);
    }
}
