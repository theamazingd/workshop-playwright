package hu.workshop.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import hu.workshop.playwright.pages.base.BasePage;

public class MenuPage extends BasePage {

    private final Locator linkAboutUs;
    private final Locator linkServices;
    private final Locator linkProducts;
    private final Locator linkLocations;
    private final Locator linkAdminPage;

    public MenuPage(Page page) {
        super(page);
        this.linkAboutUs = page.locator("ul.leftmenu a:text-is('About Us')");
        this.linkServices = page.locator("ul.leftmenu a:text-is('Services')");
        this.linkProducts = page.locator("ul.leftmenu a:text-is('Products')");
        this.linkLocations = page.locator("ul.leftmenu a:text-is('Locations')");
        this.linkAdminPage = page.locator("ul.leftmenu a:text-is('Admin Page')");
    }

    public void clickAboutUs() {
        linkAboutUs.click();
    }

    public void clickServices() {
        linkServices.click();
    }

    public void clickProducts() {
        linkProducts.click();
    }

    public void clickLocations() {
        linkLocations.click();
    }

    public void clickAdminPage() {
        linkAdminPage.click();
    }
}