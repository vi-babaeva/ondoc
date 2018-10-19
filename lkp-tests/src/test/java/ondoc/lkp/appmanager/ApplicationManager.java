package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends VaccinationHelper {
    ChromeDriver wd;

    private ConsultationHelper consultationHelper;
    private NavigationHelper navigationHelper;
    private AnalysisHelper analysisHelper;
    private AllergiesHelper allergiesHelper;
    private CheckupHelper checkupHelper;
    private DentistryHelper dentistryHelper;
    private NoteHelper noteHelper;

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
        noteHelper = new NoteHelper(wd);
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

    public void stop() {
        wd.quit();
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

    public NoteHelper getNoteHelper() {
        return noteHelper;
    }
}