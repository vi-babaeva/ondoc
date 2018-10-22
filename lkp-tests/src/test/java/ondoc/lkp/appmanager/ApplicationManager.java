package ondoc.lkp.appmanager;

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
    private NoteHelper noteHelper;
    private VaccinationHelper vaccinationHelper;
    private SessionHelper sessionHelper;

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