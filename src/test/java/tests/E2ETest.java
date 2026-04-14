package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class E2ETest extends BaseTest {

    @Test
    public void completeFlowTest() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addProduct();
        products.goToCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

        CartPage cart = new CartPage(driver);
        cart.checkout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillDetails("Sonal", "QA", "400001");
        checkout.continueCheckout();
        checkout.finishCheckout();

        Assert.assertEquals(
                checkout.getSuccessMessage(),
                "Thank you for your order!"
        );

        System.out.println("TEST PASSED");
    }
}