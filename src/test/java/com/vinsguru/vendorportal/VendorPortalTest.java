package com.vinsguru.vendorportal;

import com.vinsguru.util.jsonUtil;
import com.vinsguru.AbstractTest;
import com.vinsguru.pages.vendorportal.DashboardPage;
import com.vinsguru.pages.vendorportal.LoginPage;
import com.vinsguru.vendorportal.model.VendorPortalTestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class VendorPortalTest extends AbstractTest {
    private VendorPortalTestData testData;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(@Optional("defaultTestDataPath") String testDataPath) {
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testData = jsonUtil.getTesData(testDataPath, VendorPortalTestData.class);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.username(), testData.password());
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() throws InterruptedException {
        Assert.assertTrue(dashboardPage.isAt());
        Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());

        dashboardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashboardPage.getResultsCount(), testData.searchResultCount());
    }
//    @Test(dependsOnMethods = "dashboardTest")
//    public void logoutTest(){
////        dashboardPage.logout();
////        Assert.assertTrue(loginPage.isAt());
//    }


}
