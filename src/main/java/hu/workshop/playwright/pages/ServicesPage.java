package hu.workshop.playwright.pages;

import com.microsoft.playwright.Page;
import hu.workshop.playwright.pages.base.BasePage;

public class ServicesPage extends BasePage {

    public ServicesPage(Page page) {
        super(page);
    }

    public String getEndpointAddress(String serviceName) {
        return page.locator("tr:has(td:has-text('" + serviceName + "')) span:has-text('Endpoint address') + span.value").textContent();
    }
}