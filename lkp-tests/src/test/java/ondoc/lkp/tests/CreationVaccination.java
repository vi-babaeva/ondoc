package ondoc.lkp.tests;

import org.testng.annotations.Test;


public class CreationVaccination extends TestBase  {
    
    @Test
    public void testCreationVaccination () {
        app.getNavigationHelper().gotoMedcard();
        app.getNavigationHelper().choseType();
        app.createVaccination();
        app.nameVaccination("Прививка от гриппа");
        app.nameVaccine("Инфлювак");
        app.getNavigationHelper().add();
        app.newData();
        app.nameVaccine2("Гриппол");
        app.getNavigationHelper().save();
        app.commentInVaccination();
    }
}
