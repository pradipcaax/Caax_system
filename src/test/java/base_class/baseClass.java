package base_class;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

    }

    @Test
    public void login(){

        driver.findElement(By.id("UserName")).sendKeys("pradip.caax@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("pradip123");
        driver.findElement(By.id("LoginButton")).click();
    }
}
