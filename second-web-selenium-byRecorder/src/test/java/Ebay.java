
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ebay {
  private WebDriver driver;


  @BeforeClass(alwaysRun = true)
  public void setUp(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEbay(){
    driver.get("https://www.ebay.com/");
    driver.findElement(By.linkText("register")).click();
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Nata");
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Tsyman");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("natalie.tsyman0310@gmail.com");
    driver.findElement(By.id("PASSWORD")).click();
    driver.findElement(By.id("PASSWORD")).clear();
    driver.findElement(By.id("PASSWORD")).sendKeys("1664081S");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
