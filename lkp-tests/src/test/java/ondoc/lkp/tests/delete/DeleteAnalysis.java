package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAnalysis extends TestBase {

    @Test
    public void testDeleteAnalysis() {
        app.getNavigationHelper().gotoMedcard();
        app.getAnalysisHelper().goToInsertAnalysis();
        int before = app.getAnalysisHelper().getAnalysisCount();
        if (! app.getAnalysisHelper().isThereAnalysis()) {
            app.getAnalysisHelper().createFullAnalysis();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getAnalysisHelper().deleteAnalysis();
        app.getAnalysisHelper().goToInsertAnalysis();
        app.getNavigationHelper().refreshPage();
        int after = app.getAnalysisHelper().getAnalysisCount();
        Assert.assertEquals(after, before - 1);
    }
}

