package ondoc.lkp.tests.modification;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationConsultation extends TestBase{

    @Test
    public void testModificationConsultation() throws InterruptedException {
        app.getNavigationHelper().gotoMedcard();
        app.getConsultationHelper().goToInsertConsultation();
        if (! app.getConsultationHelper().isThereConsultation()) {
            app.getConsultationHelper().createFullConsultation();
            app.getNavigationHelper().backToList();
        }
        int before = app.getConsultationHelper().getConsultationCount();
        app.getConsultationHelper().modificationConsultation();
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getConsultationHelper().getConsultationCount();
        Assert.assertEquals(after, before);
    }
}
