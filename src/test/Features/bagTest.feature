Feature: BagTest
  I Should be able to add/delete the products

  Background: Bag
    Given I am on homepage "https://www.saucedemo.com/"
    When I do login with username "standard_user"  and password "secret_sauce"
    And I choose a product "Sauce Labs Bolt T-Shirt"
    When I click Add to cart button with badge "1"


   @bag
  Scenario: Verify product from bag

  @bag
  Scenario: Remove product from bag
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" in the bag.
    When I click remove button
    Then the "Sauce Labs Bolt T-Shirt" should be removed from the bag


  @bag
  Scenario: Add more products to the bag

    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
    And I click continue shopping button
    And I select a product "Sauce Labs Fleece Jacket"
    When I click Add to cart button with badge "3"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" in the bag.
  @bag
Scenario: Remove one Product from the bag

  And I click back button
  And I choose a product "Sauce Labs Bike Light"
  When I click Add to cart button with badge "2"
  And I click on bag icon
  Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
  And I click continue shopping button
  And I select a product "Sauce Labs Fleece Jacket"
  When I click Add to cart button with badge "3"
  And I click on bag icon
  Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" in the bag.
  When I click remove button for the product
  Then the product "Sauce Labs Bolt T-Shirt" should be removed and update cart badge to "2"

  @bag
  Scenario: Add more products to the bag and checkout

    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
    And I click continue shopping button
    And I select a product "Sauce Labs Fleece Jacket"
    When I click Add to cart button with badge "3"
    And I click on bag icon
    And I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" in the bag.
    When I click checkout button
    Then checkout details page should be displayed.


