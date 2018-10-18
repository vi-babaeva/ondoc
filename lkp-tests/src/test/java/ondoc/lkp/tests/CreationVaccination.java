package ondoc.lkp.tests;

import org.testng.annotations.Test;


public class CreationVaccination extends TestBase  {
    
    @Test
    public void testCreationVaccination () {
        app.gotoMedcard();
        app.choseType();
        app.createVaccination();
        app.nameVaccination("Прививка от гриппа");
        app.nameVaccine("Инфлювак");
        app.add();
        app.newData();
        app.nameVaccine2("Гриппол");
        app.save();
        app.commentInVaccination();
    }
}
