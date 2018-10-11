package ondoc.lkp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

public class CreateConsultation {
    ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://dev.ondoc.me/");
        login("patient.ondoc@mail.ru", "q1234567Q!");
    }

    private void login(String usermane, String password) {
        wd.findElement(By.linkText("Войти")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).sendKeys(usermane);
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).sendKeys(password);
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/button")).click();
    }

    @Test
    public void testCreateConsultation() throws InterruptedException {

        gotoMedcard();
        choseСonsultation();
        MKB();
        diagnosis("диагноз в свободной форме");
        complaints();
        anamnesis();
        objectively();
        recommendations();
        save();
    }

    private void save() {
        wd.findElement(By.xpath("//div[@class='widget']//button[.='Сохранить']")).click();
    }

    private void recommendations() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).sendKeys("рекомендован отпуск");
    }

    private void objectively() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).sendKeys("лалалалалалалалала");
    }

    private void anamnesis() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).sendKeys("анамнез пациента");
    }

    private void complaints() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).sendKeys("жалобы пациента");
    }

    private void diagnosis(String diag) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(diag);
    }

    private void MKB() {
        wd.findElement(By.id("icd-form-select_value")).click();
        wd.findElement(By.id("icd-form-select_value")).clear();
        wd.findElement(By.id("icd-form-select_value")).sendKeys("it");
        wd.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]")).click();
    }

    private void choseСonsultation() throws InterruptedException {
        wd.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[1]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
    }


    private void gotoMedcard() {
        wd.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
        wd.findElement(By.linkText("Медицинская карта")).click();
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
