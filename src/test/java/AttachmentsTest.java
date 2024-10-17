import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest extends TestBase {
    private static final String REPOSITORY = "/eroshenkoam/allure-example";
    public static final int ISSUE = 90;

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("shiianovaen")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/eroshenkoam/allure-example")
    @DisplayName("Проверка Issue для авторизованного пользователя")
    public void lambdaAttachmentsTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем репозиторий " + REPOSITORY, () -> {
            open(REPOSITORY);
            attachment("Source", webdriver().driver().source());
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
            attachment("Source", webdriver().driver().source());
        });

        step("Проверяем наличие issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
            attachment("Source", webdriver().driver().source());
        });

    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("shiianovaen")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/eroshenkoam/allure-example")
    @DisplayName("Проверка Issue для авторизованного пользователя")
    public void annotatedStepWithAttachmentsTest (){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebAnnotatedTest steps = new WebAnnotatedTest();

        steps.openRepository(REPOSITORY);
        steps.takeScreenshot();
        steps.openIssuesTab();
        steps.takeScreenshot();
        steps.shouldExistIssueNumber(ISSUE);
        steps.takeScreenshot();
    }


}
