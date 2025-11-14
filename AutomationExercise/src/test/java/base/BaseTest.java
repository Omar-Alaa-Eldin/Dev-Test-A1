package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import pages.HomePage;


/**
 * BaseTest class for automation framework - OPTIMIZED VERSION
 * Jira Issue: DEPI-104-1
 * Description: Base test class with single browser session for all tests
 * Provides common setup and cleanup methods for all test classes
 */
public class BaseTest {

    protected static WebDriver driver;
    protected static final String BASE_URL = "https://automationexercise.com/";
    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.out.println("=== Setting up Firefox driver for test class ===");

        // Setup Firefox driver using WebDriverManager (automatically downloads driver)
        WebDriverManager.firefoxdriver().setup();

        // Configure Firefox options
        FirefoxOptions options = new FirefoxOptions();

        // Add browser arguments for better stability
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        // Initialize Firefox driver with options
        driver = new FirefoxDriver(options);

        // Configure driver settings
        driver.manage().window().maximize();

        // Set timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Navigate to the application
        System.out.println("Navigating to Automation Exercise...");
        driver.get(BASE_URL);

        // Verify we reached the correct page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("✓ Successfully loaded Automation Exercise website");
            System.out.println("✓ Page Title: " + actualTitle);
        } else {
            System.out.println("✗ Failed to load correct page. Actual title: " + actualTitle);
        }
        System.out.println("=== Browser setup completed ===\n");

        // Initialize HomePage object before class
        homePage = new HomePage(driver);
        System.out.println("HomePage object initialized");
    }



    @AfterMethod
    public void returnToHomePage() {
        System.out.println("Returning to home page after test...");

        // Navigate back to home page instead of closing browser
        if (driver != null) {
            driver.get(BASE_URL);
            System.out.println("✓ Returned to home page successfully");
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("\n=== Closing browser after test class ===");

        // Close the browser only after all tests in the class are done
        if (driver != null) {
            driver.quit();
            System.out.println("✓ Browser closed successfully after all tests");
        }
    }

    /**
     * Get the current WebDriver instance
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Get the current page title
     * @return page title as String
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get the current page URL
     * @return page URL as String
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Navigate to specific URL
     * @param url the URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Navigate back to home page
     */
    public void navigateToHome() {
        driver.get(BASE_URL);
    }
}