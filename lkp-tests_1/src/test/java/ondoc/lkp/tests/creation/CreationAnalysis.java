package ondoc.lkp.tests.creation;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class CreationAnalysis extends TestBase {
    
    @Test
    public void testCreateAnalysis() {
        app.getNavigationHelper().gotoMedcard();
        app.getNavigationHelper().choseType();
        app.getAnalysisHelper().createAnalysis();
        app.getAnalysisHelper().analysisName("Гемостазиограмма (коагулограмма) расширенная");
        app.getAnalysisHelper().firstIndicator("Протромбиновое время", "13.5", "9.0 - 15.0", "cек", "");
        app.getNavigationHelper().add();
        app.getAnalysisHelper().secondIndicator("Фибриноген", "2.6", "г/л", "2.0 - 4.0", "Во втором и третьем триместрах беременности возможно физиологическое повышение уровня фибриногена до 5,6 г/л");
        app.getAnalysisHelper().conclusionOfResults("Количество тромбоцитов в норме. Сосудисто-тромбоцитарный гемостаз в норме. Нормокоагуляция по внешнему и внутреннему пути активации плазменного гемостаза. Конечные этапы свертывания в норме. Активность антикоагулянтов и состояние фибринолитической системы в норме. Показатели коагулограммы в пределах физиологической нормы.");
        app.getNavigationHelper().save();
        app.getAnalysisHelper().commentInAnalysis();
    }
}
