package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteConsultation extends TestBase {

    @Test
    public void testDeleteConsultation() throws InterruptedException {
        app.getNavigationHelper().gotoMedcard();
        app.getConsultationHelper().goToInsertConsultation();
        int before = app.getConsultationHelper().getConsultationCount();
        if (! app.getConsultationHelper().isThereConsultation()) {
            app.getConsultationHelper().createFullConsultation();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getConsultationHelper().deleteConsultation();
        app.getConsultationHelper().goToInsertConsultation();
        app.getNavigationHelper().refreshPage();
        int after = app.getConsultationHelper().getConsultationCount();
        Assert.assertEquals(after, before - 1);
    }
}
