package base_class;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class baseClass {

    public WebDriver driver;
    public Properties OR = new Properties();
    


    public WebDriver getDriver() {
        return driver;
    }
    @BeforeSuite
    public  void initialization() throws IOException {

        loadORfile();
        selectBrowser(OR.getProperty("browser"));
        getURL(OR.getProperty("url"));
        getDriver();

    }


    public void selectBrowser(String browser){

        if(browser.contains("chroma"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if (browser.contains("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }

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

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }


}
