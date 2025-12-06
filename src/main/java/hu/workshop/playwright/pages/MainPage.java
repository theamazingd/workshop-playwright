package hu.workshop.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import hu.workshop.playwright.pages.base.BasePage;
import hu.workshop.playwright.utils.Config;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MainPage extends BasePage {

    private final Locator inputUsername;
    private final Locator inputPassword;
    private final Locator inputSubmit;
    private final Locator inputOpenNewAccount;
    private final Locator linkNewAccount;
    private final Locator linkLogOut;
    private final Locator linkNewAccountId;
    private final Locator divOpenAccountResult;

    public MainPage(Page page) {
        super(page);
        this.inputUsername = page.locator("input[name='username']");
        this.inputPassword = page.locator("input[name='password']");
        this.inputSubmit = page.locator("div.login input.button");
        this.inputOpenNewAccount = page.locator("input.button[value='Open New Account']");
        this.linkNewAccount = page.locator("a:text-is('Open New Account')");
        this.linkLogOut = page.locator("a:text-is('Log Out')");
        this.linkNewAccountId = page.locator("a#newAccountId");
        this.divOpenAccountResult = page.locator("div#openAccountResult");
    }

    public void logIn() {
        inputUsername.fill(Config.get("username"));
        inputPassword.fill(Config.get("password"));
        inputSubmit.click();
    }

    public void logOut() {
        linkLogOut.click();
    }

    public String getNewAccountId() {
        assertThat(linkNewAccountId).not().hasText("");
        return linkNewAccountId.textContent();
    }

    public String getOpenAccountResultText() {
        return divOpenAccountResult.textContent();
    }

    public Locator getLogOutLink() {
        return linkLogOut;
    }

    public void openNewCheckingAccount(){
        linkNewAccount.click();
        selectAccountType("CHECKING");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        inputOpenNewAccount.click();
    }

    public void openNewSavingsAccount(){
        linkNewAccount.click();
        selectAccountType("SAVINGS");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        inputOpenNewAccount.click();
    }

    private void selectAccountType(String label) {
        page.selectOption("select#type", new SelectOption().setLabel(label));
    }
}