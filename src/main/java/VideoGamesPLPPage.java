import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.core.instance.SelInstance.getDriver;

public class VideoGamesPLPPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(css = "div#s-refinements div.a-section.a-spacing-none.a-spacing-top-mini > span")
    private WebElement freeShippingCheckbox;

    @FindBy(css = "div#filters ul:nth-child(4) > li:nth-child(1) > span > a > span")
    private WebElement newCheckbox;
    @FindBy(id = "nav-cart-count")
    private WebElement cartIcon;

    @FindBy(id="nav-cart-count")
    private WebElement cartItemCount;
    @FindBy(css="input[name='proceedToRetailCheckout']")
    private WebElement checkoutButton;






    public void applyFilters() throws InterruptedException {
        freeShippingCheckbox.click();
        newCheckbox.click();
        Thread.sleep(1500);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
        select.selectByValue("price-desc-rank");
        Thread.sleep(1500);

    }



    public void addProductsBelow15K() throws InterruptedException {
        List<WebElement> productsWithPriceList = getDriver().findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price-whole']"));
        System.out.println("No of Products With Price : " + productsWithPriceList.size());

        int integerCartCount = 0;
        do {
            for (int i = 1; i <= productsWithPriceList.size(); i++) {

                WebElement element = getDriver().findElement(By.xpath("(//div[@data-component-type='s-search-result']//span[@class='a-price-whole'])[" + i + "]"));
                String stringProductPrice = element.getText().replace(",", "");
                int integerProductPrice = Integer.parseInt(stringProductPrice);
                System.out.println("Integer Price of Product " + i + " : " + integerProductPrice);

                if (integerProductPrice < 15000) {
                    element.click();
                    Thread.sleep(1000);

                    try {
                        if (getDriver().findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")) != null) {
                            getDriver().findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")).click();
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDriver().findElement(By.id("add-to-cart-button")).click();
                    getDriver().navigate().back();
                    getDriver().navigate().back();
                    Thread.sleep(1000);
                }
                String cartCount = getDriver().findElement(By.id("nav-cart-count")).getText();
                integerCartCount = Integer.parseInt(cartCount);
            }
            getDriver().findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")).click();
        } while (integerCartCount == 0);

        Thread.sleep(5000);
    }
//    public boolean verifyProductsAddedToCart() {
//        cartIcon.click();
//        List<WebElement> cartItems = driver.findElements(By.cssSelector(".sc-list-item-content"));
//        int expectedItemCount = driver.findElements(By.cssSelector("#nav-cart-count")).size();
//        System.out.println("expectedItemCount=========="+expectedItemCount);
//        return cartItems.size() == expectedItemCount;
//    }
public boolean verifyProductsAddedToCart() {
    cartIcon.click();
    int itemCountHeader = Integer.parseInt(cartItemCount.getText());
    List<WebElement> cartItems = driver.findElements(By.cssSelector(".sc-list-item-content"));
    int itemCountCart = cartItems.size();
    return itemCountHeader == itemCountCart;
}
public void clickOnCheckoutButton(){
        checkoutButton.click();
}


    public VideoGamesPLPPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
}
