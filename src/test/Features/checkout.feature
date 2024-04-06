Feature: Checkout
  Background: Verify Checkout info

  Background: Bag
    Given I am on homepage "https://www.saucedemo.com/"
    When I do login with username "standard_user"  and password "secret_sauce"


  Scenario: Verify checkout information without enter any details

      And I choose a product "Sauce Labs Bolt T-Shirt"
      When I click Add to cart button with badge "1"
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
    When checkout details page should be displayed.
    And I click on Continue button
    Then the error "Error: First Name is required" should be displayed


  Scenario: Verify checkout information entering firstname
    And I choose a product "Sauce Labs Bolt T-Shirt"
    When I click Add to cart button with badge "1"
    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
    When I click checkout button
    When checkout details page should be displayed.
    And I click on Continue button
    When the error "Error: First Name is required" should be displayed
    And click on error button
    When I enter first name as "Sample"
    And I click on Continue button
    Then the error "Error: Last Name is required" should be displayed


  Scenario: Verify checkout information entering firstname,Lastname,PostalCode
    And I choose a product "Sauce Labs Bolt T-Shirt"
    When I click Add to cart button with badge "1"
    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
    When I click checkout button
    When checkout details page should be displayed.
    And I click on Continue button
    When the error "Error: First Name is required" should be displayed
    And click on error button
    When I enter first name as "Sample"
    When I enter last name as "test"
    And I click on Continue button
    Then the error "Error: Postal Code is required" should be displayed
    And click on error button



  @checkout
  Scenario: Verify checkout information entering firstname,Lastname,Postal code
    And I choose a product "Sauce Labs Bolt T-Shirt"
    When I click Add to cart button with badge "1"
    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
    When I click checkout button
    When checkout details page should be displayed.
    And I click on Continue button
    When the error "Error: First Name is required" should be displayed
    And click on error button
    When I enter first name as "Sample"
    When I enter last name as "test"
    And I click on Continue button
    When I enter postalCode "SG123"
    And I click on Continue button
    Then I should redirect to checkout overview page

    @checkout
    Scenario:Verify and ConfirmOrder

      And I choose a product "Sauce Labs Bolt T-Shirt"
      When I click Add to cart button with badge "1"
      And I click back button
      And I choose a product "Sauce Labs Bike Light"
      When I click Add to cart button with badge "2"
      And I click on bag icon
      Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
      When I click checkout button
      When checkout details page should be displayed.
      When I enter first name as "Sample"
      When I enter last name as "test"
      When I enter postalCode "SG123"
      And I click on Continue button
      And I should redirect to checkout overview page
      When I click finish button
      Then my order should go through

  @checkout
  Scenario:verify back home after order the products

    And I choose a product "Sauce Labs Bolt T-Shirt"
    When I click Add to cart button with badge "1"
    And I click back button
    And I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    And I click on bag icon
    Then I should be see product "Sauce Labs Bolt T-Shirt" and "Sauce Labs Bike Light" in the bag.
    When I click checkout button
    When checkout details page should be displayed.
    When I enter first name as "Sample"
    When I enter last name as "test"
    When I enter postalCode "SG123"
    And I click on Continue button
    And I should redirect to checkout overview page
    When I click finish button
    When my order should go through

    And I click backhome button
    Then I should be direct to home page