package org.example.core.selenium_drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.enums.Drivers;
import org.example.core.enums.HeadlessStrategyOperator;
import org.example.utils.PropReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Chrome implements SelDriverProvider {

    public static final String TRUE = "true";
    ChromeOptions options = (ChromeOptions) OptionsFactory.getOptions (Drivers.CHROME);

    @Override
    public WebDriver getBrowser(boolean isHeadless) {
        if (PropReader.readConfig ("isSpecificVersion").equalsIgnoreCase (TRUE)) {
            WebDriverManager.chromedriver ().driverVersion (PropReader.readConfig ("ChromeVersion")).setup ();

        }
        else {

            WebDriverManager.chromedriver ().setup ();
        }


        if (isHeadless) {
            return HeadlessStrategyOperator.CHROME.execute ();

        } else {
            return new ChromeDriver(options);
        }
    }
}