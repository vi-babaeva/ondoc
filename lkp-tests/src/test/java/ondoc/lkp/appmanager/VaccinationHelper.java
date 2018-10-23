package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class VaccinationHelper extends HelperBase {

    public VaccinationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void nameVaccine2(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input"), name);
    }

    public void newDataVaccine2() {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input"), "18.12.2019" );
    }

    public void nameVaccine(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input"), name);
    }

    public void nameVaccination(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"), name);
    }

    public void createVaccination() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[4]/div/div"));
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']"));
        waiting(2, TimeUnit.MINUTES);
        click(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]"));
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']"));
        click(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/p"));
    }

    public void commentInVaccination() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("buttton.r-button.r-button--blue-border"));
    }
}
