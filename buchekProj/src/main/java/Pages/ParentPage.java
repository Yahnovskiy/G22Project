package Pages;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;
import libs.ActionsWithOutElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.is;
public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithOutElements actionsWithOutElement;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
       actionsWithOutElement = new ActionsWithOutElements(driver);
    }

    public void open(String url) {
        try {
            driver.get(url);
            logger.info("Page was opened with url" + url);

        } catch (Exception e) {
            logger.error("Can not open" + url);
            Assert.fail("Can not open" + url);

        }
    }

    public void checkTitle(String expectedTitle) {
        try {
            Assert.assertThat("Title not match", driver.getTitle(), is(expectedTitle));

        } catch (Exception e) {
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }
    }
}