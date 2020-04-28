@auPost
Feature: Realestate test suit

  @auPost
  Scenario: Realestate end to end
    Given I go to "australia post" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset