package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    ChromeDriver wd;

    private ConsultationHelper consultationHelper;
    private NavigationHelper navigationHelper;
    private AnalysisHelper analysisHelper;
    private AllergiesHelper allergiesHelper;
    private CheckupHelper checkupHelper;
    private DentistryHelper dentistryHelper;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.get("https://dev.ondoc.me/");
        consultationHelper = new ConsultationHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        analysisHelper = new AnalysisHelper(wd);
        allergiesHelper = new AllergiesHelper(wd);
        checkupHelper = new CheckupHelper(wd);
        dentistryHelper = new DentistryHelper(wd);
        login("patient.ondoc@mail.ru", "q1234567Q!");
    }

    public void login(String usermane, String password) {
        wd.findElement(By.linkText("Войти")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input")).sendKeys(usermane);
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input")).sendKeys(password);
        wd.findElement(By.xpath("//div[1]/main/div[1]/div/div[2]/form/button")).click();
    }

    public void descriptionNote(String descr) {
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).sendKeys(descr);
    }

    public void nameNote(String name) {
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).click();
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).clear();
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).sendKeys(name);
    }

    public void createNote() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[1]/div")).click();
    }

    public void nameVaccine2(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).sendKeys(name);
    }

    public void newData() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input")).sendKeys("18.12.2019");
    }

    public void nameVaccine(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input")).sendKeys(name);
    }

    public void nameVaccination(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).sendKeys(name);
    }

    public void createVaccination() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[4]/div/div")).click();
        wd.findElement(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/p")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void commentInVaccination() {
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.cssSelector("buttton.r-button.r-button--blue-border")).click();
    }

    public ConsultationHelper getConsultationHelper() {
        return consultationHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public AnalysisHelper getAnalysisHelper() {
        return analysisHelper;
    }

    public AllergiesHelper getAllergiesHelper() {
        return allergiesHelper;
    }

    public CheckupHelper getCheckupHelper() {
        return checkupHelper;
    }

    public DentistryHelper getDentistryHelper() {
        return dentistryHelper;
    }
}