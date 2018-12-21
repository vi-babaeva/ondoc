package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteVaccination extends TestBase {

    @Test
    public void testDeleteVaccination() {
        app.getNavigationHelper().gotoMedcard();
        app.getVaccinationHelper().goToInsertVaccination();
        if (! app.getVaccinationHelper().isThereVaccination()) {
            app.getVaccinationHelper().createFullVaccination();
            app.getNavigationHelper().backToList();
        }
        int before = app.getVaccinationHelper().getVaccinationCount();
        app.getVaccinationHelper().deleteVaccination();
        app.getVaccinationHelper().goToInsertVaccination();
        app.getNavigationHelper().refreshPage();
        int after = app.getVaccinationHelper().getVaccinationCount();
        Assert.assertEquals(after, before - 1);
    }
}
