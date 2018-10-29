package ondoc.lkp.tests.creation;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class CreationCheckup extends TestBase {

    @Test
    public void testCreationCheckup() {
        app.getNavigationHelper().gotoMedcard();
        app.getNavigationHelper().choseType();
        app.getCheckupHelper().createCheckup();
        app.getCheckupHelper().choseDirection();
        app.getCheckupHelper().directionName("Иммунограмма");
        app.getCheckupHelper().MKBcheckup();
        app.getCheckupHelper().diagnosisChekup("Пониженный иммунитет");
        app.getCheckupHelper().complaintsChekup("Частые простудные заболевания, повышенная утомляемость, снижение работоспособности, постоянная сонливость, плохое настроение, раздражительность.");
        app.getCheckupHelper().anamnesisChekup("Беспокоит 4-5 месяцев. Предпринималось самостоятельное лечение народными средствами от простуды (лимон, ромашка и т.д.), после чего наблюдалось краткосрочное улучшение состояния.");
        app.getCheckupHelper().objectivelyChekup("Повышение уровня lgA видно при хронических заболеваниях гепатобилиарной системы, миеломе, алкогольном отравлении. Снижение показателя происходит при прохождении лучевой терапии, интоксикации химическими веществами, крапивнице, аутоиммунных аллергических реакциях. У грудных детей физиологической нормой будет низкая концентрация иммуноглобулина. Снижение возможно также при расширении сосудов.");
        app.getCheckupHelper().recommendationsChekup("Особое внимание нужно уделить витаминам группы В (особенно В 5), А, С, D, F, а также минералам — цинку, магнию, железу, марганцу, селену и йоду.\n" +
                "Нормализовать режим дня. Особенно это касается баланса между отдыхом и активностью. Обязательно нужно обеспечить организму полноценный сон, чтобы он успел восстановиться.\n" +
                "Рацион питания. Свежие фрукты, ягоды, овощи, зелень — кладезь витаминов и минералов. Нужно включать в рацион мясо, рыбу, кисломолочные продукты и растительные масла (особенно оливковое). Продукты с консервантами, красителями, стабилизаторами, повышенным количеством сахара и жиров лучше исключить или свести к минимуму.");
        app.getNavigationHelper().save();
        app.getCheckupHelper().commentInChekup();
    }

}
