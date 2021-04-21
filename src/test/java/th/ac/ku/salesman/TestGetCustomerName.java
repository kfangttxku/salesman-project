package th.ac.ku.salesman;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestGetCustomerName {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private static WebDriverWait wait;


    @FindBy(id = "editButton") private WebElement editButton;
    @FindBy(id = "deleteButton") private WebElement deleteButton;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/customer");
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    void TestGetCustomerNameAtEditPage() {
        editButton.click();
        WebElement resultHeader = wait.until(webDriver ->
                webDriver.findElement(By.tagName("h1")));
        assertEquals("Edit Customer : Fang", resultHeader.getText());
    }
    @org.junit.jupiter.api.Test
    void TestGetCustomerNameAtDeletePage() {
        deleteButton.click();
        WebElement resultHeader = wait.until(webDriver ->
                webDriver.findElement(By.tagName("h1")));
        assertEquals("Delete Customer : Fang", resultHeader.getText());
    }




}

