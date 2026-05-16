import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


//1)Dataprovider is a testng annotation used to run the same method multiple times with diffrents set of data()
//DataProvider is used for data-driven testing where one test runs with multiple inputs.

public class Login {

    @Test(dataProvider = "set")
    public void login(String usernames,String Password) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(usernames);
        driver.findElement(By.id("pwd")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Boolean isLogin=driver.getCurrentUrl().contains("dashbord");
        Assert.assertTrue(isLogin,"Login failed!");
        driver.quit();

    }
    @DataProvider(name = "set")
    public Object[][] set() {

        return new Object[][]{
                {"sn@parkengage.com", "dfhef@yopmail"},
        {"s999@1parkengage.com", "Welco]me@1234"},
        {"sadmin999@parkengage.com", "Pass9ord@123"}
    };
//      


    }

}
