Feature: Launch the extension

  Scenario: Verify leadIQ extension is successfully launched
    Given I initiate the driver
    When I launch the leadIQ extension
    Then the extension should be launched

    When I login with valid credentials
    Then Create New is displayed in the campaign dropdown


#  Task - 3 Launch the LeadIQ app through Chrome Extension
#  - 1. Verify that the app extension is launched successfully
#  - 2. Verify that 'Select a campaign' is displayed in the campaign dropdown by default
