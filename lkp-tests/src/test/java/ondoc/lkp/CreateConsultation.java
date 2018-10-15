package ondoc.lkp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

public class CreateConsultation {
    ChromeDriver wd;
    //FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        //wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
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
        //wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        //wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/aside/div[1]/div[4]/ul/li[2]/a")).click();
    }

    @Test
    public void testCreateConsultation() throws InterruptedException {

        gotoMedcard();
        choseСonsultation();
        MKB();
        diagnosis("диагноз в свободной форме");
        complaints("жалобы пациента");
        anamnesis("анамнез пациента");
        objectively("лалалалалалалалала");
        recommendations("рекомендован отпуск");
        save();
    }

    private void save() {
        wd.findElement(By.xpath("//div[@class='widget']//button[.='Сохранить']")).click();
    }

    private void recommendations(String recomendadions) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).sendKeys(recomendadions);
    }

    private void objectively(String objectivno) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).sendKeys(objectivno);
    }

    private void anamnesis(String anam) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).sendKeys(anam);
    }

    private void complaints(String zhalob) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).sendKeys(zhalob);
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
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[1]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
    }


    private void gotoMedcard() {
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/aside/div[1]/div[4]/ul/li[2]/a")).click();
        //wd.findElement(By.xpath("//*[contains(text(), 'Медицинская карта')]")).click();
        //wd.findElement(By.cssSelector("a.sidebar__menu-link")).click();
        //wd.findElement(By.linkText("Медицинская карта")).click();
    }

    @AfterMethod
     public void tearDown() {
        //wd.quit();
    }
    
    public static boolean isAlertPresent(ChromeDriver wd) {
    //public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
