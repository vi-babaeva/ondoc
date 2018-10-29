package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteDentistry extends TestBase {

    @Test
    public void testDeleteDentistry() {
        app.getNavigationHelper().gotoMedcard();
        app.getDentistryHelper().deleteDentistry();
    }
}
