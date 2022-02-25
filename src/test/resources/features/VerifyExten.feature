Feature: Install the extension

  @wip
  Scenario: Verify leadIQ extension is installed
    Given I initiate the driver
    When I check the extensions in developer mode
    Then I see that LeadIQ extension is installed and ID is the below
      | befngoippmpmobkkpkdoblkmofpjihnk |
    And version is "6.2.0"


#   Task - 2 Install the LeadIQ Extension
#   - 1. Verify extension is successfully installed
#   - 2. You can automate the installation with the .crx file for chrome extension instead of downloading from chrome store
