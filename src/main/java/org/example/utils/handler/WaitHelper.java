package org.example.utils.handler;

import org.example.core.interfaces.ImplicitHandler;
import org.example.utils.Reading_Helper.implicitTimeReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static void handleImplicit(WebDriver webDriver) {
        ImplicitHandler implicit = WaitHelper::setImplicit;
        implicit.handleImplicitTime(webDriver, implicitTimeReader.readTime());
    }

    private static void setImplicit(WebDriver webDriver, long time) {
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

}
