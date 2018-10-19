package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    ChromeDriver wd;

    private ConsultationHelper consultationHelper;
    private NavigationHelper navigationHelper;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.get("https://dev.ondoc.me/");
        consultationHelper = new ConsultationHelper(wd);
        navigationHelper = new NavigationHelper(wd);
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

    public void conclusionOfResults(String conclusions) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).clear();

        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea")).sendKeys(conclusions);
    }

    public void secondIndicator(String index, String result, String normValue, String units, String comment) {
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

    public void firstIndicator(String index, String result, String normValue, String units, String comment) {
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

    public   void  commentInAnalysis () {
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/analyze-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.cssSelector("buttton.r-button.r-button--blue-border")).click();
    }

    public void analysisName(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).sendKeys(name);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).clear();
    }

    public void createAnalysis() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).clear();
    }

    public void createDentisrty() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[1]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]")).click();
    }

    public void conclusionTooth(String zakl) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea")).sendKeys(zakl);
    }

    public void objectivelyTooth(String obj) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea")).sendKeys(obj);
    }

    public void anamnesisTooth(String anam) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea")).sendKeys(anam);
    }

    public void complaintsTooth(String zhalob) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea")).sendKeys(zhalob);
    }

    public void diagnisisTooth(String diag) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input")).sendKeys(diag);
    }

    public void MKBtooth() {
        wd.findElement(By.id("icd-form-select_value")).click();
        wd.findElement(By.id("icd-form-select_value")).clear();
        wd.findElement(By.id("icd-form-select_value")).sendKeys("Кариес");
        wd.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]")).click();
    }

    public void toothСondition() {
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.linkText("Без изменений")).click();
        wd.findElement(By.xpath("//div[@class='widget']//p[.='Вылечен']")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input")).sendKeys("Кариес");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input")).sendKeys("Здоров");
    }

    public void toothSelection27() {
        wd.findElement(By.xpath("//table[@class='stoma-scheme']//span[.='27']")).click();
    }

    public void recommendationsChekup(String rek) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea")).sendKeys(rek);
    }

    public void objectivelyChekup(String obj) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).sendKeys(obj);
    }

    public void anamnesisChekup(String anam) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).sendKeys(anam);
    }

    public void complaintsChekup(String zhalob) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).sendKeys(zhalob);
    }

    public void diagnosisChekup(String diag) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input")).sendKeys(diag);
    }

    public void MKBcheckup() {
        wd.findElement(By.id("icd-form-select_value")).click();
        wd.findElement(By.id("icd-form-select_value")).clear();
        wd.findElement(By.id("icd-form-select_value")).sendKeys("Имму");
        wd.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[10]/div/div[2]")).click();
    }

    public void directionName(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input")).sendKeys(name);
    }

    public void choseDirection() {
        wd.findElement(By.id("direction-form-select_value")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[2]/direction-autocomplete/div/a")).click();
        wd.findElement(By.xpath("//div[@class='clinic-directions__inner-wrapper']//span[.='Иммунология']")).click();
    }

    public void createCheckup() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.linkText("Выберите врача")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
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

    public void reactionAllergies(String reaction) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input")).sendKeys(reaction);
    }

    public void nameAllergies(String name) {
        wd.findElement(By.xpath("//div[@class='col-xs-17']/input")).click();
        wd.findElement(By.xpath("//div[@class='col-xs-17']/input")).clear();
        wd.findElement(By.xpath("//div[@class='col-xs-17']/input")).sendKeys(name);
    }

    public void createAllergies() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[2]/div")).click();
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

    public void commentInDentistry() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[7]/buttton[1]/strong")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void commentInConsultation() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.cssSelector("strong")).click();
    }

    public void commentInChekup() {
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/exam-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.cssSelector("strong")).click();
    }

    public void commentInAllergies() {
        wd.findElement(By.xpath("//div[@class='margin-bottom-large']/div[2]/button")).click();
        wd.findElement(By.cssSelector("strong")).click();
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
}