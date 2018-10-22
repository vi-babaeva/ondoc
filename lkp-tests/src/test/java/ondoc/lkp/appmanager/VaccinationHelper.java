package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class VaccinationHelper {
    private ChromeDriver wd;

    public VaccinationHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void nameVaccine2(String name) {
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input")).sendKeys(name);
    }

    public void newDataVaccine2() {
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

    public void commentInVaccination() {
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button")).click();
        wd.findElement(By.cssSelector("buttton.r-button.r-button--blue-border")).click();
    }
}
