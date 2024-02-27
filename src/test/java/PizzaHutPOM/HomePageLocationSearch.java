package PizzaHutPOM;

import org.openqa.selenium.By;

public class HomePageLocationSearch {

    public By addLocation(){

        return By.xpath("//div/input[1][@placeholder ='Enter your location for delivery']");
    }

    public By unwantedPopup(){
        return By.xpath("//div/button[contains(@class,'icon-close--white')]");
    }
}
