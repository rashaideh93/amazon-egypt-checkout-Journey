import org.example.CheckoutPage;
import org.example.core.instance.BetaDriver.base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends base {

    @Test(description = "Add all products below that it's cost below 15k EGP and verify the amount")
    public void navigateAmazon() throws InterruptedException {
        AmazonActions amazonHomePage = new AmazonActions(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        VideoGamesPLPPage videoGamesPLPPage= new VideoGamesPLPPage(getDriver());
        CheckoutPage checkoutPage=new CheckoutPage(getDriver());
        amazonHomePage.clickOnSignInButton();
        loginPage.login("rashideh93@gmail.com", "Test@1234");
        amazonHomePage.openAllMenu();
        amazonHomePage.selectAllVideoGames();
        videoGamesPLPPage.applyFilters();
        Thread.sleep(2000);
        videoGamesPLPPage.addProductsBelow15K();
        Assert.assertTrue(videoGamesPLPPage.verifyProductsAddedToCart());
        videoGamesPLPPage.clickOnCheckoutButton();
        checkoutPage.fillAddressStep();
        checkoutPage.chooseCashPaymentMethod();
        checkoutPage.calculateExpectedTotalAmount();





    }
}
