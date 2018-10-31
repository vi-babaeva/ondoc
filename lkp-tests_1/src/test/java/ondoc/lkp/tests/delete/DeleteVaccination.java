package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteVaccination extends TestBase {

    @Test
    public void testDeleteVaccination() {
        app.getNavigationHelper().gotoMedcard();
        app.getVaccinationHelper().deleteVaccination();
    }
}
