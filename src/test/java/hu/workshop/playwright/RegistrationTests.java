package hu.workshop.playwright;


import hu.workshop.playwright.annotations.SkipLogin;
import hu.workshop.playwright.base.TestCaseBase;
import hu.workshop.playwright.pages.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistrationTests extends TestCaseBase {
    @Test
    @SkipLogin
    void testRegistration(){
        String randomId = RandomStringUtils.randomAlphanumeric(6);
        RegistrationPage registrationPage = new RegistrationPage(page);
        registrationPage.clickRegister().register("user_" + randomId, randomId);
        assertThat(registrationPage.divRightPanel).containsText("Your account was created successfully.");
        log().info("Username: user_" + randomId + "\npassword: " + randomId);
    }
}
