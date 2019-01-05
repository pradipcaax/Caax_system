package base_class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class baseClass {

    public WebDriver driver;

    @Test
    public void initialization(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.caax.co.uk/demo/sxclient/Login.aspx");
        driver.manage().window().maximize();
        System.out.println("I'm in");

    }
}
