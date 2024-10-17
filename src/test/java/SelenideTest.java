import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {

    @Test
    public void issueSearchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/eroshenkoam/allure-example");
        $("#issues-tab").click();
        $(withText("#90")).should(Condition.exist);

    }
}
