package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationVaccination extends TestBase {

    @Test
    public void testModificationVaccination() {
        app.getNavigationHelper().gotoMedcard();
        app.getVaccinationHelper().goToInsertVaccination();
        if (! app.getVaccinationHelper().isThereVaccination()) {
            app.getVaccinationHelper().createFullVaccination();
            app.getNavigationHelper().backToList();
        }
        int before = app.getVaccinationHelper().getVaccinationCount();
        app.getVaccinationHelper().modificationVaccination();
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getVaccinationHelper().getVaccinationCount();
        Assert.assertEquals(after, before);
    }
}
