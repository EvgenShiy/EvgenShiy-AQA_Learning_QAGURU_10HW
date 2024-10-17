import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest extends TestBase {

    private static final String REPOSITORY = "/eroshenkoam/allure-example";
    public static final int ISSUE = 90;

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("shiianovaen")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/eroshenkoam/allure-example")
    @DisplayName("Проверка Issue для авторизованного пользователя")
    public void lambdaIssueSearchTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем репозиторий " + REPOSITORY, () -> {
            open(REPOSITORY);
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("shiianovaen")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/eroshenkoam/allure-example")
    @DisplayName("Проверка Issue для авторизованного пользователя")
    public void annotatedStepTest (){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebAnnotatedTest steps = new WebAnnotatedTest();

        steps.openRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldExistIssueNumber(ISSUE);
    }
}
