package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckupHelper {
    private ChromeDriver wd;

    public CheckupHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void createCheckup() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[2]/div")).click();
        wd.findElement(By.cssSelector("strong.ng-scope")).click();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]")).click();
        wd.findElement(By.linkText("Выберите врача")).click();
        wd.findElement(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding")).click();
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

    public void commentInChekup() {
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/exam-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.cssSelector("strong")).click();
    }
}
