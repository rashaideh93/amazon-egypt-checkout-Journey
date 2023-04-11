package org.example.core.instance.BetaDriver;

import org.example.core.instance.SelInstance;
import org.example.utils.handler.TestDataXMLReader;
import org.example.utils.handler.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class base extends SelInstance {

    public static final String xmlPathName = "reengineering";


    public base() {
        super(new TestDataXMLReader(xmlPathName));
    }

    @BeforeMethod
    public void navigateToAmazonURL() {

        //get URL
        WebDriver driver = doBrowserSetup();
        WaitHelper.handleImplicit(driver);
        threadLocalDriver.set(driver);
        threadLocalDriver.get().get("https://www.amazon.eg/");

    }
    //get thread-safe driver

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        threadLocalDriver.remove();
    }

}
