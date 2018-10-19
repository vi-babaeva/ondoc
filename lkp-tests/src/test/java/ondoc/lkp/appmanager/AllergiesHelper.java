package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllergiesHelper {
    private ChromeDriver wd;

    public AllergiesHelper(ChromeDriver wd) {
        this.wd = wd;
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

    public void commentInAllergies() {
        wd.findElement(By.xpath("//div[@class='margin-bottom-large']/div[2]/button")).click();
        wd.findElement(By.cssSelector("strong")).click();
    }
}
