package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DentistryHelper {
    private ChromeDriver wd;

    public DentistryHelper(ChromeDriver wd) {
        this.wd = wd;
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

    public void commentInDentistry() {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.xpath("//div[1]/div/div[2]/div[7]/buttton[1]/strong")).click();
    }
}
