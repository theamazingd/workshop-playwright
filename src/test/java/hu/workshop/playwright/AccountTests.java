package hu.workshop.playwright;


import hu.workshop.playwright.base.TestCaseBase;
import hu.workshop.playwright.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTests extends TestCaseBase {
    @Test
    void testOpenNewCheckingAccount(){
        MainPage mainPage = new MainPage(page);
        mainPage.openNewCheckingAccount();

        assertTrue(mainPage.getOpenAccountResultText().contains("Congratulations, your account is now open."));
        log().info("New account id: " + mainPage.getNewAccountId());
    }

    @Test
    void testOpenNewSavingsAccount(){
        MainPage mainPage = new MainPage(page);
        mainPage.openNewSavingsAccount();

        assertTrue(mainPage.getOpenAccountResultText().contains("Congratulations, your account is now open."));
        log().info("New account id: " + mainPage.getNewAccountId());
    }
}
