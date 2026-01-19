Feature: Login

  Scenario: Login using valid information
    Given I'm at the Accounts Page
    When I use login in with valid credentials
      | Username  | password  |
      | t_nkundwa | t_nkundwa |
    Then I should be taken to the accounts page of my personal account
    And I should receive a successful message

  Scenario: Login using invalid username
    Given I'm at the Accounts Page
    When I use login in with invalid username
      | Username  | password  |
      | toughGang | t_nkundwa |
    Then the login should fail and I should receive a invalid username error message

  Scenario: Login using invalid password
    Given I'm at the Accounts Page
    When I use login in with invalid password
      | Username  | password |
      | t_nkundwa | rastaman |
    Then the login should fail and I should receive a invalid password error message