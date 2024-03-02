package pizzahutMain;

import PizzaHutPOM.HomePageLocationSearch;
import PizzaHutPOM.OrderPage;
import PizzaHutPOM.PopUp;
import PizzaHutPOM.SecureCheckout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ActionClass.ActionPizzaHut;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class PizzaHutTask extends ActionPizzaHut{

    private WebDriver driver=null;

    HomePageLocationSearch homepageObject;
    OrderPage orderpageObject;

    PopUp popupPageObject;

    SecureCheckout checkoutPageObject;

    @BeforeClass
    public void launchBrowser(){
        driver = getDriver();
        driver.manage().window().maximize();
        driver.get(readProperties("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        homepageObject = new HomePageLocationSearch();
        orderpageObject = new OrderPage();
        popupPageObject = new PopUp();
        checkoutPageObject = new SecureCheckout();

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }


    @Test
    public void pizzaHutOperations() throws InterruptedException {

        //Go to homepage and enter address
        Assert.assertTrue(validateElementPresent(homepageObject.addLocation()));
        clickImplictWait(homepageObject.addLocation());
        //clickImplictWait(homepageObject.unwantedPopup());
        typeInaTextBox(homepageObject.addLocation(),"cummins college");
        Thread.sleep(1000);
        hitEnter(homepageObject.addLocation());
        Thread.sleep(1000);

        //validate deals URL
        Assert.assertTrue(validateElementPresent(orderpageObject.checkDealsURL()));

        //click on Pizza Link
        Assert.assertTrue(validateElementPresent(orderpageObject.pizzaLink()));
        clickExplicitWait(orderpageObject.pizzaLink(),100);


        //get pizza item list
        int totalInventoryCount = driver.findElements(By.xpath("//div//a[@class='list-item list-item--pizza ']")).size();

        System.out.println(totalInventoryCount);
        Assert.assertEquals(totalInventoryCount,52);

        for(int i = 1;i <=totalInventoryCount; i++){
            String productName = driver.findElement(By.xpath("(//div//a[@class='list-item list-item--pizza ']/div[2])["+i+"]")).getText();
            System.out.println(productName);

        }

        //click checkout button
        clickExplicitWait(orderpageObject.checkoutButton(),1000);

        //popup text validate
        Assert.assertTrue(validateElementPresent(popupPageObject.validateH3Text()));

        //Close popup
        clickImplictWait(popupPageObject.closeButton());
        //add pizza in cart
        clickImplictWait(orderpageObject.addPizza());

        //count 1
        String count1 = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']")).getText();

        Assert.assertEquals(count1,"1 item");

        
        //click on drinks
        clickImplictWait(orderpageObject.drinksLink());
        //add drinks
        clickImplictWait(orderpageObject.addDrinks());


        //count 2
        String count2 = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']")).getText();

        Assert.assertEquals(count2,"2 items");

        
        //click checkout button
        clickImplictWait(orderpageObject.checkoutButton());

        //add info in form
        String name = readProperties("name");
        typeInaTextBox((checkoutPageObject.addName()),name);
        String number = readProperties("mobilenumber");
        typeInaTextBox(checkoutPageObject.addNumber(),number);
        String address = readProperties("address");
        typeInaTextBox(checkoutPageObject.addAddress(),address);
        String email = readProperties("email");
        typeInaTextBox(checkoutPageObject.addEmail(),email);


        //check if radio button selected by default
        String str = driver.findElement(By.id("payment-method--razorpay")).getAttribute("checked");
        if (str.equalsIgnoreCase("true"))
        {
            System.out.println("Checkbox selected by default");
        }

        clickImplictWait(checkoutPageObject.clickHeaderLogo());

    }

}
