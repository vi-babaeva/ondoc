package ondoc.lkp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
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
    }

    protected void save() {
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
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
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    }

    protected void createConsultation() throws InterruptedException {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[1]/div")).click();
        wd.findElement(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/strong")).click();
        wd.findElement(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
    }

    protected void choseType() {
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
    }

    protected void gotoMedcard() {
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/aside/div[1]/div[4]/ul/li[2]/a")).click();
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

    protected void add() {
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

    protected void createDentisrty() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[1]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]")).click();
    }

    protected void conclusionTooth(String zakl) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea")).sendKeys(zakl);
    }

    protected void objectivelyTooth(String obj) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea")).sendKeys(obj);
    }

    protected void anamnesisTooth(String anam) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea")).sendKeys(anam);
    }

    protected void complaintsTooth(String zhalob) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea")).sendKeys(zhalob);
    }

    protected void diagnisisTooth(String diag) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input")).sendKeys(diag);
    }

    protected void MKBtooth() {
        wd.findElement(By.id("icd-form-select_value")).click();
        wd.findElement(By.id("icd-form-select_value")).clear();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.id("icd-form-select_value")).sendKeys("Кариес");
        wd.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]")).click();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
    }

    protected void toothСondition() {
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.linkText("Без изменений")).click();
        wd.findElement(By.xpath("//div[@class='widget']//p[.='Вылечен']")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input")).sendKeys("Кариес");
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input")).sendKeys("Здоров");
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    }

    protected void toothSelection27() {
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//table[@class='stoma-scheme']//span[.='27']")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    }

    protected void recommendationsChekup(String rek) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea")).sendKeys(rek);
    }

    protected void objectivelyChekup(String obj) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea")).sendKeys(obj);
    }

    protected void anamnesisChekup(String anam) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea")).sendKeys(anam);
    }

    protected void complaintsChekup(String zhalob) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea")).sendKeys(zhalob);
    }

    protected void diagnosisChekup(String diag) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input")).sendKeys(diag);
    }

    protected void MKBcheckup() {
        wd.findElement(By.id("icd-form-select_value")).click();
        wd.findElement(By.id("icd-form-select_value")).clear();
        wd.findElement(By.id("icd-form-select_value")).sendKeys("Имму");
        wd.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[10]/div/div[2]")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    }

    protected void directionName(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input")).sendKeys(name);
    }

    protected void choseDirection() {
        wd.findElement(By.id("direction-form-select_value")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[2]/direction-autocomplete/div/a")).click();
        wd.findElement(By.xpath("//div[@class='clinic-directions__inner-wrapper']//span[.='Иммунология']")).click();
    }

    protected void createCheckup() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.linkText("Выберите врача")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
    }

    protected void descriptionNote(String descr) {
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).sendKeys(descr);
    }

    protected void nameNote(String name) {
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).click();
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).clear();
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).sendKeys(name);
    }

    protected void createNote() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[1]/div")).click();
    }

    protected void reactionAllergies(String reaction) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input")).sendKeys(reaction);
    }

    protected void nameAllergies(String name) {
        wd.findElement(By.xpath("//div[@class='col-xs-17']/input")).click();
        wd.findElement(By.xpath("//div[@class='col-xs-17']/input")).clear();
        wd.findElement(By.xpath("//div[@class='col-xs-17']/input")).sendKeys(name);
    }

    protected void createAllergies() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[2]/div")).click();
    }

    protected void nameVaccine2(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).sendKeys(name);
    }

    protected void newData() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input")).sendKeys("18.12.2019");
    }

    protected void nameVaccine(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input")).sendKeys(name);
    }

    protected void nameVaccination(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).sendKeys(name);
    }

    protected void createVaccination() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[4]/div/div")).click();
        wd.findElement(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/p")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}