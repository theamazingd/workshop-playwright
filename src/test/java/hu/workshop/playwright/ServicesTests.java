package hu.workshop.playwright;


import hu.workshop.playwright.base.TestCaseBase;
import hu.workshop.playwright.pages.MenuPage;
import hu.workshop.playwright.pages.ServicesPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicesTests extends TestCaseBase {
    @Test
    void testCheckBookstoreEndpoint(){
        MenuPage menuPage = new MenuPage(page);
        ServicesPage servicesPage = new ServicesPage(page);

        menuPage.clickServices();
        String endpointAddress = servicesPage.getEndpointAddress("Bookstore");
        assertEquals("http://parabank.parasoft.com:8080/parabank/services/store-01", endpointAddress);
    }
    @Test
    void testCheckBookstoreNewVersionEndpoint(){
        MenuPage menuPage = new MenuPage(page);
        ServicesPage servicesPage = new ServicesPage(page);

        menuPage.clickServices();
        String endpointAddress = servicesPage.getEndpointAddress("Bookstore (Version 2.0)");
        assertEquals("http://parabank.parasoft.com:8080/parabank/services/store-01", endpointAddress);
    }
    @Test
    void testCheckBookstoreUsernameEndpoint(){
        MenuPage menuPage = new MenuPage(page);
        ServicesPage servicesPage = new ServicesPage(page);

        menuPage.clickServices();
        String endpointAddress = servicesPage.getEndpointAddress("Bookstore (WS-Security Username Token)");
        assertEquals("http://parabank.parasoft.com:8080/parabank/services/store-01", endpointAddress);
    }
}
