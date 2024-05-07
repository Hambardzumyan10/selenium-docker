package com.vinsguru.pages.flightreservation;

import com.vinsguru.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsSearchPage extends AbstractPage
{
    @FindBy(id = "passengers")
    private WebElement passengerSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightButton;

    public FlightsSearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengerSelect));
        return this.passengerSelect.isDisplayed();
    }
    public void selectPassengers(String n0ofPassengers){
        Select passengers=new Select(this.passengerSelect);
        passengers.selectByValue(n0ofPassengers);
    }
    public void searchFlights(){
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", this.searchFlightButton);
        this.searchFlightButton.click();
    }
}
