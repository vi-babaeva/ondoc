package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteDentistry extends TestBase {

    @Test
    public void testDeleteDentistry() {
        app.getNavigationHelper().gotoMedcard();
        if (! app.getDentistryHelper().isThereDentistry()) {
            app.getDentistryHelper().createFullDentisrty();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getDentistryHelper().deleteDentistry();
    }
}
