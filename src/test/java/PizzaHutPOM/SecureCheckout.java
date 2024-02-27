package PizzaHutPOM;

import org.openqa.selenium.By;

public class SecureCheckout {

    public By addName(){
        return By.xpath("//input[@id='checkout__name']");
    }

    public By addNumber(){
        return By.xpath("//input[@id='checkout__phone']");
    }

    public By addEmail(){
        return By.xpath("//input[@id='checkout__email']");
    }

    public By addAddress(){
        return By.xpath("//input[@id='checkout__deliveryAddress.interior']");
    }



    public By clickHeaderLogo(){
        return By.xpath("//span[@class='logo']");
    }
}
