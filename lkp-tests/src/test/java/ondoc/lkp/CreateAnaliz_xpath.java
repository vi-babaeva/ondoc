package ondoc.lkp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class CreateAnaliz_xpath {
    ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void testCreateAnaliz_xpath() {
        wd.get("https://dev.ondoc.me/");
        wd.findElement(By.linkText("Войти")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).sendKeys("patient.ondoc@mail.ru");
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).sendKeys("q1234567Q!");
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/button")).click();
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        //клик по Медицинская карта
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/aside/div[1]/div[4]/ul/li[2]/a")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[1]/clinic-doctor-edit/div[3]")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).sendKeys("Анализ в свободной форме");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).sendKeys("pokazatel_1");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input")).sendKeys("45");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input")).sendKeys("> 80");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input")).sendKeys("moll");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input")).sendKeys("komment");
        wd.findElement(By.linkText("Добавить")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input")).sendKeys("показатель 2");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input")).sendKeys("882");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input")).sendKeys("we");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).sendKeys("комментари");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).sendKeys("комментари");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).sendKeys("заключение по результатам анализа");
        wd.findElement(By.xpath("//div[@class='widget']//button[.='Сохранить']")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        //wd.quit();
    }
    
    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
