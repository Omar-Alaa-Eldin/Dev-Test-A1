package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/// Test class for HomePage functionality using Page Object Model
/// Jira Issue: DEPI-104-2


public class HomePageTest extends BaseTest {


    @Test
    public void testHomePageNavigation() {
        System.out.println("Running test: testHomePageNavigation");

        // Verify we're on home page
        Assert.assertTrue(homePage.isOnHomePage(), "Should be on home page");
        System.out.println("✓ Verified on home page");

        // Verify page title
        String pageTitle = homePage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("Automation Exercise"),
                "Page title should contain 'Automation Exercise'");
        System.out.println("✓ Page title verified: " + pageTitle);
    }

    @Test
    public void testNavigationToCartPage() {
        System.out.println("Running test: testNavigationToCartPage");

        // Navigate to cart page using Page Object method
        homePage.navigateToCart();

        // Verify navigation worked
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("view_cart"),
                "Should be on cart page after navigation");
        System.out.println("✓ Successfully navigated to cart page: " + currentUrl);
    }

    @Test
    public void testNavigationToProductsPage() {
        System.out.println("Running test: testNavigationToProductsPage");

        // Navigate to products page using Page Object method
        homePage.navigateToProducts();

        // Verify navigation worked
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("products"),
                "Should be on products page after navigation");
        System.out.println("✓ Successfully navigated to products page: " + currentUrl);
    }

    @Test
    public void testProductSection() {
        System.out.println("Running test: testProductSection");

        // Check if products are displayed
        int productCount = homePage.getProductCount();
        Assert.assertTrue(productCount > 0, "Should have products displayed");
        System.out.println("✓ Products displayed: " + productCount);
    }
}