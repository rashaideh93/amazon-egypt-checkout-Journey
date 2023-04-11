package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    private WebElement fullName;
    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    private WebElement phoneNumber;
    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    private WebElement streetName;
    @FindBy(id = "address-ui-widgets-enter-building-name-or-number")
    private WebElement building;
    @FindBy(id = "address-ui-widgets-enterAddressCity")
    private WebElement city;
    @FindBy(id = "address-ui-widgets-enterAddressDistrictOrCounty")
    private WebElement district;
    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
    private WebElement governorate;
    @FindBy(id = "address-ui-widgets-landmark")
    private WebElement nearestLandmark;
    @FindBy(id = "payment-method-cash")
    private WebElement cash;


    public void fillAddressStep() {
        fullName.sendKeys("Mohammad Rashaideh");
        phoneNumber.sendKeys("1234567890");
        streetName.sendKeys("Test street");
        building.sendKeys("Rashaideh-112");
        city.sendKeys("New Cairo");
        district.sendKeys("Cairo");
        governorate.sendKeys("test Governorate");
        nearestLandmark.sendKeys("test Landmark");
    }

    public void chooseCashPaymentMethod() {
        cash.click();
    }


    public double calculateExpectedTotalAmount() {
        double totalAmount = 0.0;
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".sc-list-item-content"));

        for (WebElement item : cartItems) {
            WebElement priceElement = item.findElement(By.cssSelector(".a-price-whole"));
            String priceString = priceElement.getText().replaceAll(",", "");
            double price = Double.parseDouble(priceString);
            totalAmount += price;
        }
        if (driver.findElements(By.cssSelector(".a-color-secondary.a-size-base .a-color-price")).size() > 0) {
            WebElement shippingElement = driver.findElement(By.cssSelector(".a-color-secondary.a-size-base .a-color-price"));
            String shippingString = shippingElement.getText().replaceAll(",", "");
            double shipping = Double.parseDouble(shippingString);
            totalAmount += shipping;
        }

        return totalAmount;
    }


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
}
