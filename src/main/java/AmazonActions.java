import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AmazonActions {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "nav-link-accountList")
    private WebElement signInButton;

    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
    private WebElement allMenuButton;

    @FindBy(css = "#hmenu-content ul.hmenu.hmenu-visible > ul > li:nth-child(11) > a")
    private WebElement videoGamesLink;

    @FindBy(css = "div#hmenu-content ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a")
    private WebElement allVideoGamesLink;

    @FindBy(xpath = "//select[@id='s-result-sort-select']")
    private WebElement sortMenuButton;

    @FindBy(css = "a#s-result-sort-select_2")
    private WebElement priceHighToLowOption;

    @FindBy(css = ".a-button-input")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "nav-cart")
    private WebElement cartButton;

    @FindBy(css = "[data-action='proceed-to-checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(name = "proceedToCheckout")
    private WebElement addressContinueButton;

    @FindBy(css = "[name='placeYourOrder1']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//i[@class='nav-sprite hmenu-arrow-more']")
    private WebElement seeAll;


    public AmazonActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }


    public void openAllMenu() {
        allMenuButton.click();
    }

    public void selectAllVideoGames() {
        seeAll.click();
        videoGamesLink.click();
        allVideoGamesLink.click();
    }




}