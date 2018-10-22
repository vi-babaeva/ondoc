package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class CreationVaccination extends TestBase  {
    
    @Test
    public void testCreationVaccination () {
        app.getNavigationHelper().gotoMedcard();
        app.getNavigationHelper().choseType();
        app.getVaccinationHelper().createVaccination();
        app.getVaccinationHelper().nameVaccination("Прививка от гриппа");
        app.getVaccinationHelper().nameVaccine("Инфлювак");
        app.getNavigationHelper().add();
        app.getVaccinationHelper().newDataVaccine2();
        app.getVaccinationHelper().nameVaccine2("Гриппол");
        app.getNavigationHelper().save();
        app.getVaccinationHelper().commentInVaccination();
    }
}