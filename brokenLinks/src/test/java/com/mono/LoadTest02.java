package com.mono;


import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

public class LoadTest02 {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        System.out.println("launching chrome browser----§");
		System.setProperty("webdriver.chrome.driver", "/Users/pururanjijar/work/driver-downloaded/chromedriver");
		driver = new ChromeDriver();
        
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");
        
        System.out.println("my search text----§" +text);
        Assert.assertEquals(text, search_text, "Text not found!");
    }
}