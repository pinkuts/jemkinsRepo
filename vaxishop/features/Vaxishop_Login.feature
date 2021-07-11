Feature: Vaxishop Login scenarios

  @100
  Scenario: Validate Vaxishop login feature using valid credentials.
    Given I am on Vaxishop login page
    When I enter valid userID 'Uatuser1' and password 'Pass@123'
    And I select a valid account 'Barrie Dear Limited (10182198)' and click on Continue button
    Then I navigate to the Vaxishop home page

  @200
  Scenario: Validate Vaxishop login feature using invalid credentials.
    Given I am on Vaxishop login page
    When I enter invalid userID and password
    Then I get the login failure error message

  @300
  Scenario Outline: Validate Vaxishop login feature using valid credentials.
    Given I am on Vaxishop login page
    When I enter valid userID and password from dataTable
      | userName | password |
      | Uatuser1 | Pass@123 |
    Then I click on '<account>'
    Then I validate page navigates to '<url>' and contains '<title>'

    Examples: 
      | account                             | url                                                            | title    |
      | 12PointCare Ltd (10248359)          | https://uk.stg.vaxishop.co.uk/vaxishop/en/GBP/category/NonFlu/ | vaxishop |
      | 49 Marine Avenue Surgery (10177691) | https://uk.stg.vaxishop.co.uk/vaxishop/en/GBP/category/NonFlu/ | vaxishop |
      | Dr A Hussain (10172839)             | https://uk.stg.vaxishop.co.uk/vaxishop/en/GBP/category/NonFlu/ | vaaxishop |
