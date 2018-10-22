package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckupHelper extends HelperBase {

    public CheckupHelper(ChromeDriver wd) {
        super(wd);
    }

    public void createCheckup() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[2]/div"));
        click(By.cssSelector("strong.ng-scope"));
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        click(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]"));
        click(By.linkText("Выберите врача"));
        click(By.cssSelector("p.medcard-doctor__doc-specs.ng-binding"));
    }

    public void directionName(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input"), name);
    }

    public void choseDirection() {
        click(By.id("direction-form-select_value"));
        click(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[2]/direction-autocomplete/div/a"));
        click(By.xpath("//div[@class='clinic-directions__inner-wrapper']//span[.='Иммунология']"));
    }

    public void recommendationsChekup(String rek) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea"), rek);
    }

    public void objectivelyChekup(String obj) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea"), obj);
    }

    public void anamnesisChekup(String anam) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea"), anam);
    }

    public void complaintsChekup(String zhalob) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea"), zhalob);
    }

    public void diagnosisChekup(String diag) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input"), diag);
    }

    public void MKBcheckup() {
        type(By.id("icd-form-select_value"), "Имму");
        click(By.xpath("//div[@id='icd-form-select_dropdown']/div[10]/div/div[2]"));
    }

    public void commentInChekup() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/exam-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("strong"));
    }
}
