package hu.workshop.playwright.base;

import com.microsoft.playwright.*;
import hu.workshop.playwright.annotations.SkipLogin;
import hu.workshop.playwright.pages.MainPage;
import hu.workshop.playwright.utils.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.logging.Logger;

public class TestCaseBase {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected Logger log() {
        return Logger.getLogger(this.getClass().getName());
    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        boolean isLoginNeeded = testInfo.getTestMethod()
                .map(m -> !m.isAnnotationPresent(SkipLogin.class))
                .orElse(true);

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(Config.getBoolean("headless"))
        );
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://parabank.parasoft.com/parabank/index.htm");

        if (isLoginNeeded) {
            logIn();
        }
    }

    @AfterEach
    void teardown() {
        if (page != null) {
            page.close();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    private void logIn() {
        MainPage mainPage = new MainPage(page);
        mainPage.logIn();
    }

    private void logOut() {
        MainPage mainPage = new MainPage(page);
        mainPage.logOut();
    }
}
