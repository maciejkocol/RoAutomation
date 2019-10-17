package utils;

import com.application.common.CommonObjects;
import com.application.common.CommonSteps;
import com.thoughtworks.gauge.Step;
import org.assertj.core.api.Assertions;
import utils.driver.Driver;

/**
 * @author Maciej Kocol
 * <p>
 * This is the core class to launch the Ro base page using drivers.
 */
public class AppLauncher extends CommonSteps {

    public static String BASE_URL = System.getenv("base_url");
    private CommonObjects commonObjects;

    @Step("Navigate to base page")
    public void launchTheApplication() {
        commonObjects = new CommonObjects(driver);
        Driver.webDriver.navigate().refresh();
        Driver.webDriver.get(BASE_URL);
        commonObjects.waitURLContains("/rory/vaginal-dryness");
        commonObjects.waitUntilFinishedLoading();
        Assertions.assertThat(commonObjects.getPageTitle().equalsIgnoreCase("RO Online Visit"))
                .as("Landed on Ro Vaginal Dryness page correctly").isTrue();
    }
}
