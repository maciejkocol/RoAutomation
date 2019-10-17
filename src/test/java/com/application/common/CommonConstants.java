package com.application.common;

import org.openqa.selenium.By;

public final class CommonConstants {

    //loading
    public static By pageLoadingHeading = By.xpath("//*[@class='start_preloader-text' and text()='One moment...']");

    private CommonConstants() {
        throw new AssertionError();
    }
}
