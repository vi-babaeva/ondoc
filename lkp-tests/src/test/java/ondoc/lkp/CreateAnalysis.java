package ondoc.lkp;

import org.testng.annotations.Test;

public class CreateAnalysis extends TestBase{
    
    @Test
    public void testCreateAnalysis() throws InterruptedException {
        gotoMedcard();
        choseType();
        createAnalysis();
        analysisName("Гемостазиограмма (коагулограмма) расширенная");
        firstIndicator("Протромбиновое время", "13.5", "9.0 - 15.0", "cек", "");
        addIndicator();
        secondIndicator("Фибриноген", "2.6", "г/л", "2.0 - 4.0", "Во втором и третьем триместрах беременности возможно физиологическое повышение уровня фибриногена до 5,6 г/л");
        conclusionOfResults("Количество тромбоцитов в норме. Сосудисто-тромбоцитарный гемостаз в норме. Нормокоагуляция по внешнему и внутреннему пути активации плазменного гемостаза. Конечные этапы свертывания в норме. Активность антикоагулянтов и состояние фибринолитической системы в норме. Показатели коагулограммы в пределах физиологической нормы.");
        save();
    }
}
