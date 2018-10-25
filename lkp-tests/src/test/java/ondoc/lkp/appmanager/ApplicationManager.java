package ondoc.lkp.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

public class ApplicationManager {
    WebDriver wd;

    private ConsultationHelper consultationHelper;
    private NavigationHelper navigationHelper;
    private AnalysisHelper analysisHelper;
    private AllergiesHelper allergiesHelper;
    private CheckupHelper checkupHelper;
    private DentistryHelper dentistryHelper;
    private NoteHelper noteHelper;
    private VaccinationHelper vaccinationHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.OPERA_BLINK) {
            wd = new OperaDriver();
        } else if (browser == BrowserType.SAFARI) {
            wd = new SafariDriver();
        }

        wd.get("https://dev.ondoc.me/");
        consultationHelper = new ConsultationHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        analysisHelper = new AnalysisHelper(wd);
        allergiesHelper = new AllergiesHelper(wd);
        checkupHelper = new CheckupHelper(wd);
        dentistryHelper = new DentistryHelper(wd);
        noteHelper = new NoteHelper(wd);
        vaccinationHelper = new VaccinationHelper(wd);
        sessionHelper =  new SessionHelper(wd);
        sessionHelper.login("patient.ondoc@mail.ru", "q1234567Q!");
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

    public VaccinationHelper getVaccinationHelper() {
        return vaccinationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}