package org.example.core.selenium_drivers;

import org.example.core.enums.HeadlessStrategyOperator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari implements SelDriverProvider{


    @Override
    public WebDriver getBrowser(boolean isHeadless) {
        WebDriver driver = new SafariDriver();

        if (isHeadless) {
            return HeadlessStrategyOperator.SAFARI.execute ();
        } else {
        }
        return driver;


    }
}
