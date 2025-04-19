package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    }

    @Test
public void testSearch() {
    driver.get("https://www.google.com");
    driver.findElement(By.name("q")).sendKeys("Jenkins CI/CD");
    driver.findElement(By.name("q")).submit();

    // Wait briefly (bad practice but quick for testing)
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    String title = driver.getTitle();
    System.out.println("Page Title: " + title);

    Assert.assertTrue(title.contains("Jenkins"), "Expected title to contain 'Jenkins'");
}

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
