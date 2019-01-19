package test_class;


import base_class.baseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;



public class dashboardTest extends baseClass{

    baseClass base;



    @Test
    public void login() throws IOException {
        base=new baseClass();
        base.initialization();
        driver.findElement(By.id("UserName")).sendKeys("pradip.caax@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("pradip123");
        driver.findElement(By.id("LoginButton")).click();

       }



}
