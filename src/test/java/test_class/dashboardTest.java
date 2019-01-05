package test_class;

import base_class.baseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class dashboardTest extends baseClass {

    @Test
    public void login(){

        driver.findElement(By.id("UserName")).sendKeys("pradip.caax@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("pradip123");
        driver.findElement(By.id("LoginButton")).click();
    }

    @Test
    public void dashoboard_urlTest(){

        System.out.println(driver.getCurrentUrl());
    }
}
