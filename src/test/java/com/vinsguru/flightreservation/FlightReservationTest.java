package com.vinsguru.flightreservation;

import com.vinsguru.flightreservation.model.ClearSessionInGrid;
import com.vinsguru.util.Config;
import com.vinsguru.util.jsonUtil;
import com.vinsguru.AbstractTest;
import com.vinsguru.flightreservation.model.FlightReservationTestData;
import com.vinsguru.pages.flightreservation.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.atomic.AtomicInteger;

public class FlightReservationTest extends AbstractTest {
    private FlightReservationTestData testData;
private static AtomicInteger completedTests=new AtomicInteger(0);

    @BeforeTest
    @Parameters("testDataPath")
    public void setParameters(@Optional("defaultTestDataPath") String testDataPath) {
        this.testData = jsonUtil.getTesData(testDataPath, FlightReservationTestData.class);
    }

    @Test
    public void userRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);


        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());
        registrationPage.enterUserDetails(testData.firstname(), testData.lastname());
        registrationPage.enterUserCredentails(testData.email(), testData.password());
        registrationPage.enterAddress(testData.street(), testData.city(), testData.zip());
        registrationPage.register();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationTest() {
        RegistrationComfirmationPage registrationComfirmationPage = new RegistrationComfirmationPage(driver);
        Assert.assertTrue(registrationComfirmationPage.isAt());
        Assert.assertEquals(registrationComfirmationPage.getFirstName(),testData.firstname());
        registrationComfirmationPage.goToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest() {
        FlightsSearchPage flightsSearchPage = new FlightsSearchPage(driver);
        Assert.assertTrue(flightsSearchPage.isAt());
        flightsSearchPage.selectPassengers(testData.passengersCount());
        flightsSearchPage.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightsSelectionTest() {
        FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage(driver);
        Assert.assertTrue(flightsSelectionPage.isAt());
        flightsSelectionPage.selectFlights();
        flightsSelectionPage.confirmFlight();
    }

    @Test(dependsOnMethods = "flightsSelectionTest")
    public void flightReservationConfirmation() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        Assert.assertEquals(flightConfirmationPage.getPrice(), testData.expectedPrice());
    }
    @AfterSuite
    public void clearSessions(){
//        ClearSessionInGrid clear=new ClearSessionInGrid();
//        clear.clearGridSessionsAfterSuite();
    }
//    @AfterMethod
//    public void tearDown() {
//        // Quit the WebDriver after each test method
//        driver.quit();
//    }
}
