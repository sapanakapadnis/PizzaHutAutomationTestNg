package PizzaHutPOM;

import org.openqa.selenium.By;

public class PopUp {
    public By validateH3Text(){
        return By.xpath("//div/h3/span");
    }

    public By closeButton(){
        return By.xpath("//div/button[contains(@class,'remove')]");
    }
}
