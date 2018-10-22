package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllergiesHelper extends HelperBase {

    public AllergiesHelper(ChromeDriver wd) {
        super(wd);
    }

    public void reactionAllergies(String reaction) {
        type(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input"), reaction);
    }

    public void nameAllergies(String name) {
        type(By.xpath("//div[@class='col-xs-17']/input"), name);
    }

    public void createAllergies() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[2]/div"));
    }

    public void commentInAllergies() {
        click(By.xpath("//div[@class='margin-bottom-large']/div[2]/button"));
        click(By.cssSelector("strong"));
    }
}
