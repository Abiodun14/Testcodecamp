import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.PasswordAuthentication;

public class KongaSignup {private WebDriver driver;
@Test
    public void start() {
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //1. Open the browser
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    //2. Input the Url
    driver.get("https://www.konga.com/");
    //Test Verify user is redirected to a landing page
    if(driver.getCurrentUrl().contains("https://www.konga.com/"))
        //Pass
        System.out.println("correct landing page");
    //Fail
    System.out.println("wrong landing page");

    //3. Click on login
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

    //4. Input Email Address
    driver.findElement(By.id("username")).sendKeys("abyholla@yahoo.com");

    //5. Input password
    driver.findElement(By.id("password")).sendKeys("lambaa");

    //6. Click on Login button
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

    //Test3 Verify user is logged out and redirected to the landing page
    //7. Logout from the account
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]")).click();
    if(driver.getCurrentUrl().contains("https://www.konga.com/"))
        //Pass
        System.out.println("Correct landing page");
    else
        //Fail
    System.out.println("Wrong Landing page");
    }


    @AfterTest
        public void CloseBrowser () {
        driver.quit();
    }
}

