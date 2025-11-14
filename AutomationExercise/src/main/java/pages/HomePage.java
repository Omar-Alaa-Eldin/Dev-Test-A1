package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage class for Automation Exercise website
 * Jira Issue: DEPI-104-2
 * Description: Page Object Model for home page with navigation elements and methods
 */
public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Elements - Navigation
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeMenu;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsMenu;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartMenu;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginMenu;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    private WebElement testCasesMenu;

    @FindBy(xpath = "//a[contains(text(),'API Testing')]")
    private WebElement apiTestingMenu;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactUsMenu;

    // Page Elements - Products Section
    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    private WebElement firstViewProduct;

    @FindBy(xpath = "(//a[contains(@class, 'add-to-cart')])[1]")
    private WebElement firstAddToCart;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    private java.util.List<WebElement> productCards;

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    // Page Methods

    /**
     * Navigate to Cart page
     */
    public void navigateToCart() {
        System.out.println("Navigating to Cart page...");
        cartMenu.click();
    }

    /**
     * Navigate to Products page
     */
    public void navigateToProducts() {
        System.out.println("Navigating to Products page...");
        productsMenu.click();
    }

    /**
     * Navigate to Login page
     */
    public void navigateToLogin() {
        System.out.println("Navigating to Login page...");
        loginMenu.click();
    }

    /**
     * Click on first product's "View Product" button
     */
    public void clickFirstViewProduct() {
        System.out.println("Clicking first product view button...");
        firstViewProduct.click();
    }

    /**
     * Add first product to cart
     */
    public void addFirstProductToCart() {
        System.out.println("Adding first product to cart...");
        firstAddToCart.click();
    }

    /**
     * Search for a product
     * @param productName the product to search for
     */
    public void searchProduct(String productName) {
        System.out.println("Searching for product: " + productName);
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }

    /**
     * Get the number of products displayed
     * @return count of product cards
     */
    public int getProductCount() {
        return productCards.size();
    }

    /**
     * Get current page title
     * @return page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get current page URL
     * @return page URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Check if on home page
     * @return true if on home page
     */
    public boolean isOnHomePage() {
        return driver.getCurrentUrl().equals("https://automationexercise.com/") ||
                driver.getCurrentUrl().equals("https://automationexercise.com");
    }
}