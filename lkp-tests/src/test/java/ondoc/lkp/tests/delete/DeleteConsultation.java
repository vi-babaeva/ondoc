package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteConsultation extends TestBase {

    @Test
    public void testDeleteConsultation() throws InterruptedException {
        app.getNavigationHelper().gotoMedcard();
        if (! app.getConsultationHelper().isThereConsultation()) {
            app.getConsultationHelper().createFullConsultation();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getConsultationHelper().deleteConsultation();
    }
}
