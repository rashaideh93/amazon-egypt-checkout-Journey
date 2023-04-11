package org.example.utils.handler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import java.util.Arrays;

import static org.example.core.instance.SelInstance.getDriver;
import static org.example.utils.error_handlers.Logger.info;

/**
 *
 */
public class ElementHelper {
    /**
     * Created javascriptExecutor interface object
     */

    public static JavascriptExecutor javascriptExecutor() {

        JavascriptExecutor scriptExecutor = (JavascriptExecutor) getDriver();

        return scriptExecutor;

    }

    public static void safeClick(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
            } else {
                info("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            info("Element is not attached to the page document " + Arrays.toString(e.getStackTrace()));
        } catch (NoSuchElementException e) {
            info("Element was not found in DOM " + Arrays.toString(e.getStackTrace()));
        } catch (Exception e) {
            info("Unable to click on element " + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void elementWaitSeconds(int Second)
    {
        Second = Second * 1000;
        try {
            Thread.sleep(Second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}