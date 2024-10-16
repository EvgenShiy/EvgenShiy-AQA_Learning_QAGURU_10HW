import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    public void issueSearchTest(){
        open("/eroshenkoam/allure-example"); // "/eroshenkoam/allure-example"
//
//        $("href='/eroshenkoam?tab=repositories'").click();
//        $("#your-repos-filter").sendKeys("allure-example");
//        $("#your-repos-filter").submit();
//
//        $(linkText("allure-example")).click();
        $("#issues-tab").click();
        $(withText("#90")).should(Condition.exist);


    }
}
