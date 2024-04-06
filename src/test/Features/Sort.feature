Feature: Sort
  I should be able to sort the products

  Background: Bag
    Given I am on homepage "https://www.saucedemo.com/"
    When I do login with username "standard_user"  and password "secret_sauce"

@Sort
  Scenario: Verify sort options

    When I click sort dropdown
    Then I should see "Name (A to Z)","Name (Z to A)","Price (low to high)","Price (high to low)" in dropdown

  @Sort

  Scenario: Verify Sort Options "Name (A to Z)"

    When I choose option "Name (A to Z)"
    Then the products should be displayed in ascending order

  @Sort

  Scenario: Verify Sort Options "Name (Z to A)"

    And I select option "Name (Z to A)"
    Then the products should be displayed in descending order

  @Sort

  Scenario: Verify Sort Options "Price (low to high)"

    And I select option "Price (low to high)"
    Then the products should be displayed based on price  ascending order

  @Sort
    Scenario: Verify Sort Options "Price (high to low)"

      And I select option "Price (high to low)"
      Then the products should be displayed based on price  descending order

  @Sort

  Scenario: Verify Sort Options "Price (high to low)" and add product to cart

    And I select option "Price (high to low)"
    When the products should be displayed based on price  descending order

    And I choose a product "Sauce Labs Fleece Jacket"
    When I click Add to cart button with badge "1"
    And I click on bag icon
    Then I should be see product "Sauce Labs Fleece Jacket" in the bag.