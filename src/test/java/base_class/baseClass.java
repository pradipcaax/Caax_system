package base_class;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;


public class baseClass {

    public WebDriver driver;


    public baseClass() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.caax.co.uk/demo/sxclient/Login.aspx");
            driver.manage().window().maximize();

        }
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }


}
