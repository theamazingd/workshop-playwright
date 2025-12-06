package hu.workshop.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import hu.workshop.playwright.pages.base.BasePage;

public class RegistrationPage extends BasePage {

    private final Locator linkRegister;
    private final Locator inputFirstName;
    private final Locator inputLastName;
    private final Locator inputAddress;
    private final Locator inputCity;
    private final Locator inputState;
    private final Locator inputZipCode;
    private final Locator inputSsn;
    private final Locator inputUsername;
    private final Locator inputPassword;
    private final Locator inputConfirm;
    private final Locator inputSubmit;
    public final Locator divRightPanel;
    public RegistrationPage(Page page) {
        super(page);
        this.linkRegister = page.locator("a:text-is('Register')");
        this.inputFirstName = page.locator("input[id='customer.firstName']");
        this.inputLastName = page.locator("input[id='customer.lastName']");
        this.inputAddress = page.locator("input[id='customer.address.street']");
        this.inputCity = page.locator("input[id='customer.address.city']");
        this.inputState = page.locator("input[id='customer.address.state']");
        this.inputZipCode = page.locator("input[id='customer.address.zipCode']");
        this.inputSsn = page.locator("input[id='customer.ssn']");
        this.inputUsername = page.locator("input[id='customer.username']");
        this.inputPassword = page.locator("input[id='customer.password']");
        this.inputConfirm = page.locator("input[id='repeatedPassword']");
        this.inputSubmit = page.locator("input[value='Register'].button");
        this.divRightPanel = page.locator("div#rightPanel");
    }

    public RegistrationPage clickRegister() {
        linkRegister.click();
        return this;
    }

    public void register(String username, String password) {
        inputFirstName.fill("dummyFirstName_" + password);
        inputLastName.fill("dummyLastname_" + password);
        inputAddress.fill("dummyAddress_" + password);
        inputCity.fill("dummyCity_" + password);
        inputState.fill("dummyState_" + password);
        inputZipCode.fill("1234_" + password);
        inputSsn.fill("1234_" + password);
        inputUsername.fill(username);
        inputPassword.fill(password);
        inputConfirm.fill(password);
        inputSubmit.click();
    }
}