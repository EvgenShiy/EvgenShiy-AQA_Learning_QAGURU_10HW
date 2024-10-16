import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;



        // Установка токена в заголовок запроса для аутентификации
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("Authorization", "Bearer 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");
//        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach
    public void afterEach() {
        closeWebDriver();  // Закрытие браузера после каждого теста
    }
}
