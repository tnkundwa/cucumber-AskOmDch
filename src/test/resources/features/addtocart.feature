Feature: Add product to cart
  As a customer of AskOmDch website
  I want to add a product to the cart
  So that I can purchase the product

  Rule: Add product from StorePage

    Scenario Outline:Add one Quantity to the cart
      Given I'm on the Store Page
      When I add a "<product_name>" to the cart
      Then I should see 1 "<product_name>" in the cart
      Examples:
        | product_name    |
        | Blue Shoes      |
        | Anchor Bracelet |
        | Blue Tshirt     |

#    Scenario: Add one quantity from Store
#      Given I'm on the Store Page
#      When I add a "Blue Shoes" to the cart
#      Then I should see 1 "Blue Shoes" in the cart