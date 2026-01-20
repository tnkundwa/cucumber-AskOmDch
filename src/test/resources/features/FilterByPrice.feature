Feature: Filter by Price
  As a customer
  I want to be able to adjust the price and get the products within that price range
  So that I can easily find the products I want

  Scenario Outline: Filtering products by price
    Given I'm on the Store Page
    When I adjust the price slider by <slideRight> <slideLeft>
    Then only the products within the price range are displayed

    Examples:
      | slideRight | slideLeft |
      | 3          | 4         |
      | 2          | 5         |