package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteConsultation extends TestBase {

    @Test
    public void testDeleteConsultation() {
        app.getNavigationHelper().gotoMedcard();
        app.getConsultationHelper().deleteConsultation();
    }
}
