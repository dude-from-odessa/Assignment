Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios
  @positive
  Scenario: Positive scenarios for products search
    When he calls search endpoint for item "apple"
    And status code 200 checked
    Then he sees the results displayed for "apple" and check the "title" from body
    When he calls search endpoint for item "mango"
    And status code 200 checked
    Then he sees the results displayed for "mango" and check the "title" from body
    When he calls search endpoint for item "tofu"
    And status code 200 checked
    Then he sees the results displayed for "tofu" and check the "title" from body
    When he calls search endpoint for item "water"
    And status code 200 checked
    Then he sees the results displayed for "water" and check the "title" from body

  @negative
  Scenario: Negative scenarios for product search
    When he calls search endpoint for item "car"
    And status code 404 checked
    Then he does not see the results and object "detail" has key "error" with status true
    When he calls search endpoint for item "chair"
    And status code 404 checked
    Then he does not see the results and object "detail" has key "error" with status true
