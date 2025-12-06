package hu.workshop.playwright;


import hu.workshop.playwright.base.TestCaseBase;
import hu.workshop.playwright.pages.MainPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends TestCaseBase {
    @Test
    @Disabled("Login test is not needed")
    void testLogIn(){
        MainPage mainPage = new MainPage(page);
        mainPage.logIn();
        assertThat(mainPage.getLogOutLink()).isVisible();
        assertThat(mainPage.getLogOutLink()).isEnabled();
    }
}
