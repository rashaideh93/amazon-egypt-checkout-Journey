import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.utils.common.SharedMethods.waitUntilElementVisible;

@Getter
public class LoginPage {


    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(id = "ap_email")
    private WebElement emailField;
    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        waitUntilElementVisible(emailField);
        emailField.sendKeys(email);
        continueButton.click();
        waitUntilElementVisible(passwordField);
        passwordField.sendKeys(password);
        signInSubmitButton.click();
    }


}
