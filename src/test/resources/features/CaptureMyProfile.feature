Feature: Launch the extension

  Scenario: Verify leadIQ extension is successfully launched
    Given I initiate the driver
    And I launch the leadIQ extension
    And I login with valid credentials
    When I click on See example button
    And I login to Linkedln with valid credentials
    And I search for "Yakup Cemil Kahveci" to see the full profile
    And I switch to extension and capture the profile into current campaign
    Then First name, Last name, company name and profile photo in the extension should be the same as those in Linkedln
