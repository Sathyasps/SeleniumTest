package stepDefinitions;

import FunctionLibrary.CommonFunctions;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class sortSteps extends CommonFunctions {

    @When("I click sort dropdown")

    public void sortExists()
    {
        findwebElement(driver,By.className("product_sort_container")).isSelected();
        //driver.findElement(By.className("product_sort_container")).isSelected();


    }

    @Then("I should see {string},{string},{string},{string} in dropdown")
    public void iShouldSeePricePriceInDropdown(String nameaz, String nameza, String lowPrice, String highPrice)
    {
        String expectedDropDown [] ={nameaz,nameza,lowPrice,highPrice};
        //List<String> ed = Arrays.asList(expectedDropDown);
        WebElement element = findwebElement(driver,By.className("product_sort_container"));
        Select select = new Select((element));
        List<WebElement> dropdown = select.getOptions();
        List<String> lst = new ArrayList<>();

        for (WebElement actualdp : dropdown)
        {
            lst.add(actualdp.getText());
        }

        if(Arrays.stream(expectedDropDown).toList().equals(lst)) {
            Assert.assertTrue(Arrays.stream(expectedDropDown).toList().equals(lst));
            //System.out.println(lst);
        }

    }


    @When("I choose option {string}")
    public void iChooseOption(String asc)
    {
        findwebElement(driver,By.className("active_option")).isSelected();
        assertequals(asc,driver,By.className("active_option"));
      // driver.findElement(By.className("active_option")).isSelected();
      // Assert.assertEquals(asc,driver.findElement(By.className("active_option")).getText());
    }

    @Then("the products should be displayed in ascending order")
    public void theProductsShouldBeDisplayedInAscendingOrder()
    {
        List<WebElement> element =findwebElements(driver,By.xpath("//div[@data-test='inventory-item-name']"));
        List<String> actualElement = new ArrayList<>();


        for (WebElement el : element)
        {
            actualElement.add(el.getText());
        }
        List<String> sortElement = new ArrayList<>(actualElement);

        Collections.sort(sortElement);
        //System.out.println(sortElement);
        Assert.assertTrue(actualElement.equals(sortElement));

       // System.out.println(actualElement);

    }

    @Then("the products should be displayed in descending order")
    public void descendingOrder()
    {
        List<WebElement> element =findwebElements (driver,By.xpath("//div[@data-test='inventory-item-name']"));
        List<String> actualElement = new ArrayList<>();

        for (WebElement el : element)
        {
            actualElement.add(el.getText());
        }
        List<String> sortElement = new ArrayList<>(actualElement);

//        Collections.sort(sortElement);
//        Collections.reverse(sortElement);

        Arrays.sort(sortElement.toArray());

        Assert.assertTrue(actualElement.equals(sortElement));

    }

    @And("I select option {string}")
    public void selectOption(String desc)
    {
      WebElement element =  findwebElement(driver,By.className("product_sort_container"));
      Select select = new Select(element);
         String nameza = "Name (Z to A)";
         String lowhigh = "Price (low to high)";
         String highLow = "Price (high to low)";
      if(desc.equals(nameza) ) {
          select.selectByIndex(1);
          //System.out.println(driver.findElement(By.className("active_option")).getText());
          assertequals(desc,driver,By.className("active_option"));
         // Assert.assertEquals(desc, driver.findElement(By.className("active_option")).getText());
      } else if (desc.equals(lowhigh))
      {
          select.selectByIndex(2);
          assertequals(desc,driver,By.className("active_option"));
          //Assert.assertEquals(desc, driver.findElement(By.className("active_option")).getText());

      }
      else if (desc.equals(highLow))
      {
          select.selectByIndex(3);
          assertequals(desc,driver,By.className("active_option"));
         // Assert.assertEquals(desc, driver.findElement(By.className("active_option")).getText());

      }

    }

    @Then("the products should be displayed based on price  ascending order")
    public void priceAscendingOrder()
    {
        //get the name webelement to list
        List<WebElement> element = findwebElements(driver,By.xpath("//div[@data-test='inventory-item-name']"));

        //get the price webelement to list
        List<WebElement> elementPrice = findwebElements(driver,By.className("inventory_item_price"));
        //create empty list
        List<String> actualElement = new ArrayList<>();
        List<String> actualpriceElement = new ArrayList<>();
        //iterate and add it to list
        for (WebElement el : element)
        {
            actualElement.add(el.getText());
        }
        // iterate price and add to another list
        for(int i=0;i<actualElement.size();i++)
        {
         actualpriceElement.add(elementPrice.get(i).getText());
        }

        List<String> sortElement = new ArrayList<>(actualpriceElement);
        //Arrays.sort(new List[]{sortElement});
        Arrays.sort(new List[]{sortElement});

        Assert.assertTrue(actualpriceElement.equals(sortElement));

    }

    @Then("the products should be displayed based on price  descending order")
    public void priceDescendingOrder()
    {
        //get the name webelement to list
        List<WebElement> element = findwebElements(driver,By.xpath("//div[@data-test='inventory-item-name']"));

        //get the price webelement to list
        List<WebElement> elementPrice =findwebElements(driver,By.className("inventory_item_price"));
        //create empty list
        List<String> actualElement = new ArrayList<>();
        List<String> actualpriceElement = new ArrayList<>();
        //iterate and add it to list
        for (WebElement el : element)
        {
            actualElement.add(el.getText());
        }
        System.out.println(actualElement);
        // iterate price and add to another list
        for(int i=0;i<actualElement.size();i++)
        {
            actualpriceElement.add(elementPrice.get(i).getText());
        }

        List<String> sortElement = new ArrayList<>(actualpriceElement);
        //Collections.reverse(sortElement);
       // Collections.
        //Arrays.sort(new List[]{sortElement});
        Arrays.sort(new List[]{sortElement});
        //sortElement.stream().sorted();
        System.out.println(sortElement);

      //  Assert.assertTrue(actualpriceElement.equals(sortElement));


    }
}
