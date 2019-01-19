package base_class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



public class baseClass {

    public static WebDriver driver;
    private Properties OR = new Properties();



    public  WebDriver initialization() throws IOException {

        loadORfile();
        driver=selectBrowser(OR.getProperty("browser"));
        getURL(OR.getProperty("url"));
        return driver;
    }


    public WebDriver selectBrowser(String browser) {

        if (browser.contains("chroma")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        return driver;

    }


    public void loadORfile() throws IOException {

        File file = new File("C:\\Users\\test\\IdeaProjects\\Caax_system\\src\\main\\java\\resources\\Config");
        System.out.println(file.getPath());
        FileInputStream f = new FileInputStream(file);
        OR.load(f);
    }

    public void getURL(String URL){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public  void waitForElementToAppearAndClick(WebElement element) {
        boolean element1=false;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed())
        {
            element.click();
        }

    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }




}
