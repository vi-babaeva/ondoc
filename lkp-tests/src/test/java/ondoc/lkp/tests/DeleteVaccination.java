package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteVaccination extends TestBase {

    @Test
    public void testDeleteVaccination() {
        app.getNavigationHelper().gotoMedcard();
        app.getVaccinationHelper().deleteVaccination();
    }
}
