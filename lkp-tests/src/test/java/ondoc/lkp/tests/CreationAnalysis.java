package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class CreationAnalysis extends TestBase{
    
    @Test
    public void testCreateAnalysis() {
        app.gotoMedcard();
        app.choseType();
        app.createAnalysis();
        app.analysisName("Гемостазиограмма (коагулограмма) расширенная");
        app.firstIndicator("Протромбиновое время", "13.5", "9.0 - 15.0", "cек", "");
        app.add();
        app.secondIndicator("Фибриноген", "2.6", "г/л", "2.0 - 4.0", "Во втором и третьем триместрах беременности возможно физиологическое повышение уровня фибриногена до 5,6 г/л");
        app.conclusionOfResults("Количество тромбоцитов в норме. Сосудисто-тромбоцитарный гемостаз в норме. Нормокоагуляция по внешнему и внутреннему пути активации плазменного гемостаза. Конечные этапы свертывания в норме. Активность антикоагулянтов и состояние фибринолитической системы в норме. Показатели коагулограммы в пределах физиологической нормы.");
        app.save();
        app.commentInAnalysis();
    }
}
