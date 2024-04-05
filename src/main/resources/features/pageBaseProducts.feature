#run tests via arrow in TestRunner or mvn test or via arrow in feature file

@setUp #tags
Feature: Products page functionality

  @DoTest
  Scenario: User sorts products by name
    Given User is on "Products" page
    When User clicks "sort button" button
    And User clicks "nameAsc" button
    Then First product title is "Sauce Labs Backpack"

  @Skip
  Scenario: Broken test
    Given User is on "Products" page
    Then First product title is "Sauce Labs Backpack"