
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupModificationTests {
    WebDriver wd;

    @BeforeMethod()
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        wd.navigate().to("http://localhost/addressbook");

        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");

        wd.findElement(By.xpath("//*[@value = 'Login']")).click();

    }

    @Test
        public void testGroupModification() {
        wd.findElement(By.linkText("groups")).click();

        wd.findElement(By.name("selected[]")).click();

        wd.findElement(By.name("edit")).click();

        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("modifyedTestGroupName1");

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("modifyedTestGroupHeader1");

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("modifyedTestGroupFooter1");

        wd.findElement(By.name("update")).click();

        wd.findElement(By.linkText("group page")).click();

    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}

