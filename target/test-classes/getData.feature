@getService
Feature: API get request Testing for PetStore
  As a user
  I want to to be able get pet data from store
  So that I can validate that API functionality

  Scenario: Validate post request
    Given I have base uri
    When I execute "post" request to add Title and Body in Application
#    When I execute post request to add pet in store
    Then I should see status code as "201"

  Scenario: Validate get request
    Given I have base uri
    When I execute "get" request to add Title and Body in Application
#    When I execute get request by pet Id
    Then I should see status code as "404"

  Scenario: Validate delete request
    Given I have base uri
    When I execute "delete" request to add Title and Body in Application
#    When I execute delete request by pet Id
    Then I should see status code as "200"
    When I execute "get" request to add Title and Body in Application
#    And I execute get request by pet Id
    And I should see status code as "404"

