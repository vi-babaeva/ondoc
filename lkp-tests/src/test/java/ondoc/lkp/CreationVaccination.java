package ondoc.lkp;

import org.testng.annotations.Test;


public class CreationVaccination extends TestBase  {
    
    @Test
    public void testCreationVaccination () {
        gotoMedcard();
        choseType();
        createVaccination();
        nameVaccination("Прививка от гриппа");
        nameVaccine("Инфлювак");
        add();
        newData();
        nameVaccine2("Гриппол");
        save();
        commentInAllergies();
    }
}
