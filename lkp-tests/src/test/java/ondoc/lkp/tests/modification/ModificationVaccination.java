package ondoc.lkp.tests.modification;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationVaccination extends TestBase {

    @Test
    public void testModificationVaccination() {
        app.getNavigationHelper().gotoMedcard();
        app.getVaccinationHelper().goToInsertVaccination();
        int before = app.getVaccinationHelper().getVaccinationCount();
        if (! app.getVaccinationHelper().isThereVaccination()) {
            app.getVaccinationHelper().createFullVaccination();
            app.getNavigationHelper().backToList();
        }
        app.getVaccinationHelper().modificationVaccination();
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getVaccinationHelper().getVaccinationCount();
        Assert.assertEquals(after, before);
    }
}
