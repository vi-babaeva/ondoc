package ondoc.lkp.tests.creation;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreationVaccination extends TestBase {
    
    @Test
    public void testCreationVaccination () {
        app.getNavigationHelper().gotoMedcard();
        app.getVaccinationHelper().goToInsertVaccination();
        int before = app.getVaccinationHelper().getVaccinationCount();
        app.getNavigationHelper().choseType();
        app.getVaccinationHelper().createVaccination();
        app.getVaccinationHelper().nameVaccination("Прививка от гриппа");
        app.getVaccinationHelper().nameVaccine("Инфлювак");
        app.getNavigationHelper().add();
        //app.getVaccinationHelper().newDataVaccine2();
        app.getVaccinationHelper().nameVaccine2("Гриппол");
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getVaccinationHelper().getVaccinationCount();
        Assert.assertEquals(after, before + 1);
    }
}