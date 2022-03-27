package ro.tefacprogramator.m4.platformaonline;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAddSeries() {
        driver.get("http://localhost:3000");

        driver.findElement(By.cssSelector("input[name='idSeries']")).sendKeys("6");
        driver.findElement(By.cssSelector("input[name='nameSeries']")).sendKeys("Selenium test2");
        driver.findElement(By.cssSelector("input[name='numberOfSeasons']")).sendKeys("2");
        driver.findElement(By.cssSelector("input[name='idCategory']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[name='idPlatform']")).sendKeys("1");
        driver.findElement(By.cssSelector(".js_submit_btn")).sendKeys(Keys.ENTER);
        
        String result = driver.findElement(By.cssSelector("#status")).getText();
        assertEquals("success", result);
    }

    @AfterAll
    public static void closeUp() {
        driver.quit();
    }
    
}
