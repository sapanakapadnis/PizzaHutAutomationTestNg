package PizzaHutPOM;

import org.openqa.selenium.By;

public class OrderPage {
    public By checkDealsURL(){

        return By.xpath("//div[contains(@class,'side-menu')]/div/a[contains(@href,'deals')]");
    }

    public By pizzaLink(){
        return By.xpath("//div[contains(@class,'side-menu')]/div/a[contains(@href,'pizza')]");
    }


    public By drinksLink(){
        return By.xpath("//div[contains(@class,'side-menu')]/div/a[contains(@href,'drinks')]");
    }

    public By checkoutButton(){
        return By.xpath("//span[text()='Checkout']");
    }


    public By addPizza(){
        return By.xpath("//button[contains(@data-synth,'mazedar-makhni-paneer')][1]");
    }

    public By addDrinks(){
        return By.xpath("//button[contains(@data-synth,'pepsi-black')]");
    }
}
