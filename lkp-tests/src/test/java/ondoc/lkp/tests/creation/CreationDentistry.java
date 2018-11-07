package ondoc.lkp.tests.creation;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreationDentistry extends TestBase {

    @Test
    public void testCreationDentistry() {
        app.getNavigationHelper().gotoMedcard();
        app.getDentistryHelper().goToInsertDentistry();
        int before = app.getDentistryHelper().getDentistryCount();
        app.getNavigationHelper().choseType();
        app.getDentistryHelper().createDentisrty();
        app.getDentistryHelper().toothSelection27();
        app.getDentistryHelper().toothСondition();
        app.getDentistryHelper().MKBtooth();
        app.getDentistryHelper().diagnisisTooth("Кариес");
        app.getDentistryHelper().complaintsTooth(" Жалобы на боли от холодного и при попадании пищи в кариозную полость зуба 27, проходящие сразу после устранения раздражителя.");
        app.getDentistryHelper().anamnesisTooth("Боли беспокоят около 2—3 месяцев, до этого были боли от сладкого, ранее зуб не лечен.");
        app.getDentistryHelper().objectivelyTooth("На жевательно-медиальной поверхности зуба 27 глубокая кариозная полость, дно размягчено, полость, зуба не вскрыта.\n" +
                "Зондирование болезненно по всему дну; реакция на холод болезненная, быстропроходящая, перкуссия безболезненна.");
        app.getDentistryHelper().conclusionTooth("Не стоит беспокоиться, если после лечения кариеса появилась чувствительность в зубе, самопроизвольно возникающая болезненность, увеличивающаяся при накусывании на зуб. Обычно эти ощущения проходят через 1-2 недели.\n" +
                "Не принимайте пищу и не полоскайте рот в течение 2 часов после лечения в стоматологии, но не ранее, чем закончится действие анестезии.\n" +
                "Обязательно обратитесь к лечащему врачу-стоматологу, если:\n" +
                "1) после лечения зуба от кариеса или пульпита возникла острая, приступообразная боль, возникающая самопроизвольно, а также боль, увеличивающаяся с течением времени;\n" +
                "2) возникли неприятные ощущения во время приема сладких, кислых, холодных или горячих продуктов;\n" +
                "3) после окончания действия анестезии пломба мешает смыканию зубов.");
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getDentistryHelper().getDentistryCount();
        Assert.assertEquals(after, before + 1);
    }
}






