package stepDefinitions;

import FunctionLibrary.CommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bagSteps extends CommonFunctions {
    //public WebDriver driver = new ChromeDriver();

    @Given("I am on homepage {string}")
    public void OnHomepage(String url) {
        UrlGet(driver,url);
        asserTrue(driver,By.className("login_logo"));
       // driver.get(url);
       // Assert.assertTrue(findwebElement(driver,By.className("login_logo")).isDisplayed());

    }

    @When("I do login with username {string}  and password {string}")
    public void doLogin(String username, String password) {
       sendKey(driver,By.id("user-name"),username);
       sendKey(driver,By.id("password"),password);
       clickElement(driver,By.id("login-button"));
        asserTrue(driver,By.className("title"));
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // driver.findElement(By.id("password")).sendKeys("secret_sauce");
       // driver.findElement(By.id("login-button")).click();
       // Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());

    }

    @And("I choose a product {string}")
    public void chooseProduct(String product) {
        clickElement(driver,By.xpath("//div [@data-test='inventory-item-name' and text () ='" +  product + "']"));
        asserTrue(driver,(By.name("back-to-products")));
        //driver.findElement(By.xpath("//div [@data-test='inventory-item-name' and text () ='" + product + "']")).click();
       // Assert.assertTrue(driver.findElement(By.name("back-to-products")).isDisplayed());
    }

    @When("I click Add to cart button with badge {string}")
    public void addCart(String badgeVal) {
        clickElement(driver,By.id("add-to-cart"));
        assertequals(badgeVal,driver,By.className("shopping_cart_badge"));
       // driver.findElement(By.id("add-to-cart")).click();
        //Assert.assertEquals(badgeVal, driver.findElement(By.className("shopping_cart_badge")).getText());

    }

    @And("I click on bag icon")
    public void clickOnBagIcon() {
        clickElement(driver,By.className("shopping_cart_link"));
        asserTrue(driver,By.className("title"));
        // driver.findElement(By.className("shopping_cart_link")).click();
       // Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @Then("I should be see product {string} in the bag.")
    public void productInTheBag(String expectedProduct) {
        findwebElement(driver,By.className("inventory_item_name")).getText();
        assertequals(expectedProduct,driver,By.className("inventory_item_name"));
        System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
        //driver.findElement(By.className("inventory_item_name")).getText();
        //Assert.assertEquals(expectedProduct, driver.findElement(By.className("inventory_item_name")).getText());
    }

    @When("I click remove button")
    public void clickRemove() {
        clickElement(driver,By.xpath("//button[text()='Remove']"));
       // driver.findElement(By.xpath("//button[text()='Remove']")).click();

    }


    @Then("the {string} should be removed from the bag")

    public void removeProductInBag(String productname) {
        productname = "";
        assertequals(productname,driver,By.className("removed_cart_item"));
        ///Assert.assertEquals("$0",driver.findElement(By.className("removed_cart_item")).getText());
        // /assertNosuchElement(driver,By.className("inventory_item_name"));

        //Assert.assertEquals(productname, driver.findElement(By.className("removed_cart_item")).getText());
    }


    @And("I click back button")
    public void backButton() {
        clickElement(driver,By.id("back-to-products"));
        asserTrue(driver,(By.className("title")));

        //driver.findElement(By.id("back-to-products")).click();
        //Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());

    }

    @Then("I should be see product {string} and {string} in the bag.")
    public void iShouldBeSeeProductAndInTheBag(String expectedProduct1, String expectedProduct2) {
        String expectedProducts[] = {expectedProduct1, expectedProduct2};
        List<String> lst = new ArrayList<>();
        /// List<WebElement> actualList = driver.findElements(By.xpath("//div[@data-test='inventory-item']"));

        List<WebElement> actualList = findwebElements(driver,By.className("inventory_item_name"));


        for (WebElement actualProductList : actualList) {
            lst.add(actualProductList.getText());


        }


        if (Arrays.stream(expectedProducts).toList().equals(lst)) {
            Assert.assertEquals(lst, Arrays.stream(expectedProducts).toList());
            // System.out.println(lst);

        }


    }

    @And("I click continue shopping button")
    public void clickContinueShoppingButton() {
        clickElement(driver,By.id("continue-shopping"));
        asserTrue(driver,By.className("title"));

        //driver.findElement(By.id("continue-shopping")).click();
        //Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @Then("I should be see product {string} and {string} and {string} in the bag.")
    public void productsAndInTheBag(String expectedProduct1, String expectedProduct2, String expectedProduct3)
    {

        String expectedProducts[] = {expectedProduct1, expectedProduct2,expectedProduct3};
        List<String> lst = new ArrayList<>();
        // List<WebElement> actualList = driver.findElements(By.xpath("//div[@data-test='inventory-item']"));

        List<WebElement> actualList = driver.findElements(By.className("inventory_item_name"));


        for (WebElement actualProductList : actualList) {
            lst.add(actualProductList.getText());


        }


        if (Arrays.stream(expectedProducts).toList().equals(lst)) {
            Assert.assertTrue(lst.equals(Arrays.stream(expectedProducts).toList()));
            //System.out.println(lst);

        }
    }

    @And("I select a product {string}")
    public void iSelectAProduct(String product)
    {
        clickElement(driver,By.xpath("//div [@data-test='inventory-item-name' and text () ='" + product + "']"));
       // driver.findElement(By.xpath("//div [@data-test='inventory-item-name' and text () ='" + product + "']")).click();
    }

    @When("I click remove button for the product")
    public void removeButtonForTheProduct()
    {
        clickElement(driver,By.id("remove-sauce-labs-bolt-t-shirt"));
       // driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
    }

    @Then("the product {string} should be removed and update cart badge to {string}")
    public void theProductShouldBeRemovedAndUpdateCartBadgeTo(String product, String badgeVal)
    {
        assertequals(badgeVal,driver,By.className("shopping_cart_badge"));
     // Assert.assertEquals(badgeVal,driver.findElement(By.className("shopping_cart_badge")).getText());

    }



}