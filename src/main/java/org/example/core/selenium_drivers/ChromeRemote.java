package org.example.core.selenium_drivers;

import org.example.core.enums.HeadlessStrategyOperator;
import org.openqa.selenium.WebDriver;

import static org.example.utils.PropReader.readConfig;


public class ChromeRemote implements SelDriverProvider {

    private static final String remoteUrl = readConfig("remoteurl");
    public static final String REMOTE_CHROME = "remote-chrome";


    /**
     * this method to create new remote webdriver instance.
     * headless to determine the headless implemention when run the remote driver
     *
     * @param isHeadless the is headless parameter is a boolean value true or false.
     * @return
     */
    @Override
    public WebDriver getBrowser(boolean isHeadless) {


        if (isHeadless) {
             return HeadlessStrategyOperator.CHROMEREMOTE.execute ();
        } else {
//            try {
//
//                DesiredCapabilities capabilities = DesiredCapabilities.chrome ();
//                capabilities.setBrowserName (REMOTE_CHROME);
//                handleDesiredCaps (capabilities);
//
//                return new RemoteWebDriver (new URL (remoteUrl), capabilities);
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace ();
//            }
        }

         return null;
    }


}