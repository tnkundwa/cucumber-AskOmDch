Feature: Browsing By Category

  Scenario: Browsing By Category
    Given I'm on the Store Page
    When I select an option from the dropdown of the browse by category section
      | browseOption |
      | men          |
      | women        |
    Then I should only see the items that match that category on the page
