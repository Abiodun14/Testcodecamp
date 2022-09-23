import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumBlogSignupTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void startSession(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open the browser
        driver  = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test(priority = 0)
    public void clickSignUpButton() {

    //2. Input the URL
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/a[2]")));
    //Test 1 - Verify user is redirected to a landing page
    if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
        //Pass
        System.out.println("Correct landing page");
    else
        //Fail
        System.out.println("Wrong landing page");

    //3. Click on sign up button
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }

    @Test (priority = 1)
    public void PositiveTest() {
    //Test - Verify user can signup with valid details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_username")));
        //4. Input username
        driver.findElement(By.id("user_username")).sendKeys("eyalaa1");


        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("eyalaa1@gravel.com");


        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("parteys");


        //7. Click on signup button
        driver.findElement(By.id("submit")).click();

    }
         @Test (priority = 2)
         public void ClickUser1() throws InterruptedException {
    //Test 3 - Verify User1 is present, clickable and user is directed to user1 page
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")));
        //8. Click on user1
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users/1"))
            //Pass
            System.out.println("correct user1 page");
        else
             //Fail
        System.out.println("Wrong user1 page");

    }

     @Test (priority = 3)
     //Test4 - Verify user is redirected to learnxpath page
     public void learnxpath() throws InterruptedException {
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")));
        //9. Click on learnxpath
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
    if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/articles/59"))
        //Pass
        System.out.println("Correct learnxpath page");
    else
        //Fail
    System.out.println("Wrong learnxpath page");

}

     @Test (priority = 4)
     public void Logout() throws InterruptedException {
    //Test5 - Verify user is logged out and redirected to landing page
    //10. logout
    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
        //Pass
        System.out.println("correct landing page");
    else
        //Fail
         System.out.println("Wrong landing name");
    Thread.sleep(1000);
    }
@Test (priority = 5)
    public void NegativeTest() throws InterruptedException {
        //Test 6 - Verify user cannot signup with blank field
    //Click on sign up button
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    Thread.sleep(5000);
        //4. Input username
        driver.findElement(By.id("user_username")).sendKeys("");
        Thread.sleep(10000);

        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("");
        Thread.sleep(10000);

        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("");
        Thread.sleep(10000);

        //7. Click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }
@Test(priority = 6)
    public void NegativeTest2() throws InterruptedException {
        //Test 7 - Verify user cannot signup with invalid email

    driver.get("https://selenium-blog.herokuapp.com/signup");
        //4. Input username
        driver.findElement(By.id("user_username")).sendKeys("afghh");
        Thread.sleep(10000);

        //5. Input E-mail
        driver.findElement(By.id("user_email")).sendKeys("yuhj@klll");
        Thread.sleep(10000);

        //6. Input Password
        driver.findElement(By.id("user_password")).sendKeys("cyuvuig");
        Thread.sleep(10000);

        //7. Click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void CloseBrowser() {
    driver.quit();
    }
}
