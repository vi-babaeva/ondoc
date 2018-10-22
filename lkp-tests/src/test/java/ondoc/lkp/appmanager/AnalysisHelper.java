package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AnalysisHelper extends HelperBase {

    public AnalysisHelper(ChromeDriver wd) {
        super(wd);
    }

    public void conclusionOfResults(String conclusions) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea"), conclusions);
    }

    public void secondIndicator(String index, String result, String normValue, String units, String comment) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input"), index);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input"), result);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[7]/input"), normValue);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input"), units);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input"), comment);
    }

    public void firstIndicator(String index, String result, String normValue, String units, String comment) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input"), index);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input"), result);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input"), normValue);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input"), units);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input"), comment);
    }

    public   void  commentInAnalysis () {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/analyze-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("buttton.r-button.r-button--blue-border"));
    }

    public void analysisName(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"), name);
        click(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input"));
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input")).clear();
    }

    public void createAnalysis() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[2]/div"));
        click(By.cssSelector("strong.ng-scope"));
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        click(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]"));
        click(By.cssSelector("strong.ng-scope"));
        click(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]"));
        click(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"));
        wd.findElement(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input")).clear();
    }
}
