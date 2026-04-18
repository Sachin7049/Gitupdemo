import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class links {
    @Test
    public void links(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://preprod-transient.rev-pass.com/SH125");
    }
}
