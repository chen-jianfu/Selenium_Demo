import com.cjf.testdata.TestDataFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Jeff on 2017/8/29.
 */
public class LoginTest {
    WebDriver driver;
    @BeforeClass
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
         driver = new ChromeDriver();
    }
    @AfterClass
    public void closeChrome(){
        driver.quit();
    }
    @Test(dataProviderClass = TestDataFactory.class,dataProvider = "login_test_data")
    public void ipgwtest(String user,String password){
        driver.get("http://cndex.imwork.net:88");
        System.out.println(user);
        System.out.println(password);
        driver.findElement(By.id("Username")).sendKeys(user);
        driver.findElement(By.id("loginpass")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
       String actual = alert.getText();
        alert.accept();
       String expected = "Username or password error, please input again!";
       Assert.assertEquals(actual,expected);

     //   new WebDriverWait(driver,10L).until(ExpectedConditions.elementToBeClickable(By.id("m_network"))).click();
       // driver.findElement(By.id("m_network")).click();
    }

}
