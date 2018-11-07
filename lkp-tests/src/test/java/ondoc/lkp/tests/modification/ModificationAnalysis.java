package ondoc.lkp.tests.modification;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class ModificationAnalysis extends TestBase {

    @Test
    public void testModificationAnalysis() {
        app.getNavigationHelper().gotoMedcard();
        app.getAnalysisHelper().goToInsertAnalysis();
        if (! app.getAnalysisHelper().isThereAnalysis()) {
            app.getAnalysisHelper().createFullAnalysis();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getAnalysisHelper().modificationAnalysis();
        app.getNavigationHelper().save();
    }
}
