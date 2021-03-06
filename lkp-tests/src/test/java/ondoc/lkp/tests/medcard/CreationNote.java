package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreationNote extends TestBase {

    @Test
    public void testCreationNote() {
        app.getNavigationHelper().gotoMedcard();
        app.getNoteHelper().goToInsertNote();
        //int before = app.getNoteHelper().getNoteCount();
        app.getNavigationHelper().choseType();
        app.getNoteHelper().createNote();
        app.getNoteHelper().nameNote("LPG-массаж");
        app.getNoteHelper().descriptionNote("Lpg-массаж представляет собой метод аппаратного массажа. Разработан этот метод был в 70-х годах двадцатого века французским исследователем Луи Полем Гителем. Метод получил название от его инициалов.\n" +
                "\n" +
                "Принцип действия lpg-массажа основан на механическом воздействии на тело или лицо с помощью специальных насадок аппарата в двух направлениях — вакуумом и вибромассажем.\n" +
                "\n" +
                "Аппарат для этой процедуры представляет собой камеру со специальными насадками (манипулами). Манипулы имеют на конце ролики для вибромассажа. Манипулы захватывают или защипывают часть кожи со скоростью от 4 до 16 раз в секунду, а вакуум оказывает дополнительный эффект.\n" +
                "\n" +
                "Lpg-массаж проводят через индивидуальный спецкостюм (эндермологический комбинезон) для гигиеничного и безболезненного воздействия манипулы и лучшего захвата кожи.");
        app.getNavigationHelper().saveNote();
        app.getNavigationHelper().backToList();
        //int after = app.getNoteHelper().getNoteCount();
        //Assert.assertEquals(after, before + 1);
    }
}
