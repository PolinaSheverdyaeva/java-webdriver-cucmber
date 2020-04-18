@java
Feature: Java steps

  @java1
  Scenario: Hello world
    Given I say hello world
    And I say "hello again"
    When I say "my message"
    Given I perform actions with "hello world" and "hello w"
    Given I print url for "yahoo" page
    And I "I have finished home work 4!"
    When I count to "100"
    When I call you "Polina"
    Given I perform actions with  numbers "10" and "5"
#      Day 5 homework
    Given I print if number "35" is positive
    And I print "7" days of week using array


  @java2
  Scenario: Arrays
    Given I work with arrays

  @java3
  Scenario: Maps
    Given I work with maps

  @java4
  Scenario: Challenges
    Given I solve  coding challenges

  @java5
  Scenario Outline: Arrays from Katya
    Given Trying to solve tasks
    And I find element that appears once in array "<array>"
    And I compute number of trailing zeros in factorials - "<input>"
    Examples:
      |  array      | input |
      | [2,2,1]     | 3     |
      | [4,1,2,1,2] | 5     |




