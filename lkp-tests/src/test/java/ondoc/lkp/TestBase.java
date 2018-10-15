package ondoc.lkp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        //wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.get("https://dev.ondoc.me/");
        login("patient.ondoc@mail.ru", "q1234567Q!");
    }

    protected void login(String usermane, String password) {
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

    protected void save() {
        wd.findElement(By.xpath("//div[@class='widget']//button[.='Сохранить']")).click();
    }

    protected void recommendations(String recomendadions) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).sendKeys(recomendadions);
    }

    protected void objectively(String objectivno) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).sendKeys(objectivno);
    }

    protected void anamnesis(String anam) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).sendKeys(anam);
    }

    protected void complaints(String zhalob) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea")).sendKeys(zhalob);
    }

    protected void diagnosis(String diag) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input")).sendKeys(diag);
    }

    protected void MKB() {
        wd.findElement(By.id("icd-form-select_value")).click();
        wd.findElement(By.id("icd-form-select_value")).clear();
        wd.findElement(By.id("icd-form-select_value")).sendKeys("it");
        wd.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]")).click();
    }

    protected void createConsultation() throws InterruptedException {
        //wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        //wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[1]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
    }
    protected void choseType() {
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
    }

    protected void gotoMedcard() {
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

    protected void conclusionOfResults(String conclusions) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).sendKeys(conclusions);
    }

    protected void secondIndicator(String index, String result, String normValue, String units, String comment) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input")).sendKeys(index);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input")).sendKeys(result);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[7]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[7]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[7]/input")).sendKeys(normValue);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input")).sendKeys(units);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input")).sendKeys(comment);
    }

    protected void addIndicator() {
        wd.findElement(By.linkText("Добавить")).click();
    }

    protected void firstIndicator(String index, String result, String normValue, String units, String comment) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).sendKeys(index);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input")).sendKeys(result);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input")).sendKeys(normValue);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input")).sendKeys(units);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input")).sendKeys(comment);
    }

    protected void analysisName(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).sendKeys(name);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).clear();
    }

    protected void createAnalysis() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).clear();
    }
}
