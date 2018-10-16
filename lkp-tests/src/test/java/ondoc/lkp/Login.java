package ondoc.lkp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

public class Login {
    ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginLKP() {
        wd.get("https://dev.ondoc.me/");
        wd.findElement(By.linkText("Войти")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).sendKeys("patient.ondoc@mail.ru");
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).sendKeys("q1234567Q!");
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/button")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/button")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

}
