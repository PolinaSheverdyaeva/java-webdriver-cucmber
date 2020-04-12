@usps
Feature: USPS test suite

  @usps1
  Scenario Outline: Validate ZIP code for different addresses
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result
    Examples:
      | street              | city      | state | zip   |
      | 4970 El Camino Real | Los Altos | CA    | 94022 |
      | 11 Wall St          | New York  | NY    | 10005 |
      | 111 S Michigan Ave  | Chicago   | IL    | 60603 |

#  @usps2
#  Scenario: Validate ZIP code for NY Stock Exchange
#    Given I go to "usps" page
#    When I go to Lookup ZIP page by address
#    And I fill out "11 Wall St" street, "New York" city, "NY" state
#    Then I validate "10005" zip code exists in the result
#
#  @usps3
#  Scenario: Validate ZIP code of Art Institute of Chicago
#    Given I go to "usps" page
#    When I go to Lookup ZIP page by address
#    And I fill out "111 S Michigan Ave" street, "Chicago" city, "IL" state
#    Then I validate "60603" zip code exists in the result
#

  @usps4
  Scenario: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price Page
    And I select "United Kingdom (United Kingdom of Great Britain and Northern Ireland)" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.30"

  @usps5
  Scenario: Phone number of the nearest Accountable Mail Pickup Service Post Office for Portnov Computer School
    Given I go to "usps" page
    When I go to Find a Location Page
    And I filter by "Post Offices™" Location Types, "Pickup Services" Services, "Accountable Mail" Available Services
    And I fill in "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
    Then I print the phone number and validate it is "800-275-8777"

#  @usps9
#  Scenario: Informed delivery enabled
#    Given I go to "usps" page
#    When I go to "Informed Delivery" section
#    And I enter "94022" zip for informed delivery
#    Then I verify that informed delievry is "enabled"
#
#  @usps10
#  Scenario: Informed delivery enabled
#    Given I go to "usps" page
#    When I go to "Informed Delivery" section
#    And I enter "23424" zip for informed delivery
#    Then I verify that informed delievry is "disabled"

#  @usps11
#  Scenario: Verify location
#    Given I go to "usps" page
#    When I perform "Free Boxes" search
#    And I set "Mail & Ship" in filters
#    Then I verify that "7" results found
#    When I select "Priority Mail | USPS" in results
#    And I click "Ship Now" button
#    Then I validate that Sign In is required
#
#  @usps12
#  Scenario: Quadcopters delivery
#    Given I go to "usps" page
#    When I go to "Help" tab
#    And I perform "Quadcopters delivery" help search
#    Then I verify that no results of "Quadcopters delivery" available in help search

#  @usps15
#  Scenario: Search
#    Given I go to "usps" page
#    And I search on main page for "PO BOX"


#  @usps14
#  Scenario: Every door direct mail
#    Given I go to "usps" page
#    When I go to "Every Door Direct Mail" under "Business"
#    And I search for "4970 El Camino Real, Los Altos, CA 94022"
#    And I click "Show Table" on the map
#    When I click "Select All" on the table
#    And I close modal window
#    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary
#
#
#  @converter1
#  Scenario: Validate Fahrenheit to Celsius
#    Given I go to "converter" page
#    When I click on "Temperature"
#    And I set "Fahrenheit" to "Celsius"
#    Then I enter into From field "54" and verify "12.2" result
#
#  @calculator1
#  Scenario: Verify calculator result
#    Given I go to "calculator" page
#    And I clear all calculator fields
#    And I calculate
#    Then I verify "Please provide a positive auto price." calculator error
#    Then I verify "Please provide a positive interest value." calculator error
#    And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
#    And I calculate
#    Then I verify monthly pay is "$372.86"

